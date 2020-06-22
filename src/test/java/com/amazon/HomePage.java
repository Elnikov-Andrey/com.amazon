package com.amazon;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    public HomePage (WebDriver driver){
        super(driver);
    }

    public ResultPage search(final String searchText){
        //driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(searchText, Keys.ENTER);
        searchField.sendKeys(searchText, Keys.ENTER);
        return new ResultPage(driver);
    }
    public ListMonitorsPage searchCountMonitorsItems(final String searchText){
        //driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys(searchText, Keys.ENTER);
        searchField.sendKeys(searchText, Keys.ENTER);
        return new ListMonitorsPage(driver);
    }
}
