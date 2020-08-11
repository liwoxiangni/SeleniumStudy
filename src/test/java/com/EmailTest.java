package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class EmailTest {
    WebDriver webDriver;
    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\s\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.163.com/");
        //最大化浏览器
        webDriver.manage().window().maximize();
    }
    /*
      qq邮箱登录
     */
    @Test
    public void Login() throws InterruptedException {
        //转交控制权，因为在iframe里面
        webDriver.switchTo().frame("login_frame");
        Thread.sleep(4000);
        webDriver.findElement(By.name("u")).sendKeys("13973148072");
        webDriver.findElement(By.name("p")).sendKeys("n3050547123");
        webDriver.findElement(By.id("login_button")).click();


    }
    /*
     163邮箱
     */
    @Test
    public static void Login163(WebDriver webDriver,String name,String pwd) throws InterruptedException {
        /*Random r =new Random();
        int i = r.nextInt();*/

        //转交控制权，因为在iframe里面
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[starts-with(@id,'x-URS-iframe')]")));
        Thread.sleep(4000);
        webDriver.findElement(By.name("email")).sendKeys(name);
        webDriver.findElement(By.name("password")).sendKeys(pwd);
        webDriver.findElement(By.id("dologin")).click();

    }

    //直接用标签库里面的元素来使用
    public static void Loginpo(WebDriver webDriver,String name,String pwd) throws InterruptedException {
        /*Random r =new Random();
        int i = r.nextInt();*/

        //转交控制权，因为在iframe里面
        webDriver.switchTo().frame(webDriver.findElement(By.xpath("//iframe[starts-with(@id,'x-URS-iframe')]")));
        Thread.sleep(4000);
        //直接用标签库静态来调用
        webDriver.findElement(LoginPage.emailname).sendKeys(name);
        webDriver.findElement(LoginPage.emailpwd).sendKeys(pwd);
        webDriver.findElement(LoginPage.loginEmail).click();

    }

    /**
     * 发送邮件
     * @throws InterruptedException
     */
    @Test
    public void sendEmail() throws InterruptedException {
        Loginpo(webDriver,"13973148072","n3050547123");
        //点击写信按钮
        //webDriver.findElement(By.className("oz0")).click();
        Thread.sleep(3000);
        //webDriver.findElement(By.id("dvNavTop"));
        //点击发送信息按钮
        webDriver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //定位收件人
        //webDriver.findElement(By.xpath("//div[starts-with(@id,'_mail_emailcontainer')]/input"));
        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("1393148072@163.com");
        //定位一个主题
        webDriver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("哈哈哈");
        //发送主题消息
        WebElement element = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(element);
        webDriver.findElement(By.xpath("/html/body")).sendKeys("123456");
        //把控制权转交回来
        webDriver.switchTo().defaultContent();
        Thread.sleep(3000);
        //点击发送按钮
        webDriver.findElement(By.xpath(".//*[text()='发送']")).click();
        //判断有没有发送成功
        /*boolean displayed = webDriver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(displayed);*/



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
