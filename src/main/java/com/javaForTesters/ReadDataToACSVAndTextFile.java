package com.javaForTesters;

import java.io.*;

public class ReadDataToACSVAndTextFile {

    public static void main(String[] args) throws IOException {
        readTxtFile();
        readCSVFile();
    }

    public static void readTxtFile() throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData1TXT.txt");

        //Step 1: Create an object of FileReader class
        FileReader fileReader = new FileReader(file);

        //Step 2: Create object of BufferReader class
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Step 3: read data
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());

        //Step 4: close the file
        System.out.println("Reading successfully");
        bufferedReader.close();
    }

    public static void readCSVFile() throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData1TXT.csv");

        //Step 1: Create an object of FileReader class
        FileReader fileReader = new FileReader(file);

        //Step 2: Create object of BufferReader class
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Step 3: read data
        System.out.println(bufferedReader.readLine());

        //Step 4: close the file
        System.out.println("Reading successfully");
        bufferedReader.close();
    }
}