package org.hadoop.mrs.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * LongWritable 行号 类型
 * Text 输入的value 类型
 * Text 输出的key 类型
 * IntWritable 输出的vale类型
 *
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,IntWritable> {
    /**
     *
     * @param key 行号
     * @param value 第一行的内容 如  this is a tests
     * @param context 输出
     * @throws IOException 异常
     * @throws InterruptedException 异常
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        //以空格分割获取字符串数组
        String[] words = line.split(" ");
        for (String word : words) {
            System.out.println(word);
            context.write(new Text(word),new IntWritable(1));
        }
//        String line = value.toString();
//        List<String> list= new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add( );
//
//            //array[i] = scan.nextInt();//给数组赋值
//        }


    }
}