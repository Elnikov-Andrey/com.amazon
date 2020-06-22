package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ListMonitorsPage extends BasePage {

    private WebDriver driver;
    private static final String AMAZON_URL = "https://www.amazon.com/";

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), 'Samsung')]")
    private List<WebElement> listSamsung;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][contains(text(), 'Acer')]")
    private List<WebElement> listAcer;



    ListMonitorsPage(WebDriver driver){
        super(driver);
    }

    public int getListOfSamsungMonitors(){
        return listSamsung.size();
    }

    public int getListOfAcerMonitors(){
        return listAcer.size();
    }


}
