package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClassTest;
import org.junit.jupiter.api.Test;

public class TestExpiredBadSSL extends BaseClassTest {

    // edgeOptions.setAcceptInsecureCerts(true); in base class

    @Test
    public void handleSSLCertificate() throws InterruptedException {
        driver.get("https://expired.badssl.com/");
        Thread.sleep(2000);
    }
}