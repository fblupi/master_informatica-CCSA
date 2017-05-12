package oldapi;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class StatParReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
		double sum = 0;
		int size = 0;
		Double minValue = Double.MAX_VALUE;
		Double maxValue = Double.MIN_VALUE;
		while (values.hasNext()) {
			Double next = values.next().get();
			maxValue = Math.max(maxValue, next);
			minValue = Math.min(minValue, next);
			sum += next;
			size++;
		}
		Double avg = sum / size;
		output.collect(new Text("Max (" + key + ")"), new DoubleWritable(maxValue));
		output.collect(new Text("Min (" + key + ")"), new DoubleWritable(minValue));
		output.collect(new Text("Avg (" + key + ")"), new DoubleWritable(avg));
	}
}

