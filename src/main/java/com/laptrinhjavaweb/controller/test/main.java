package com.laptrinhjavaweb.controller.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class main {

    static String string = "{\n" +
            "    \"title\": \"Bài viết 4\",\n" +
            "    \"content\": \"Bài viết 4\",\n" +
            "    \"categoryId\": 1\n" +
            "}";
//
//    public static void main(String[] args) {
//        main main = new main();
//        // Creating a Gson Object
//        Gson gson = new Gson();
//
//        // Converting json to object
//        // first parameter should be prpreocessed json
//        // and second should be mapping class
//        NewsModel newsModel
//                = gson.fromJson(string,
//                NewsModel.class);
//        System.out.println(newsModel.getTitle());
//        System.out.println(newsModel.getContent());
//        System.out.println(newsModel.getCategoryId());
//
//    }
    
    public static <T> void get(Class<T> tClass){
        System.out.println(tClass);
        System.out.println(tClass.getClasses());
        System.out.println(tClass.getComponentType());
    }

    public <T> void hoanVi(T a, T b) {
        T temp = a;
        a = b;
        b = temp;
    }

    public void fileWrite(String path, String data) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file, true);
        if(fw == null){

        }else{
            fw.write(data);

            fw.close();
        }

    }



    public static void main(String[] args) {
        main m = new main();
        SimpleDateFormat formatter = new SimpleDateFormat("E dd/MM/yyyy HH:mm:ss a");
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        System.out.println(formatter.format(date));
        try {
            m.fileWrite("D:\\Logserver\\log.txt", formatter.format(date) + " lequangnhu \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
