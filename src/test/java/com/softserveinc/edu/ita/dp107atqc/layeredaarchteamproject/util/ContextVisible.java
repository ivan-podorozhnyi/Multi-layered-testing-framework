package com.softserveinc.edu.ita.dp107atqc.layeredaarchteamproject.util;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ContextVisible {

    private ContextVisible() {}

    public static ContextVisible get() {
        return new ContextVisible();
    }

    public WebElement get(ControlLocation controlLocation) {
        WebDriverWait wait = new WebDriverWait(WebDriverUtils.getWebDriver(),
                WebDriverUtils.getImplicitlyWaitTimeOut());
        return wait.until(ExpectedConditions.visibilityOfElementLocated(controlLocation.getBy()));
    }

    public List<WebElement> getList(ControlLocation controlLocation) {
        WebDriverWait wait = new WebDriverWait(WebDriverUtils.getWebDriver(),
                WebDriverUtils.getImplicitlyWaitTimeOut());
        return wait.until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(controlLocation.getBy()));
    }
    public Alert getAlert() {
        WebDriverWait wait = new WebDriverWait(WebDriverUtils.getWebDriver(),
                WebDriverUtils.getImplicitlyWaitTimeOut());
         return wait.until(ExpectedConditions.alertIsPresent());
//        WebDriver driver = WebDriverUtils.getWebDriver();
//        driver.switchTo().alert();

    }

    public static boolean isElementPresentCheckByCss(String locator) {

        WebDriverUtils.getWebDriver().manage().timeouts().
                implicitlyWait(0, TimeUnit.SECONDS);
        boolean result = WebDriverUtils.getWebDriver().
                findElements(ControlLocation.getByCss(locator).getBy()).size() > 0;
        WebDriverUtils.getWebDriver().manage().timeouts().
                implicitlyWait(3, TimeUnit.SECONDS);
        return result;
    }


}
