package com.mmall.test;

import java.io.*;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class BufferedReaderDemo {

    public static void main(String[] args) throws IOException {

        FileReader reader = new FileReader("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        FileWriter fileWriter =new FileWriter("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String line = "";
        while ((line=bufferedReader.readLine())!=null){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            System.out.println(line);
        }

        reader.close();
        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();



    }


}

