package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;


public class WebDriverUtils {

    private static WebDriver driver;
    private static final int implicitlyWaitTimeOut = 3;

    private WebDriverUtils(){}

    public static WebDriver getWebDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(implicitlyWaitTimeOut, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static int getImplicitlyWaitTimeOut() {
        return implicitlyWaitTimeOut;
    }

    public static void stop() {
        if (driver!= null) {
            driver.close();
        }
        driver = null;
    }
    public static void OpenUrl(String url) {
        getWebDriver().get(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
    }

    public static  void  AlertSwitchTo(){
        new WebDriverWait(driver, 3).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
    }





}
