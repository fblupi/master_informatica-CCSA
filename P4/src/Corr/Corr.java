package oldapi;
import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class Corr {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Usage: Corr <input path> <output path>");
			System.exit(-1);
		}
		JobConf conf = new JobConf(Corr.class);
		conf.setJobName("Corr");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(CorrMapper.class);
		conf.setReducerClass(CorrReducer.class);
		conf.setMapOutputKeyClass(Text.class);
		conf.setMapOutputValueClass(Text.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		JobClient.runJob(conf);
	}
}

