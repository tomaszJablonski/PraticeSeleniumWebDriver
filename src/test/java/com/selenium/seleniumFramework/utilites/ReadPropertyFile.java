package com.selenium.seleniumFramework.utilites;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\seleniumFrameworkConfigFiles\\config.properties");
        Properties properties = new Properties();
        properties.load(fileReader);

        System.out.println(properties.getProperty("url"));
    }
}
