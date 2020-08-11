package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 优师云，登录注册模块操作
 */
public class YouShiYun {
    private WebDriver webDriver;

    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\s\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://www.youshiyun.com.cn/#/login/index");
        //最大化浏览器
        webDriver.manage().window().maximize();
    }

    /**
     * 正常登录操作
     */
    @Test
    public void login() throws InterruptedException {
        //拿到用户名
        WebElement lg = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/form/div[1]/div[1]/div/div[1]/input"));
        //输入用户名
        lg.sendKeys("13973148072");
        /*String text = lg.getText();
        Assert.assertEquals(text,"手机号/用户名/身份证号");*/
        //拿到密码
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/form/div[1]/div[2]/div/div[1]/input")).sendKeys("12");
        //

        //点击登录
        webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/form/div[3]/div/button")).click();
        Thread.sleep(3000);
        WebElement el = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/form/div[1]/div[2]/div/div[2]"));
        String text = el.getText();
        Assert.assertEquals(text,"密码长度最少为6位");

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
