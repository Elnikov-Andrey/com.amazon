package com.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SearchPage {

    private WebDriver driver;
    private static final String AMAZON_URL = "https://www.amazon.com/";
    private static final String ASUS_ITEM = "//span[@class='a-size-base a-color-base'][contains(text(), 'ASUS')]";
    private static final String SAMSUNG = "//span[@class='a-size-base a-color-base'][contains(text(), 'Samsung')]";
    private static final String ACER = "//span[@class='a-size-base a-color-base'][contains(text(), 'Acer')]";
    private static final String SIDEBAR = "//a[@id='nav-hamburger-menu']";

    @BeforeTest
    public void start(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AMAZON_URL);
    }

    @Test
    public void searchText(){
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.search("processor");
        assertTrue(resultPage.getLinkText().contains("Intel"));
    }

    @Test
    public void searchText_MonitorAsus(){
        HomePage homePage = new HomePage(driver);
        ResultPage resultPage = homePage.search("monitor");
        driver.findElement(By.xpath(ASUS_ITEM)).click();
        assertTrue(resultPage.getLinkText_Monitor().contains("LED"));
    }

    @Test
    public void getCountSamsungMonitorItems(){
        HomePage homePage = new HomePage(driver);
        ListMonitorsPage listMonitorsPage = homePage.searchCountMonitorsItems("monitor");
        driver.findElement(By.xpath(SAMSUNG)).click();
        assertTrue(listMonitorsPage.getListOfSamsungMonitors() == 16);
    }

    @Test
    public void getCountAcerMonitorItems(){
        HomePage homePage = new HomePage(driver);
        ListMonitorsPage listMonitorsPage = homePage.searchCountMonitorsItems("monitor");
        driver.findElement(By.xpath(ACER)).click();
        assertTrue(listMonitorsPage.getListOfAcerMonitors() == 16);
    }

    @Test
    public void getCountSidebarItems(){
        CountSidebarItems countSidebarItems = new CountSidebarItems(driver);
        driver.findElement(By.xpath(SIDEBAR)).click();
        int x = countSidebarItems.getListOfSidebarItems();
        System.out.println("X = " + x);
        assertTrue(countSidebarItems.getListOfSidebarItems() == 44);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
