package com.bnz.pageobject.youbaike;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","D:\\BrowserPath\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test2() throws Exception{
        driver.get("https://dev.bnzedu.com/admin/#/login");

        driver.get("https://dev.bnzedu.com/admin/#/login");
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[2]/div/div/span/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[2]/div/div/span/span/input")).sendKeys("admin");
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[3]/div/div/span/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[3]/div/div/span/span/input")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/form/div[2]/div[3]/div[1]/div[4]/div/div/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/aside/div/ul/li[3]/div[1]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"components-layout-demo-custom-trigger\"]/aside/div/ul/li[2]/ul/li[1]/a")).click();

    }
}
