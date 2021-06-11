package com.bnz.pageobject.youbaike;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class day01_2 {

    @DataProvider(name = "test02")
    public Object[][] data() {
        return new Object[][]{
                {"http://192.168.137.160:8889", "firefox"},
                {"http://192.168.137.160:8889", "chrome"}
        };
    }

    @Test(dataProvider = "test02")
    public void testData(String url, String browser) throws InterruptedException, MalformedURLException {
        DesiredCapabilities dc;
        if ("chrome".equals(browser)) {
            dc = DesiredCapabilities.chrome();
        } else if (browser.equals("firefox")) {
            dc = DesiredCapabilities.firefox();
            Thread.sleep(20000);
        } else {
            System.out.println("错误浏览器");
            dc = null;
        }
        WebDriver driver = new RemoteWebDriver(new URL(url + "/wd/hub"), dc);
        Thread.sleep(6000);
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        driver.quit();
    }
}
