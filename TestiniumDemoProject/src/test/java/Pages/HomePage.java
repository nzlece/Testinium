package Pages;

import Base.BasePage;
import Constants.ConstantsHome;
import Utilities.FormHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver){super(webDriver);}

    public HomePage searchProduct(String inputVal){
        FormHelper.sendKeys(ConstantsHome.searchBox,super.driver,inputVal);
        return this;
    }
    public HomePage clearInput(){
        FormHelper.clear(ConstantsHome.searchBox,super.driver);
        return this;
    }
    public HomePage pressEnter(){
        FormHelper.sendKeys(ConstantsHome.searchBox,super.driver,Keys.ENTER);
        return  this;
    }
}
