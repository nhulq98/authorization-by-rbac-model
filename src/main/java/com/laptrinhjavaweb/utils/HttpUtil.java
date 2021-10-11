package com.laptrinhjavaweb.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {

    private String value;

    public HttpUtil(){

    }

    public HttpUtil(String value){
        this.value = value;
    }

    public <T> T mappingModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(this.value, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> String toJSON(T object){

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            //Converting the Object to JSONString
            jsonString = mapper.writeValueAsString(object);
        }catch (IOException e){
            e.printStackTrace();
        }

        return jsonString;
    }

    public static String convertToString(BufferedReader Reader){
        StringBuffer sb = new StringBuffer();
        try {

            String str;
            while((str = Reader.readLine())!= null){
                sb.append(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(Reader != null)
                    Reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    public static HttpUtil of(BufferedReader Reader){
        StringBuffer sb = new StringBuffer();
        try {

            String str;
            while((str = Reader.readLine())!= null){
                sb.append(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(Reader != null)
                    Reader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        
        return new HttpUtil(sb.toString());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
