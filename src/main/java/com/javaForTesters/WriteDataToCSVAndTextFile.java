package com.javaForTesters;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class WriteDataToACSVAndTextFile {
    public static void main(String[] args) throws IOException {
        
        File file = new File("System.getProperty("user.dir") + "\\src\\main\\resources\\TestData1TXT.txt");

        //Step 1: Create an object of FileWriter class
        FileWriter fileWriter = new FileWriter(file);

        //Step 2: Create object of BufferWriter class
        BufferWriter bufferWriter = new BufferWriter(fileWriter);

        //Step 3: write data
        bufferWriter.write("testowy tekst")

        //Step 4: close the file
        bufferWriter.close;


    }
}