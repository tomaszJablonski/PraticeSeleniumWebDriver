package com.selenium.seleniumFramework.utilites;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadXLSData {

    @DataProvider(name = "Data Login from Xls")
    public String[][] getData(Method m) throws IOException {
        String excelSheetName = m.getName();
        File xlsFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\seleniumFrameworkTestData\\testData.xlsx");
        FileInputStream fileInputStream = new FileInputStream(xlsFile);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheetName = workbook.getSheet(excelSheetName);

        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalColumns = rowCells.getLastCellNum();
        System.out.println(totalColumns);

        DataFormatter formatter = new DataFormatter();
        String[][] testData = new String[totalRows][totalColumns];

        for(int i=1; i<=totalRows;i++){
            for (int j=0; j<totalColumns;j++){
                testData[i-1][j] = formatter.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.print(testData[i-1][j] + " ");
            }
            System.out.println();
        }
        return testData;
    }
}