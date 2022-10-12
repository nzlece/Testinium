package Pages;

import Base.BasePage;
import Constants.ConstantsBasket;
import Constants.ConstantsProductDetail;
import Utilities.FormHelper;
import Utilities.IOHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver webDriver){super(webDriver);}

    public BasketPage searchProduct() throws FileNotFoundException {
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsBasket.btnNext));
        String orProductPrice = getProductPrice();
        String productPrice = getBasketPrice();
        orProductPrice = orProductPrice.split("TL")[0] + "TL";
        String orProductName = getProductName();
        String productName = getBasketProductName();

        assertEquals(orProductPrice,productPrice);
        assertEquals(orProductName,productName);
        return this;
    }

    public BasketPage increaseProduct() throws FileNotFoundException {
        int totalQuantity = 2;
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsBasket.cmbQuantity));
        Select select=new Select(driver.findElement(ConstantsBasket.cmbQuantity));
        try {
            select.selectByValue("2");
        }catch (Exception ex){
            return this;
        }
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsBasket.cmbQuantity));
        WebElement option = select.getFirstSelectedOption();
        int defaultItem = Integer.parseInt(option.getText().split("\\s+")[0]);
        assertEquals(totalQuantity,defaultItem);
        return this;
    }
    public BasketPage removeBasket(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsBasket.btnRemove));
        FormHelper.click(ConstantsBasket.btnRemove,super.driver);
        try {
            FormHelper.click(ConstantsBasket.btnRemove,super.driver);
            FormHelper.click(ConstantsBasket.btnRemove,super.driver);

        }catch (Exception e){
        }

        wait.until(ExpectedConditions.elementToBeClickable(ConstantsBasket.emptyBasketMessage));
        return this;
    }

    private String getBasketPrice(){
        String productPrice = FormHelper.getElementValue(ConstantsBasket.productPrice,super.driver);
        return productPrice;
    }
    private String getProductPrice() throws FileNotFoundException {
        String data =  IOHelper.readTxt("product.txt");
        String[] datas = data.split(";");
        return datas[1];
    }

    private String getProductName() throws FileNotFoundException {
        String data =  IOHelper.readTxt("product.txt");
        String[] datas = data.split(";");
        return datas[0];
    }
    private String getBasketProductName(){
        return FormHelper.getElementValue(ConstantsBasket.productTitle,super.driver);
    }

}
