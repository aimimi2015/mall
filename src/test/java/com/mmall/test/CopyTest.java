package com.mmall.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class CopyTest {

    public static void main(String[] args){


        copyTextDemo("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp","/Users/Iverson/IdeaProjects/mall/src/main/webapp/index3.jsp");

    }

    private static void copyTextDemo(String source,String destination){

        try {
            FileWriter writer = new FileWriter(destination);

            FileReader reader = new FileReader(source);

            char[] charbuf = new char[1024];
            int num=0;

            while ((num=reader.read(charbuf))!=-1){
                writer.write(new String(charbuf,0,num));
            }
            writer.close();
            reader.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}

