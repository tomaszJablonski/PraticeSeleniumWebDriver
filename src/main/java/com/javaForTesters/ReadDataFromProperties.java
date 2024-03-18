package com.javaForTesters;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperties {
    public static void main(String[] args) throws IOException {
        //location of the project on the computer.
        // No Hard coding path of the file path in the hard drive
        System.out.println(System.getProperty("user.dir"));

        //Step 1: Create an object of FileReader class
        FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\testData.properties");
        //or
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\testData.properties");

        //Step 2: Create an object of properties class
        Properties properties = new Properties();

        //Step 3: Load the properties file
        properties.load(fileReader);
        //or
        properties.load(fileInputStream);

        //Step4: Use get property method to get property
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("website"));
    }
}