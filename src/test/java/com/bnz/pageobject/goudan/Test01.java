package com.bnz.pageobject.goudan;

import org.testng.Assert;
import org.testng.annotations.*;

public class Test01 {
    @Test
    public void testA(){
        System.out.println("登录");
    }
    @Test
    public void testB(){
        System.out.println("注册");
        String content = "注册失败";
        Assert.assertEquals(content,"注册成功","内容一致通过，否则不通过");
    }
    @BeforeMethod
    public void testC(){
        System.out.println("打开浏览器");
    }
    @AfterMethod
    public void testD(){
        System.out.println("关闭浏览器");
    }
    @AfterTest
    public void testE(){
        System.out.println("数据的后续处理");
    }
    @BeforeTest
    public void testF(){
        System.out.println("数据的前期处理");
    }
}
