package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
    WebDriver webDriver;
    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\s\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //加上全局等待的时间
        //webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    @Test
    public void method() throws InterruptedException {
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        Thread.sleep(5000);
    }

    /**
     * 关闭谷歌浏览器，并结束谷歌进程
     */
    @AfterMethod
    public void ShutdownGoole() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.quit();
    }
}
