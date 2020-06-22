package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class CountSidebarItems extends BasePage {

    private WebDriver driver;
    private static final String AMAZON_URL = "https://www.amazon.com/";

    @FindBy(xpath = "//div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']/li")
    private List<WebElement> list;

    CountSidebarItems(WebDriver driver){
        super(driver);
    }

    public int getListOfSidebarItems(){
        return list.size();
    }
}
