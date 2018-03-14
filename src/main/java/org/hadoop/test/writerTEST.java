package org.hadoop.test;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: dingzhenying
 * Date: 2018-02-12
 * Time: 23:37
 */
public class writerTEST {

    public void read01() throws IOException{
        RandomAccessFile  src =new RandomAccessFile("D:\\Hadoop\\upload\\words.txt","rw");
        RandomAccessFile  desc =new RandomAccessFile("D:\\Hadoop\\upload\\creattest1.txt","rw");
        byte[] b=new byte[1024*10];
        int len =-1;
        long start =System.currentTimeMillis();
        while((len=src.read(b))!=-1){
            /**
             * void write(byte[] data,int offset,int len)
             * 将当前数组中从offset指定位置开始，连续len个字节写出
             */
            desc.write(b,0, len);

        }
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end-start));
        src.close();
        desc.close();

    }


}
