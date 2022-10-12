package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver = null;

    public BasePage(WebDriver webdriver){
        this.driver= webdriver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
