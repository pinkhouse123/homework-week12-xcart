package utilities;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void selectFromDropDown(By by, String value) {
        WebElement dropDown1 = driver.findElement(by);
        dropDown1.click();
        Select select1 = new Select(dropDown1);
        select1.selectByValue(value);

    }

    //Click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Send data to element
    public void sendDataOnElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public String verifyPage(String expectedMessage, By by, String message) {
        String actualMessage = driver.findElement(by).getText();
        Assert.assertEquals(message, expectedMessage, actualMessage);
        return message;
    }

    public void mHoverAndClick(By mouseHover, By mouseClick) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(mouseHover);
        WebElement click1 = driver.findElement(mouseClick);
        actions.moveToElement(hover).moveToElement(click1).click().build().perform();
    }


    public String getDataFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }


}