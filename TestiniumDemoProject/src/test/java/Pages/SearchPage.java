package Pages;

import Base.BasePage;
import Constants.ConstantsHome;
import Constants.ConstantsSearch;
import Utilities.FormHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver webDriver){super(webDriver);}

    public SearchPage selectProduct(){
        int randProduct = (int)(Math.random() * 49) + 1;
        By product = ConstantsSearch.getProductItem(randProduct);
        wait.until(ExpectedConditions.elementToBeClickable(product));
        FormHelper.click(product,super.driver);
        return this;
    }
}
