package org.hadoop.test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: dingzhenying
 * Date: 2018-02-12
 * Time: 22:48
 */
public class Filetest {
    public static void main (String [] args) throws IOException{
         File file =new File("D:\\Hadoop\\upload\\words.txt");
         String name = file.getName();
         //获取文件属性
         System.out.println("name:"+name);
        //获取大小
        long length=file.length();
        System.out.println("长度：+"+length);
        //最后修改时间
        long time=file.lastModified();
        Date date =new Date(time);
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("last date : "+sdf.format(date));
        //判断是否为文件
        boolean isFile =file.isFile();
        System.out.println("isFile:"+isFile);
        //是否为文件夹
        boolean isDir =file.isDirectory();
        System.out.println("isDir:"+isDir);
        //是否隐藏
        System.out.println("是否隐藏："+file.isHidden());
        //创建文件
        File file2=new File("D:\\Hadoop\\upload\\creattest1.txt");
        File file2_1=new File("D:\\Hadoop\\upload\\creattest2.txt");
        if (!file2.exists()){
            file2.createNewFile();
            System.out.println("文件"+file2.getName()+"创建成功");
            file2_1.createNewFile();
            System.out.println("文件"+file2_1.getName()+"创建成功");
        }
//        删除文件
        File file3 =new File("D:\\Hadoop\\upload\\creattest2.txt");
        file3.delete();
        System.out.println("文件删除成功");


    //--------------------------------------------
    //创建目录
    File dir =  new File("."+File.separator+"FileDir"+File.separator+"aa");
        if(!dir.exists()){
        dir.mkdir();
        System.out.println("创建aa目录成功！");
    }
    //创建多级目录
    File dir2 = new File("."+File.separator+"FileDir"+File.separator
            +"aa"+File.separator+"c"+File.separator+"d");
        if(!dir2.exists()){
        dir2.mkdirs();
        System.out.println("make dirs");
    }
    //删除目录  删除目录，只能删除空目录
    File dir3 = new File("."+File.separator+"FileDir"+File.separator
            +"aa"+File.separator+"c"+File.separator+"d");
        if(dir3.exists()){
        dir3.delete();
        System.out.println("删除d目录");
    }
    //获取一个目录下的所有子项
    File dir4 = new File("."+File.separator+"FileDir");
    File [] files = dir4.listFiles();
        for(File f : files){
        System.out.println((f.isFile() ? "文件：" :"目录：")+f.getName());
    }
    //获取过滤之后的文件
    File dir5 = new File("."+File.separator+"FileDir");
    File [] fs = dir4.listFiles(new FileFilter() {

        public boolean accept(File file) {
            System.out.println("正在过滤："+file.getName());
            return file.getName().startsWith("t");
        }
    });
        for(File f : fs){
        System.out.println("t开头的文件有："+f.getName());
    }
    //递归删除目录所有文件
    File dir6 = new File("."+File.separator+"FileDir"+File.separator+"b");
    deleteFile(dir6);
    }

    //递归删除文件
    public static void deleteFile(File file){
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for(File f : files){
                deleteFile(f);
            }
        }
        file.delete();
    }



}