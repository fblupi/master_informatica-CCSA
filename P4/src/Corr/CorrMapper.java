package oldapi;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class CorrMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, Text> {
        private static final int MISSING = 9999;
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
                String line = value.toString();
                String[] parts = line.split(",");
                int cols = parts.length - 1;
                for (int i = 0; i < cols; i++) {
                        for (int j = i + 1; j < cols; j++) {
                                output.collect(new Text(Integer.toString(i) + "," + Integer.toString(j)), new Text(parts[i] + "," + parts[j]));
                        }
                }
        }
}
