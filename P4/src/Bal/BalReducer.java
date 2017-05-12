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

public class BalReducer extends MapReduceBase implements Reducer<Text, DoubleWritable, Text, DoubleWritable> {
	public void reduce(Text key, Iterator<DoubleWritable> values, OutputCollector<Text, DoubleWritable> output, Reporter reporter) throws IOException {
		int zeros = 0, ones = 0;
		while (values.hasNext()) {
			if (values.next().get() == 0) {
				zeros++;
			} else {
				ones++;
			}
		}
		double ratio = (zeros > ones) ? (double) zeros / ones : (double) ones / zeros;
		output.collect(key, new DoubleWritable(ratio));
	}
}

