package com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenFireFox {
    //火狐驱动启动浏览器
    @Test
    public void open() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","J:\\huohuqudong\\geckodriver.exe");
        //System.setProperty("webdriver.firefox.bin","E:\\firefox.exe");
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("J:\\index.html");
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        Alert al =webDriver.switchTo().alert();
        //输入内容的方法
        al.sendKeys("sssssaaaa");
        Thread.sleep(3000);
        //这个是确认的方法
        al.accept();
        Thread.sleep(3000);
        al.accept();
        Thread.sleep(3000);
        webDriver.quit();

    }
    //谷歌驱动启动浏览器
    @Test
    public void open1(){
           System.setProperty("webdriver.chrome.driver","J:\\selenium\\chromedriver.exe");
           WebDriver webDriver =new ChromeDriver();

    }

}
