package com.bnz.pageobject.goudan;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search01 {

    //创建全局浏览器驱动对象
    WebDriver driver;

    @BeforeMethod //前置执行的方法
    public void openChrome(){
        //获取浏览器驱动
        System.setProperty("webdriver.chrome.driver","D:\\BrowserPath\\chromedriver.exe");
        //创建浏览器对象
        driver = new ChromeDriver();
    }

    @AfterMethod //后置执行的方法 关闭浏览器
    public void closeChrome() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test //测试用例
    public void search123() throws InterruptedException {
        //打开百度
        driver.get("http://192.168.150.139:8080/DagShop06/user?method=registUI");

        Thread.sleep(3000);

        //获取id，输入内容
         driver.findElement(By.id("username")).sendKeys("666");
         driver.findElement(By.id("inputPassword3")).sendKeys("123456");
         driver.findElement(By.id("inputPassword3")).sendKeys("123456");
         driver.findElement(By.id("inputEmail3")).sendKeys("123456@163.com");
         driver.findElement(By.id("usercaption")).sendKeys("呵呵哒");
         driver.findElement(By.id("inlineRadio2")).click();
         //driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[7]/div/input")).sendKeys("2021-5-24");
         driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[8]/div[1]/input")).sendKeys("zckx");
         driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/div[9]/div/input")).click();

        /**
         * 获取id，点击
         *         driver.findElement(By.id("su")).click();
         *         Thread.sleep(3000);
         */


        /**
         * 第一种校验
         *         String title = driver.getTitle();
         *         Assert.assertEquals(title,"三国志_百度搜索");
         */
           /* //第二种校验
        boolean isExist = false;
        try {
            driver.findElement(By.xpath("//*[contains(.,'" + "恭喜你,注册成功,请登录邮箱完成激活!" + "')]"));
            isExist = true;
        }catch (Exception e){
            isExist = false;
        }
        Assert.assertEquals(isExist,true);*/

        //第三种
              String text = driver.findElement(By.xpath("/html/body/div[1]/div[3]/h3")).getText();
              Assert.assertEquals(text,"恭喜你,注册成功,请登录邮箱完成激活!");


        //第四种校验
       /* driver.get("http://www.baidu.com/");
        //id为su的这个控件是否显示在这个界面上
        Boolean isDisplay=driver.findElement(By.id("su")).isDisplayed();//若有这个元素，则结果为 true.否则为false
        System.out.println(isDisplay);
        //校验百度首页是否存在这个元素
        Assert.assertTrue(isDisplay);*/
    }
    /*@Test
    public void login(){

    }*/
}
