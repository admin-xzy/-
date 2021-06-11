package com.bnz.pageobject.goudan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SanGuoZhi {
    //创建全局对象
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chorme.driver","D:\\BrowserPath\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void sanGuo() throws InterruptedException {

        driver.get("http://www.baidu.com");
        Thread.sleep(2000);
        driver.findElement(By.id("kw")).sendKeys("三国杀");
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"3001\"]/div[1]/h3/a[1]")).click();

        //打开至最新的窗口为止
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]")).click();
        Thread.sleep(2000);

        String aTitle=driver.getTitle();//取新窗口的title
        System.out.println("current widnow title is:"+aTitle);

        //不可输入用户名密码！！！
        driver.findElement(By.id("dobest_inputUserId_179a6b94150")).click();
        driver.findElement(By.id("dobest_inputUserId_179a6b94150")).sendKeys("xzy01040416");
        driver.findElement(By.id("dobest_password_179a6ba828e")).sendKeys("12345678");
        driver.findElement(By.id("dobest_protocol_179a6ba828e")).click();
        driver.findElement(By.id("dobest_loginBtn_179a6ba828e")).click();



        //查找第一个句柄，选择后返回第一个句柄
       /* String handle1 = driver.getWindowHandle();
        driver.switchTo().window(handle1);
        Thread.sleep(3000);
        //driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]"));

        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);
        }*/

    }

}
