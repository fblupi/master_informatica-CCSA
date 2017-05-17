package oldapi;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MinOpt extends Configured implements Tool {
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: MinOpt <input path> <output path>");
			System.exit(-1);
		}
		Configuration conf = new Configuration(true);
		Job job = Job.getInstance(conf, "MinOpt");
		job.setJarByClass(MinOpt.class);
		job.setMapperClass(MinOptMapper.class);
		job.setReducerClass(MinOptReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(DoubleWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		return job.waitForCompletion(true) ? 0 : 1;
	}
    public static void main(String[] args) throws Exception {
        int exitCode = ToolRunner.run(new MinOpt(), args);
        System.exit(exitCode);
    }
}

