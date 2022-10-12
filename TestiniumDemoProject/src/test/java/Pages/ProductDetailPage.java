package Pages;

import Base.BasePage;
import Constants.ConstantsProductDetail;
import Utilities.FormHelper;
import Utilities.IOHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver webDriver){super(webDriver);}

    public ProductDetailPage saveProduct() throws IOException {
        String productName = FormHelper.getElementValue(ConstantsProductDetail.productTitle,super.driver);
        String price = getPrice();

        IOHelper.writeTxt("product.txt",productName +";"+price);
        return  this;
    }

    public ProductDetailPage selectSize() {
        int id=1;
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsProductDetail.getSizeElement(1)));
        int maxSize = FormHelper.getChildsCount(ConstantsProductDetail.sizeParent,super.driver);
        for (int i = 1; i <=  maxSize; i++){
            By sizeElement =  ConstantsProductDetail.getSizeElement(i);
            if(FormHelper.isEnabled(sizeElement,super.driver)){
                id =i;
                break;
            }
        }
        FormHelper.click(ConstantsProductDetail.getSizeElement(id),super.driver);
        return  this;
    }

    public ProductDetailPage addToBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsProductDetail.btnAddToBasket));
        FormHelper.click(ConstantsProductDetail.btnAddToBasket,super.driver);
        return  this;
    }

    public ProductDetailPage clickBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(ConstantsProductDetail.btnBasket));
        FormHelper.click(ConstantsProductDetail.btnBasket,super.driver);
        return  this;
    }

    private String getPrice(){
        try {
          return  FormHelper.getElementValue(ConstantsProductDetail.oldDroductPrice,super.driver);
        }catch (Exception e){
            return  FormHelper.getElementValue(ConstantsProductDetail.newDroductPrice,super.driver);
        }
    }
}
