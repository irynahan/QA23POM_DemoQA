package com.telran.demoqa.tests;

import com.telran.demoqa.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p) {
        logger.info("Start test: " + m.getName());
        if (p.length != 0) {
            logger.info(" --> With data: " + Arrays.asList(p));
        }
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("Test result: PASSED");
        } else {
            logger.error("Test result: FAILED");
            String screen = "screenshots/screen-" + (System.currentTimeMillis()/1000%3600 + ".png");
            new PageBase(driver).takeScreenshot(screen);
        }
        logger.info("Stop test: " + result.getMethod().getMethodName());
        logger.info("===========================================================");
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }
}
