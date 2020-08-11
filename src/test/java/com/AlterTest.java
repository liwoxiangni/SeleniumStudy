package com;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlterTest {
    WebDriver webDriver;

    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //加上全局等待的时间
        //webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }


    /**
     * 点击弹窗操作
     */
    @Test
    public void Alter() throws InterruptedException {
        webDriver.get("J:\\index.html");
        webDriver.findElement(By.className("alert")).click();
        Thread.sleep(3000);
        //把控制权移动到弹窗上去
        Alert al =webDriver.switchTo().alert();
        Thread.sleep(1000);
        //这个是确定的方法
        al.accept();
        Thread.sleep(3000);
    }
    /**
     * 两次弹窗操作
     */
    @Test
    public void Alter1() throws InterruptedException {
        webDriver.get("J:\\index.html");
        webDriver.findElement(By.className("confirm")).click();
        Thread.sleep(3000);
        Alert al =webDriver.switchTo().alert();
        //这个是取消的方法
        al.dismiss();
        Thread.sleep(3000);
        al.accept();
        Thread.sleep(3000);
    }
    /**
     * 在弹窗里面输入值
     *
     */
    @Test
    public void Alter2() throws InterruptedException {
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
    }

    /**
     * 弹窗里面还有一个页面
     */
    @Test
    public void Alter3() throws InterruptedException {
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.manage().window().maximize();
        //把控制权交给fram这个元素
        webDriver.switchTo().frame("aa");
        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
        //吧控制权交回到最初始的界面
        webDriver.switchTo().defaultContent();
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("登陆界面")).click();

    }

    /**
     * 操作下拉框的方法
     *
     */
    @Test
    public void selectTest() throws InterruptedException {
        //打开测试界面
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        //窗口最大化
        webDriver.manage().window().maximize();
        //根据下拉框索引来做选择
        WebElement we =webDriver.findElement(By.id("moreSelect"));
        Select se = new Select(we);
        //根据索引来找位置
        se.selectByIndex(2);
        Thread.sleep(3000);
        //通过value值来查找，来进行下拉选择
        se.selectByValue("huawei");
        Thread.sleep(3000);
        //通过文本内容来选择下拉框
        se.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }

    /**
     * 控制新的弹窗
     *
     */
    @Test
    public void newWdowns(){
        //打开测试界面
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        //窗口最大化
        webDriver.manage().window().maximize();
        webDriver.findElement(By.linkText("登陆界面")).click();
        //获取当前窗口的句柄值
        String heand = webDriver.getWindowHandle();
        //把webDriver.getWindowHandles()每个获取的句柄值跟heandls进行比较
        //如果是之前的。那就结束，要不就重新把控制权给新的页面
        for(String heandls :webDriver.getWindowHandles() ){
            if (heandls.equals(heand)){
                continue;
            }else{
                webDriver.switchTo().window(heandls);
            }
        }

        webDriver.findElement(By.id("search-kw")).sendKeys("nihao");
    }
    /**
     * 时间带等待的方法
     */
    @Test
    public void waitTime(){
        //打开测试界面
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        //窗口最大化
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        String test =webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(test,"wait for display");
    }

    /**
     * 时间带等待的方法2
     */
    @Test
    public void waitTime1(){
        //打开测试界面
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        //窗口最大化
        webDriver.manage().window().maximize();
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待，实例化WebDriverWait，需要传参数
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        //会一直等待这个元素加载完成
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"display\"]/div")));

        String test =webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(test,"wait for display");
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


