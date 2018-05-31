package Hadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 * @author milind
 */
public class GlobalNumberAverage {

 public static class GlobalNumberAverageMapper
 extends Mapper < Object, Text, Text, DoubleWritable > {

  int sum = 0;
  int count = 0;

  public void map(Object key, Text value, Mapper.Context context) throws IOException,
  InterruptedException {
   StringTokenizer itr = new StringTokenizer(value.toString());
   while (itr.hasMoreTokens()) {
    String str = itr.nextToken();
    sum = sum + Integer.parseInt(str);
    count += 1;
   }
  }

  public void cleanup(Mapper.Context context) throws IOException,
  InterruptedException {
   context.write(new Text("Average of numbers is"), new DoubleWritable(sum / count));
  }
 }

 public static void main(String[] args) throws Exception {
  Configuration conf = new Configuration();
  Job job = Job.getInstance(conf, "Global Average of Numbers");
  job.setJarByClass(GlobalNumberAverage.class);
  job.setMapperClass(GlobalNumberAverageMapper.class);
  job.setNumReduceTasks(0);
  job.setOutputKeyClass(Text.class);
  job.setOutputValueClass(DoubleWritable.class);
  FileInputFormat.addInputPath(job, new Path(args[1]));
  FileOutputFormat.setOutputPath(job, new Path(args[2]));
  System.exit(job.waitForCompletion(true) ? 0 : 1);
 }
}