package com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JS {
    WebDriver webDriver;

    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\s\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void js() throws InterruptedException {
        webDriver.get("https://www.baidu.com/");
        //创建一个js的对象，并且强转
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        //js方法操作
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"webdriver\")");
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
