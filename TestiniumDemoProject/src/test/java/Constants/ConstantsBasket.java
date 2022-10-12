package Constants;

import org.openqa.selenium.By;

public class ConstantsBasket {
    public static final By productTitle = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/a[1]/span");
    public static final By productPrice = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/span[2]");
    public static final By btnNext = By.xpath("//button[@id='nextBtn']");
    public static final By cmbQuantity = By.xpath("//select[@id='quantitySelect0-key-0']");
    public static final By btnRemove = By.xpath("//button[@id='removeCartItemBtn0-key-0']");
    public static final By emptyBasketMessage = By.xpath("//a[contains(text(),'Alışverişe Devam Et')]");
}
