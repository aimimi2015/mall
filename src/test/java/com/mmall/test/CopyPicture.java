package com.mmall.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class CopyPicture {

    public static void main(String[] args){
        copypic();
    }

    public static void copypic(){

        FileInputStream fileInputStream =null;
        FileOutputStream fileOutputStream =null;

        try {
            fileInputStream = new FileInputStream("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp");

            fileOutputStream = new FileOutputStream("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index4.jsp");

            byte[] copy = new byte[1024];

            int len =0;
            while ((len=fileInputStream.read(copy))!=-1){

                fileOutputStream.write(copy,0,len);



            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
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

