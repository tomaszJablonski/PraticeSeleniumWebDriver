package com.selenium.seleniumTestNG.restAssured.frameworkDevelopment.api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "AllData")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//userDataRestAssuredFrameworkDevelopment.xlsx";
        XLUtility xlUtility = new XLUtility(path);

        int rowNumber = xlUtility.getRowCount("Sheet1");
        int colNumber = xlUtility.getCellCount("Sheet1", 1);

        String[][] apiData = new String[rowNumber][colNumber];

        for (int i = 1; i <= rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                apiData[i - 1][j] = xlUtility.getCellData("Sheet1", i, j);
            }
        }
        return apiData;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//userDataRestAssuredFrameworkDevelopment.xlsx";
        XLUtility xlUtility = new XLUtility(path);

        int rowNumber = xlUtility.getRowCount("Sheet1");

        String[] apiData = new String[rowNumber];

        for (int i = 1; i <= rowNumber; i++) {
            apiData[i - 1] = xlUtility.getCellData("Sheet1", i, 1);

        }
        return apiData;
    }
}