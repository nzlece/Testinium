package Base;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {

    private static WebDriver webDriver= null;
    private  final  static Logger  logger= Logger.getLogger(BaseTest.class);
    @BeforeAll
    public void initialize(){
        logger.info("#Initialize Test!");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https:/www.beymen.com/");

    }
    public  static WebDriver getWebDriver() {
        return webDriver;
    }
    private static void setWebDriver(ChromeDriver chromeDriver) {
        webDriver = chromeDriver;
    }

    @AfterAll
    public void tearDown() {
        getWebDriver().quit();
        logger.info("#Test Finished!");
    }

}
