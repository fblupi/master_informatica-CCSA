package oldapi;
import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;

public class MaxMinAll {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Usage: MaxMinAll <input path> <output path>");
			System.exit(-1);
		}
		JobConf conf = new JobConf(MaxMinAll.class);
		conf.setJobName("MaxMinAll");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.setMapperClass(MaxMinAllMapper.class);
		conf.setReducerClass(MaxMinAllReducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		JobClient.runJob(conf);
	}
}

