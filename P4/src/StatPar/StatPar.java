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

public class StatPar {
	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.err.println("Usage: StatPar <input path> <output path> <col>");
			System.exit(-1);
		}
		JobConf conf = new JobConf(StatPar.class);
		conf.setJobName("StatPar");
		FileInputFormat.addInputPath(conf, new Path(args[0]));
		FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		conf.set("col", args[2]);
		conf.setMapperClass(StatParMapper.class);
		conf.setReducerClass(StatParReducer.class);
		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(DoubleWritable.class);
		JobClient.runJob(conf);
	}
}

