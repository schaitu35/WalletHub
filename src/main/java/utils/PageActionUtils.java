package utils;

import driverFactory.DriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PageActionUtils {

    public static void click(By element){
        try {
            getElement(element).click();
            ExtentLogger.pass("Element Clicked " + element.toString());
        } catch (ElementClickInterceptedException clickInterceptedException){
            ExtentLogger.fail("Click Intercepted ", clickInterceptedException.fillInStackTrace());
        }

    }

    public static void typeIntoTextBox(By element, String text){
        try {
            getElement(element).sendKeys(text);
            ExtentLogger.pass( text + "  entered Successfully");
        }catch (ElementNotInteractableException notInteractableException){
            ExtentLogger.fail("Click Intercepted ", notInteractableException.fillInStackTrace());
        }

    }

    public static String getElementText(By element){
        return getElement(element).getText();
    }

    public static void moveToElement(By element){
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(getElement(element)).build().perform();
        } catch (Exception exception){
            ExtentLogger.fail(" Exception Occurred while locating element", exception.fillInStackTrace());
        }


    }

    public static void scrollToView(By element){
        JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
        executor.executeScript("arguments[0].scrollIntoView(true);", getElement(element));

    }

    @SneakyThrows
    public static void scrollToTopByKey(){
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_HOME);

    }

    public static boolean isElementDisplayed(By element){
        return getElement(element).isDisplayed();
    }

    public static void navigateToAnotherUrl(String url){
        DriverManager.getDriver().get(url);
    }

    @SneakyThrows
    public static void waitToLoad(long milliSeconds){
        Thread.sleep(milliSeconds);
    }



    private static WebElement getElement(By element){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), 20);
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(element));
    }



}
