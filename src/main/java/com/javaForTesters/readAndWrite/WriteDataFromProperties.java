package com.javaForTesters.readAndWrite;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class WriteDataFromProperties {
    public static void main(String[] args) throws IOException {
        //location of the project on the computer.
        // No Hard coding path of the file path in the hard drive
        System.out.println(System.getProperty("user.dir"));

        //Step 1: Create an object of FileWriter class
        FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + "\\src\\main\\resources\\testData.properties",true);
        //or
        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testData.properties", true);

        //Step 2: Create an object of properties class
        Properties properties = new Properties();

        //Step3: Use set property method to set property
        System.out.println(properties.setProperty("url","www.youtube.pl"));
        properties.store(fileWriter,"Sample comments");
    }
}