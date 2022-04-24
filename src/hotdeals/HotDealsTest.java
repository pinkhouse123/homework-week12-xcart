package hotdeals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifySaleProductsArrangedAlphabetically() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"))).click().perform();
        verifyPage("Sale", By.id("page-title"), "you are not on sale page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Name A - Z')]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product names from A to Z is not working", names, sortedNames);
    }
    @Test
    public void verifySaleProductsPriceArrangeLowToHigh(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"))).click().perform();
        verifyPage("Sale", By.id("page-title"), "you are not on sale page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Price Low - High'])[1]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product by Low to High is not working", names, sortedNames);
    }

    @Test
    public void vefirySalesProductsArrangedByRates() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("//li[@class='leaf has-sub']//li[1]//a[1]"))).click().perform();
        verifyPage("Sale", By.id("page-title"), "you are not on sale page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Rates'])[1]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product by Rates is not working", names, sortedNames);

    }

    @Test

    public void verifyBestSellersProductsArrangeByZToA(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"))).click().perform();
        verifyPage("Bestsellers", By.id("page-title"), "you are not on Bestsellers page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Name Z - A'])[1]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product names from Z to A is not working", names, sortedNames);
    }
    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"))).click().perform();
        verifyPage("Bestsellers", By.id("page-title"), "you are not on Bestsellers page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Price High - Low'])[1]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product High to Low is not working", names, sortedNames);

    }
    @Test
    public void verifyBestSellersProductsArrangeByRates(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[contains(text(),'Hot deals')]"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Bestsellers')])[2]"))).click().perform();
        verifyPage("Bestsellers", By.id("page-title"), "you are not on Bestsellers page");
        action.moveToElement(driver.findElement(By.xpath("//span[@class='sort-by-value']"))).perform();
        action.moveToElement(driver.findElement(By.xpath("(//a[normalize-space()='Rates'])[1]"))).click().perform();
        List<WebElement> products = driver.findElements(By.xpath("//ul[@class='products-grid grid-list']"));
        List<String> names = new ArrayList<String>();
        for (WebElement e : products) {
            names.add(e.getText());
        }
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        System.out.println(sortedNames.equals(names));
        Assert.assertEquals("Sorting product by Rates is not working", names, sortedNames);

    }

}
