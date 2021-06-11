package com.bnz.pageobject.Feng;

import com.feng.action.Action;
import com.feng.driver.SeleniumDrivers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ActionTest01 {

    @DataProvider(name="test02")
    public Object[][] data(){
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    WebDriver driver;

    @Test(dataProvider = "test02")
    public void actionTest(String bro) throws InterruptedException {
        driver= SeleniumDrivers.openBrower(bro);
        driver.get("https://www.baidu.com/");
        Action.sendkey(com.bnz.pageobject.Feng.SearchPage.loginName,"selenium test");
        Action.click(com.bnz.pageobject.Feng.SearchPage.loginBtn,"你点击了百度一下");
        Thread.sleep(3000);
        SeleniumDrivers.closed();
    }

}
