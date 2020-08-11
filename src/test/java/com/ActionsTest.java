package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest {
    WebDriver webDriver;

    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\s\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    /**
     * 选择一个元素，然后鼠标右键操作
     */
    @Test
    public void rightClic(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        webDriver.manage().window().maximize();
        WebElement we =webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div[2]/div[2]/button/i"));
        //创建一个Actions对象
        Actions as = new Actions(webDriver);
        //进行右键操作，需要把需要操作的元素传入到conte这个方法里面
        as.contextClick(we).perform();

    }

    /**
     * 双击操作
     */
    @Test
    public void clice(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        webDriver.manage().window().maximize();
        WebElement we =webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div[2]/div[2]/button/i"));
        Actions as = new Actions(webDriver);
        //执行双击操作
        as.doubleClick(we).perform();

    }
    /**
     * 鼠标悬浮在某一个元素上
     */
    @Test
    public void clice1(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        webDriver.manage().window().maximize();
        WebElement we =webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[2]/span"));
        Actions as = new Actions(webDriver);
        //执行悬浮操作
        as.moveToElement(we).perform();

    }
    /**
     * 拖拽操作
     */
    @Test
    public void dropTest() throws InterruptedException {
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        webDriver.manage().window().maximize();
        WebElement we =webDriver.findElement(By.id("drag"));
        WebElement we1 =webDriver.findElement(By.xpath("/html/body/h1"));

        Actions actions =new Actions(webDriver);
        //拿到第一个元素然后拖到第二个元素上面,然后第一个元素到了第二个元素上面之后，在把第一个元素释放掉，在执行
        actions.clickAndHold(we).moveToElement(we1).release(we).perform();
        Thread.sleep(5000);


    }

    /**
     * 下拉框操作
     *
     */
    @Test
    public void moreSelect() throws InterruptedException {
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.manage().window().maximize();
        WebElement we =webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //用集合来接收下拉框里面的所有选项
        List<WebElement> list =webDriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        //keydow方法是操作模拟键盘的按键，可以选择很多种，比如shift,去集合里面拿你要的值
        //拿到值之后，要关闭掉这个按键，然后在进行执行
        Actions actions =new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).click(list.get(1)).click(list.get(2)).click(list.get(0)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
    }
    /**
     * 用java Robot这个类来实现浏览器保存页面到本地的操作
     */
    @Test
    public void salve() throws AWTException, InterruptedException {
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        Robot robot =new Robot();
        //转译成Acills
        int keys = (int)new Character('S');
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        //释放掉按键
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        Thread.sleep(3000);
    }

    /**
     * 上传文件操作
     */
    @Test
    public void upload() throws InterruptedException {
        webDriver.get("J:\\selenium\\Web自动化selenium（java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(5000);
        //先定位，在拿你需要上传的东西
        webDriver.findElement(By.id("load")).sendKeys("J:\\yys1.png");
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
