package com.mmall.test;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jiangxiao on 2018/8/29.
 */

public class IoTest {
    public static void main(String[] args) {

        IoTest ioTest = new IoTest();

        String filePath = "/Users/Iverson/IdeaProjects/mall/src/main/webapp/index.jsp";

        String result = ioTest.readFile(filePath);
        System.out.println(result);

    }

    /**
      * @description 
      * @params
      * @return 
      * @author 姜晓
      * @date 2018/8/29 上午9:07
      */
    public String readFile(String filePath) {

        FileInputStream fileInputStream = null;

        String result = "";

        try {
            fileInputStream = new FileInputStream(filePath);

            int size = fileInputStream.available();

            byte[] array = new byte[size];
            fileInputStream.read(array);
            return new String(array);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return result;

    }

}

