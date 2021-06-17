package com.bnz.pageobject.goudan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DanDian01 {

    WebDriver driver;

    //@BeforeMethod
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\BrowserPath\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    //@AfterMethod
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    //@Test
    public void shop() throws InterruptedException {
        driver.get("http://localhost:81/general/ERP/LOGIN/");

        Thread.sleep(3000);

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/table/tbody/tr/td[3]/table[4]/tbody/tr[1]/td[1]/input")).click();

        //把控制权交给frame
        WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[2]"));
        driver.switchTo().frame(ele1);

        WebElement ele2 = driver.findElement(By.xpath("//*[@id=\"frame1\"]/frame[2]"));
        driver.switchTo().frame(ele2);

        driver.findElement(By.xpath("/html/body/table[7]/tbody/tr/td[3]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"MENU_66d\"]/tbody/tr/td/table[1]/tbody/tr/td[4]/a")).click();

        //退出frame，回到顶页面
        driver.switchTo().defaultContent();

        //进入frame
        WebElement ele3 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(ele3);

        WebElement ele4 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(ele4);

        driver.findElement(By.xpath("//*[@id=\"table\"]/thead[1]/tr/td/table/thead/tr/td[1]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[4]/td[2]/input")).sendKeys("鹬");


        //下拉框选项
        WebElement ele5 = driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[5]/td[2]/select"));
        Thread.sleep(1000);
        Select select = new Select(ele5);
        select.selectByIndex(1);


        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[7]/td[2]/input")).sendKeys("深圳市");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[8]/td[2]/input")).sendKeys("000000");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[9]/td[2]/input")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[10]/td[2]/input")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[11]/td[2]/input")).sendKeys("www.baidu.com");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[12]/td[2]/input")).sendKeys("中国银行");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[13]/td[2]/input")).sendKeys("123");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[14]/td[2]/a[1]")).click();

        Thread.sleep(3000);

        //获取第一个页面的句柄
        String handle1 = driver.getWindowHandle();
        driver.switchTo().window(handle1);
        Thread.sleep(3000);

        //for循环判断是否为第一页句柄，如果不是就控制权转交
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles);//将控制权转交给这个页面
        }

        WebElement ele8 = driver.findElement(By.xpath("//*[@id=\"bottom\"]/frameset/frame[2]"));
        driver.switchTo().frame(ele8);

        driver.findElement(By.id("admin")).click();

        driver.switchTo().window(handle1);

        driver.switchTo().defaultContent();

        WebElement ele6 = driver.findElement(By.xpath("//*[@id=\"frame2\"]/frame[5]"));
        driver.switchTo().frame(ele6);

        WebElement ele7 = driver.findElement(By.xpath("//*[@id=\"table_main\"]"));
        driver.switchTo().frame(ele7);

        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[15]/td[2]/textarea")).sendKeys("111");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[16]/td[2]/input")).sendKeys("111");
        driver.findElement(By.xpath("//*[@id=\"table\"]/tbody/tr[17]/td/div/input[1]")).click();
    }
}
