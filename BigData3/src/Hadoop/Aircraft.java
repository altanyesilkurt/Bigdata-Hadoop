package Hadoop;
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import Hadoop.Aircraft.Map;
import Hadoop.Aircraft.Map.Reduce;
public class Aircraft {

	public static class Map extends Mapper<LongWritable, Text, Text, LongWritable> {
		private Text word = new Text();
		  private LongWritable count = new LongWritable();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        
            String[] split = value.toString().split("\t");
            word.set(split[0]);
            if (split.length > 1) {
              try {
                count.set(Long.parseLong(split[1]));
                context.write(word, count);
              } catch (NumberFormatException e) {
                // cannot parse - ignore
              }
        }
    }

    public static class Reduce <KEY> extends Reducer<KEY, LongWritable,KEY,LongWritable> {
    	 
               private LongWritable result = new LongWritable();

public void reduce(KEY key, Iterable<LongWritable> values,Context context) throws IOException, InterruptedException {
    long sum = 0;
for (LongWritable val : values) {
     sum += val.get();
  }
   result.set(sum);
   context.write(key, result);
}

    }
    
	public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "aircraft");
        job.setJarByClass(Aircraft.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setNumReduceTasks(1);
        FileInputFormat .setInputPaths(job, new Path(args[1]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        boolean success = job.waitForCompletion(true);
        System.out.println(success);
}
   
}
}
