package com.mmall.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class IoWrite {


    @Test
    public void test(){
        String filePath = "/Users/Iverson/IdeaProjects/mall/src/main/webapp/index.jsp";
        String filePathNew = "/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp";

        IoWrite ioWrite = new IoWrite();
        ioWrite.copyFile(filePath,filePathNew);
    }


    public void copyFile(String filePath, String filePathNew) {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(filePath);

            int size = fileInputStream.available();

            byte[] array = new byte[size];
            fileInputStream.read(array);
            fileOutputStream = new FileOutputStream(filePathNew);

            fileOutputStream.write(array);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}

