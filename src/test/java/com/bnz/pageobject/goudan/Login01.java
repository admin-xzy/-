package com.bnz.pageobject.goudan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login01 {

    WebDriver driver;

    @BeforeMethod
    public void openChrome(){
        //获取浏览器驱动
        System.setProperty("webdriver.chrome.driver","D:\\BrowserPath\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeChrome() throws InterruptedException {
        //关浏览器
        Thread.sleep(6000);
        driver.quit();
    }

    @Test
    public void login() throws InterruptedException {
        driver.get("http://192.168.150.139:8080/DagShop06/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("username")).sendKeys("123");
        driver.findElement(By.id("inputPassword3")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"inputPassword3\"]")).sendKeys("123");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/form[1]/div[5]/div/input")).click();

        Thread.sleep(2000);

        //校验
        driver.get("http://192.168.150.139:8080/DagShop06/");
        //id为su的这个控件是否显示在这个界面上
        Boolean isDisplay=driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ol/li[1]/a")).isDisplayed();//若有这个元素，则结果为 true.否则为false
        System.out.println(isDisplay);
        //校验首页是否存在这个元素
        Assert.assertTrue(isDisplay);
    }
}
