package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormHelper {
    public static WebElement findElement(By by, WebDriver driver){
        return driver.findElement(by);
    }
    public static void click(By by, WebDriver driver){
        FormHelper.findElement(by, driver).click();
    }
    public static void sendKeys(By by, WebDriver driver, String text){
        WebElement element = FormHelper.findElement(by,driver);
        element.clear();
        element.sendKeys(text);
    }
    public static void sendKeys(By by, WebDriver driver, Keys key){
        WebElement element = FormHelper.findElement(by,driver);
        element.sendKeys(key);
    }
    public static void clear(By by, WebDriver driver){
        WebElement element = FormHelper.findElement(by,driver);
        element.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public static String getElementValue(By by,WebDriver driver){
        WebElement element = FormHelper.findElement(by,driver);
        return element.getText();
    }
    public static boolean isEnabled(By by,WebDriver driver){
        WebElement element = FormHelper.findElement(by,driver);
        String classList = element.getAttribute("class");
        if(classList.contains("disabled"))
            return false;
        return true;
    }
    public static int getChildsCount(By by, WebDriver driver){
        return driver.findElements(by).size();
    }
}
