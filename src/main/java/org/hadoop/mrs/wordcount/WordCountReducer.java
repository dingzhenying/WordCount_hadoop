package org.hadoop.mrs.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Text 输入的key的类型
 * IntWritable 输入的value的类型
 * Text 输出的key类型
 * IntWritable 输出的value类型
 *
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    /**
     *
     * @param key 输入map的key
     * @param values 输入map的value
     * @param context 输出
     * @throws IOException 异常
     * @throws InterruptedException 异常
     */
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for (IntWritable value : values) {
            count += value.get();
        }
        System.out.println("count"+count);
        context.write(key, new IntWritable((count)));
    }
}