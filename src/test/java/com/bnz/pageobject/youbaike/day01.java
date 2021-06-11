package com.bnz.pageobject.youbaike;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day01 {
    @DataProvider(name="test01")
    public Object[][] data(){
        return new Object[][]{
                {"chrome","www.baidu.com"},
                {"ff","www.baidu.com"},
                {"edge","www.baidu.com"}
        };
    }

    @Test(dataProvider = "test01")
    public void testData(String browser,String url){
        System.out.println(browser+","+url);
    }
}
