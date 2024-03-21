package com.javaForTesters;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromXLS {
    public static void main(String[] args) {

        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\javaForTesters\\data\\Data1.xlsx");

        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet sheet0 = workbook.getSheetAt(0);

//            Row row0 = sheet0.getRow(0);
//            Cell cell0 = row0.getCell(0);
//            System.out.println(cell0);

            for (Row row : sheet0) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> System.out.print(cell.getStringCellValue() + " ");
                        case BOOLEAN -> System.out.print(cell.getBooleanCellValue()+ " ");
                        case NUMERIC -> System.out.print(cell.getNumericCellValue()+ " ");
                        default -> System.out.print("There is not date of this type");
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }
}
