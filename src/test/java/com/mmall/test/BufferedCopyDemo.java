package com.mmall.test;

import java.io.*;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class BufferedCopyDemo {

    public static void main(String[] args){

    }

    public static void copy(){

        BufferedInputStream bis = null;
        BufferedOutputStream bos =null;
        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp"));

            bos = new BufferedOutputStream(new FileOutputStream("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index5.jsp"));

            int buf = 0;
            while ((buf = bis.read())!=-1){
                bos.write(buf);
                bos.flush();
            }







        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if(bis != null|bos!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


}

