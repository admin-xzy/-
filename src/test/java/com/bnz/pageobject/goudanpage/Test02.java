package com.bnz.pageobject.goudanpage;

import com.feng.action.Action;
import com.feng.driver.SeleniumDrivers;
import com.feng.tools.MyAssert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Test02 {
    WebDriver driver;

    @Test
    public void test(){
        driver = SeleniumDrivers.openBrower("chrome");
        driver.get("http://192.168.150.139:8080/DagShop06/user?method=loginUI");
        Action.sendkey(LoginPage.username,"123");
        Action.sendkey(LoginPage.password,"123");
        Action.click(LoginPage.submit,"submit");
        Action.click(LoginPage.wodedingdan,"wodedingdan");
        Action.click(LoginPage.wodedingdan,"wodedingdan");
        S
        SeleniumDrivers.closed();
    }
}
