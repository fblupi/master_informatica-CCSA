package oldapi;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class CorrReducer extends MapReduceBase implements Reducer<Text, Text, Text, DoubleWritable> {
	public void reduce(Text key, Iterator<Text> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
		double sumX = 0, sumY = 0, sumXX = 0, sumYY = 0, sumXY = 0, size = 0;
		while (values.hasNext()) {
			String line = values.next().toString();
			String[] parts = line.split(",");
			double x = Double.parseDouble(parts[0]);
			double y = Double.parseDouble(parts[1]);
			sumX += x;
			sumY += y;
			sumXX += x * x;
			sumYY += y * y;
			sumXY += x * y;
			size++;
		}
		double medX = sumX / size;
		double medY = sumY / size;
		double cov = sumXY / size - medX * medY;
		double desX = Math.sqrt(sumXX / size - medX * medX);
		double desY = Math.sqrt(sumYY / size - medY * medY);
		double corr = cov / (desX * desY);
		output.collect(key, new DoubleWritable(corr));
	}
}

