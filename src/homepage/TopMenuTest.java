package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(.,'Shipping')]"));
        verifyPage("Shipping",By.id("page-title"),"you are not on ");
    }
    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully(){

        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']/descendant::span[contains(.,'New!')]"));
        verifyPage("New arrivals",By.id("page-title"),"you are not on ");
    }
    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Coming soon')]"));
        verifyPage("Coming soon",By.id("page-title"),"you are not on ");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully(){
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Contact us')]"));
        verifyPage("Contact us",By.id("page-title"),"you are not on ");
    }


}