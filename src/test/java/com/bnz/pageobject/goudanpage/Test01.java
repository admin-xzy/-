package com.bnz.pageobject.goudanpage;

import com.feng.action.Action;
import com.feng.driver.SeleniumDrivers;
import com.feng.tools.ScreenShot;
import cucumber.api.java.gl.E;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test01 {


    @DataProvider(name = "data1")
    public Object[][] data(){
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    WebDriver driver;

    @Test(dataProvider = "data1")
    public void test01(String browser) throws Exception{
        driver = SeleniumDrivers.openBrower(browser);
        driver.get("http://192.168.150.139:8080/DagShop06/user?method=loginUI");
        Action.sendkey(LoginPage.username,"123");
        Action.sendkey(LoginPage.password,"123");
        Action.click(LoginPage.submit,"submit");
        Thread.sleep(3000);
        ScreenShot.screenShots();
        SeleniumDrivers.closed();
    }
}
