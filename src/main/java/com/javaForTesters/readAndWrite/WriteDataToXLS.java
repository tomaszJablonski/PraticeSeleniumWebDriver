package com.javaForTesters.readAndWrite;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteDataToXLS {
    public static void main(String[] args){
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\javaForTesters\\data\\TestData1.xlsx");

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream fileOutputStream = new FileOutputStream(file)
        ){
            XSSFSheet sheet1 = workbook.createSheet("Sheet 1");
            Row row0 = sheet1.createRow(0);
            Cell cell0 = row0.createCell(0);
            cell0.setCellValue("Test Cell");
            Cell cell1 = row0.createCell(1);
            cell1.setCellValue("Test Name");

            Row row1 = sheet1.createRow(1);
            Cell cell2 = row1.createCell(1);
            cell2.setCellValue("Test Cell 1 ");

            Cell cell3 = row1.createCell(0);
            cell3.setCellValue("Test Cell 0");

            workbook.write(fileOutputStream);

            // jak by nie było w try with resources to trzeba
            // ręcznie zamknąć workbook.close();
            // fileOutputStream.close();
            System.out.println("File is written successfully");
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
