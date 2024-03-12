package com.selenium.seleniumTestNG.advanced.commons;

import com.selenium.seleniumTestNG.advanced.utils.CaptureScreenShoot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class ListenersAdv extends CaptureScreenShoot implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.setProperty("org.uncommons.reportng.title","Testing Listeners");
        Reporter.log("Method name is - " + result.getName());
        System.out.println("Test case is started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Status of execution is - " + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed - screenshot captured");
        try {
            screenShoot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("X:\\NAUKA TESTOWANIA\\Projekty\\PraticeSelenium\\src\\test\\java\\com\\selenium\\seleniumTestNG\\advanced\\screenshot\\" + getScreenShotCurrentDate() + ".png");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}


