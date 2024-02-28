package com.selenium;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestReadAndWriteDataFromProperties {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("X:\\NAUKA TESTOWANIA\\Projekty\\PraticeSelenium\\src\\test\\resources\\testdata.properties");
        properties.load(inputStream);
        //reading getProperty
        System.out.println(properties.getProperty("browser"));
        System.out.println(properties.getProperty("url"));

        FileOutputStream outputStream = new FileOutputStream("X:\\NAUKA TESTOWANIA\\Projekty\\PraticeSelenium\\src\\test\\resources\\testdata.properties");
        //write setProperty
        properties.setProperty("testDate","8542154585");
        properties.store(outputStream, "Add test customer id");
    }
}
