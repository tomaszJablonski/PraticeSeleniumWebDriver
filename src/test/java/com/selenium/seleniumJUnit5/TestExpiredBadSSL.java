package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClass;
import org.junit.jupiter.api.Test;

public class TestExpiredBadSSL extends BaseClass {

    // edgeOptions.setAcceptInsecureCerts(true); in base class

    @Test
    public void handleSSLCertificate() throws InterruptedException {
        driver.get("https://expired.badssl.com/");
        Thread.sleep(2000);
    }
}