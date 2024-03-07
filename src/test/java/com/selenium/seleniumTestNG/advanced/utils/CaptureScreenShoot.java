package com.selenium.seleniumTestNG.advanced.utils;

import com.selenium.seleniumTestNG.advanced.commons.BaseClassTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CaptureScreenShoot extends BaseClassTest {

    public void screenShoot() throws IOException {
        Date currentDate = new Date();
        String screenShotCurrentDate = currentDate.toString().replace(" ", "-").replace(":", "-");
        System.out.println(screenShotCurrentDate);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File("./src/test/java/com/selenium/seleniumTestNG/advanced/screenshot/" + screenShotCurrentDate + ".png"));
    }
}
