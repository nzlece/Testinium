package Constants;

import org.openqa.selenium.By;

public class ConstantsSearch {
    public static By getProductItem(int id){
        return By.xpath("//body/div[6]/div[1]/div[1]/div[2]/div["+id+"]");
    }
}
