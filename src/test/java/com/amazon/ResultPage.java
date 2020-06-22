package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends BasePage{

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), \"9700K\")]")
    private WebElement firstLink;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), 'VS248H-P')]")
    private WebElement secondLink;

    ResultPage(WebDriver driver){
        super(driver);
    }

    public String getLinkText(){
        //return driver.findElement(By.xpath("//div[@id=\"search\"]//h3[(text()='automated-testing.info - русскоязычное сообщество №1 по ...')]\n")).getText();
        return firstLink.getText();
    }

    public String getLinkText_Monitor(){
        //return driver.findElement(By.xpath("//div[@id=\"search\"]//h3[(text()='automated-testing.info - русскоязычное сообщество №1 по ...')]\n")).getText();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), 'VS248H-P')]")));
        return secondLink.getText();
    }


}
