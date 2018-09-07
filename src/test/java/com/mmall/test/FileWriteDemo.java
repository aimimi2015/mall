package com.mmall.test;

import javax.print.DocFlavor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jiangxiao on 2018/8/29.
 */
public class FileWriteDemo {

//    public static void main(String[] args) throws IOException {
//        FileWriter fileWriter = new FileWriter("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp");
//
//        fileWriter.write("hello world");
//
//        fileWriter.flush();
//        fileWriter.write("first_test");
//        fileWriter.close();
//
//
//    }


//    public static void main(String[] args){
////        characters();
//
//        singleReader();
//    }

    
    /**
      * @description 用buffer进行读取
      * @params 
      * @return 
      * @author 姜晓
      * @date 2018/8/29 上午10:09
      */
    private static void characters(){

        try {
            FileReader fileReader = new FileReader("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp");

            char[] buf = new char[6];
            int num = 0;

            while ((num =fileReader.read(buf))!=-1){


                System.out.println(new String(buf,0,num));

            }
            System.out.println('\n');
            fileReader.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    
    /**
      * @description  用单个字符和字符数组进行分别读取
      * @params 
      * @return 
      * @author 姜晓
      * @date 2018/8/29 上午10:09
      */
//    private static void singleReader(){
//
//        try {
//            FileReader fileReader = new FileReader("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp");
//
//            int ch =0;
//            while ((ch=fileReader.read())!=-1){
//                System.out.println((char)ch);
//            }
//            System.out.println('\n');
//
//            fileReader.close();
//
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
        /**
          * @description 对已有文件的数据进行续写
          * @params
          * @return 
          * @author 姜晓
          * @date 2018/8/29 上午10:12
          */
//    public static void main(String[] args){
//
//        try {
//            FileWriter fileWriter = new FileWriter("/Users/Iverson/IdeaProjects/mall/src/main/webapp/index2.jsp",true);
//
//            fileWriter.write("new");
//            fileWriter.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }









}

