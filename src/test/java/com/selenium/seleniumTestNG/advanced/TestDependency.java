package com.selenium.seleniumTestNG.advanced;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDependency {
    //Hard Dependency only dependsOnMethods = "name of test method"
    //Soft Dependency add alwaysRun=true

    @Test
    public void userRegistration(){
        System.out.println("userRegistration");
        Assert.assertTrue(false);
    }
    //ten test uruchomi się dopiero wtedy jak pierwsza metoda przejdzie
    @Test(dependsOnMethods = "userRegistration", alwaysRun = true)
    public void userSearch(){
        System.out.println("userSearch");
    }

    @Test
    public void test3(){
        System.out.println("This is test3");
    }

    @Test
    public void test4(){
        System.out.println("This is test4");
    }
}
