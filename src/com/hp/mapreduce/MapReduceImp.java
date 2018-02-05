package com.hp.mapreduce;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.management.loading.PrivateClassLoader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.hp.util.HDFSUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;


public class MapReduceImp {
	public static class CherishMap extends Mapper<Object, Text, Text, Text>{
		private Text keyResult=new Text();
		//因为这里返回的值为Text所以这里是用来存放返回的值
		private Text result = new Text();
		@Override
		protected void map(Object key, Text value, Mapper<Object, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			String [] values=value.toString().split("\t");
			keyResult.set(values[0]);
			//将其要比对的值作为value
			result.set(values[1]);
			context.write(keyResult, result);
		}
	}
	public static class CherishReduce extends Reducer<Text, Text, Text, Text>{
		private static Text result = new Text();
		@Override
		protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			int max=0;
			String tmp=null;
			for(Text rs:values) {
				String [] val=rs.toString().split("\\|");
				int rsult=Integer.parseInt(val[1]);
				if (rsult>max) {
					max=rsult;
					result=rs;
				}
			}
			context.write(key,result); 
		}
	}
	public static void start(String path) throws Exception{
//		System.setProperty("HADOOP_USER_NAME", "cherish");
//		System.setProperty("hadoop.home.dir", "F:\\centOs6.5文件\\hadoop-2.6.5");
		Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, "hadoop");
	    job.setJarByClass(MapReduceImp.class);
	    job.setMapperClass(CherishMap.class);
	    job.setCombinerClass(CherishReduce.class);
	    job.setReducerClass(CherishReduce.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(Text.class);
	    FileInputFormat.addInputPath(job, new Path(path));
		FileOutputFormat.setOutputPath(job, new Path("/user/hadoop/output"));
	    job.waitForCompletion(true);
	}
}