package org.hadoop.files;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.hadoop.conf.Conf;

import java.io.*;
/**
 *
 *
 * @Author: dingzhenying
 * @Date: 2018/1/25
 * @Time: 13:59
 *
 *
 *
 */
public class Files {
//连接HDFS
    public static FileSystem getFiles() {
        //获得连接配置
        Configuration conf = Conf.get();
        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return fs;
    }

    /**
     * 创建文件夹
     */
    public static void mkdirFolder(String folderPath) {
        try {
            FileSystem fs = getFiles();
            fs.mkdirs(new Path(folderPath));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * 上传文件到hdfs
     *
     * @param localFolderPath 本地目录
     * @param fileName        文件名
     * @param hdfsFolderPath  上传到hdfs的目录
     */
    public static void uploadFile(String localFolderPath, String fileName, String hdfsFolderPath) {
        FileSystem fs = getFiles();
        try {
            InputStream in = new FileInputStream(localFolderPath + fileName);
            OutputStream out = fs.create(new Path(hdfsFolderPath + fileName));

            IOUtils.copyBytes(in, out, 4096, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * 从hdfs获取文件
     *
     * @param downloadPath     hdfs的路径
     * @param downloadFileName hdfs文件名
     * @param savePath         保存的本地路径
     */
    public static void getFileFromHadoop(String downloadPath, String downloadFileName, String savePath) {
        FileSystem fs = getFiles();
        try {
            InputStream in = fs.open(new Path(downloadPath + downloadFileName));
            OutputStream out = new FileOutputStream(savePath + downloadFileName);
            IOUtils.copyBytes(in, out, 4096, true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 删除文件
     * delete(path,boolean)
     * boolean如果为true，将进行递归删除，子目录及文件都会删除
     * false 只删除当前

     */
    public static void deleteFile(String deleteFilePath) {
        //获取连接
        FileSystem fs = getFiles();
        //要删除的文件路径
        try {
            Boolean deleteResult = fs.delete(new Path(deleteFilePath), true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}