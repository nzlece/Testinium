package Tests;

import Base.BaseTest;
import Pages.BasketPage;
import Pages.HomePage;
import Pages.ProductDetailPage;
import Pages.SearchPage;
import Utilities.IOHelper;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class AllTest extends BaseTest {
    @DisplayName("TC_001HOMEPAGE")
    @Test
    public void TC_001_HomePage() throws IOException {
        HomePage homePage = new HomePage(this.getWebDriver());
        String words = IOHelper.readTxt("words.csv");
        String[] splittedWords = words.split(";");
        homePage.searchProduct(splittedWords[0]).clearInput().searchProduct(splittedWords[1]).pressEnter();
    }

    @DisplayName("TC_002SEARCHPAGE")
    @Test
    public void TC_002_SearchPage(){
        SearchPage searchPage = new SearchPage(this.getWebDriver()) ;
        searchPage.selectProduct();
    }

    @DisplayName("TC_003PRODUCTPAGE")
    @Test
    public void TC_003_ProductPage() throws IOException {
        ProductDetailPage productDetailPage = new ProductDetailPage(this.getWebDriver());
        productDetailPage.saveProduct().selectSize().addToBasket().clickBasket();
    }

    @DisplayName("TC_004ASKETPAGE")
    @Test
    public void TC_004_BasketPage() throws FileNotFoundException {
        BasketPage basketPage = new BasketPage(this.getWebDriver());
        basketPage.searchProduct().increaseProduct().removeBasket();

    }
}
