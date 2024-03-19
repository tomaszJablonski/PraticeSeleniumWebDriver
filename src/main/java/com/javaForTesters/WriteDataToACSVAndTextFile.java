package com.javaForTesters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToACSVAndTextFile {

    public static void main(String[] args) throws IOException {

        saveTxtFile();
        saveCSVFile();


    }

    public static void saveTxtFile() throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData1TXT.txt");

        //Step 1: Create an object of FileWriter class
        FileWriter fileWriter = new FileWriter(file, true);

        //Step 2: Create object of BufferWriter class
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

        //Step 3: write data
        bufferWriter.write("testowy tekst");

        //Step 4: close the file
        System.out.println("Written successfully");
        bufferWriter.close();
    }

    public static void saveCSVFile() throws IOException {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData1TXT.csv");

        //Step 1: Create an object of FileWriter class
        FileWriter fileWriter = new FileWriter(file, true);

        //Step 2: Create object of BufferWriter class
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);

        //Step 3: write data
        //columns
        for (int i = 0; i < 10; i++) {
            bufferWriter.write("testowy tekst" + ";");
        }
        //rows
        for (int i = 0; i < 10; i++) {
            bufferWriter.write("testowy tekst");
            bufferWriter.newLine();
        }

        //Step 4: close the file
        System.out.println("Written successfully");
        bufferWriter.close();
    }
}