package Constants;

import org.openqa.selenium.By;

public class ConstantsProductDetail {
    public static final By productTitle = By.xpath("//body/div[3]/div[1]/div[1]/div[2]/div[2]/h1[1]/span[1]");
    public static final By oldDroductPrice = By.xpath("//del[@id='priceOld']");
    public static final By newDroductPrice = By.xpath("//ins[@id='priceNew']");
    public static final By btnAddToBasket = By.xpath("//button[@id='addBasket']");
    public static final By sizeParent = By.xpath("//body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/span");
    public static final By btnBasket = By.xpath("//button[contains(text(),'Sepete Git')]");

    public static By getSizeElement(int id){
        return By.xpath("//body/div[3]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/span["+id+"]");
    }
}
