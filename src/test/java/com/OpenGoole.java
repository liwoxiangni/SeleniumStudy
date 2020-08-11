package com;


import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import javax.imageio.IIOException;
import java.io.File;
import java.util.List;

public class OpenGoole {
    WebDriver webDriver;


    /**
     * 在开头创建一个谷歌浏览器
     */
    @BeforeMethod
    public void createGoole(){
        System.setProperty("webdriver.chrome.driver","J:\\selenium\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    /**
     * 操作谷歌浏览器
     */
    @Test
    public void openGoole(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        //WebElement we=webDriver.findElement(By.className("el-input__inner"));
        //WebElement we= webDriver.findElement(By.linkText("联系我们"));
        //WebElement we= webDriver.findElement(By.xpath(""));
        WebElement we= webDriver.findElement(By.cssSelector("#cnzz_stat_icon_1278045550 > a > img"));
    }
    /**
     * 多个标签输出
     */
    @Test
    public void openGooles(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        List<WebElement> list = webDriver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }
    /**
     * 输出多个值
     */
    @Test
    public void openGoolez(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        List<WebElement> list =webDriver.findElements(By.xpath("/html/body/div/div[3]/div/div[1]/div[1]/div[2]"));
        for (int i = 0; i <list.size(); i++) {
            String text=list.get(i).getText();
            System.out.println(text);
        }


    }
    /**
     * 获取文本框的值
     */
    @Test
    public void openGooleq(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        //拿文本输入框的值
        String web =webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div[2]/div[2]/div/input")).getTagName();
        /*if (web.equals("input")){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }*/

        Assert.assertEquals(web,"input");
    }
    /**
     * 1,先拿登录的按钮
     */
    @Test
    public void openYouShiYun() throws InterruptedException {
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        //最大化浏览器
        webDriver.manage().window().maximize();
        WebElement we=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[4]/div/button"));
        //点击事件
        we.click();
        Thread.sleep(3000);
        //获取登录框的默认值
        String se=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[1]/div/form/div[1]/div[1]/div/div[1]/input")).getAttribute("placeholder");
        //比对两个值是否相等
        Assert.assertEquals(se,"手机号/用户名/身份证号");
        //校验里面的值是否正确
        Thread.sleep(3000);
    }
    /**
     * 1,先拿登录的元素
     */
    @Test
    public void openYouShiYun1() throws InterruptedException {
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        //最大化浏览器
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        Boolean be = webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div[4]/div/button")).isDisplayed();
        //Assert.assertEquals(be,"true");
        Assert.assertTrue(be);
    }
    /**
     * 打开优诗云首页，判断单选框是否被选中
     *
     */
    @Test
    public void openYouShiYun2() throws InterruptedException {
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        //最大化浏览器
        webDriver.manage().window().maximize();
        Thread.sleep(3000);
        WebElement we=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div[2]/div[1]/label[2]/span[1]/span"));
        we.click();
        Thread.sleep(3000);
        boolean bs=we.isSelected();
        Thread.sleep(3000);
        //判断单选框是否被选中
        //Boolean be=webDriver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div[2]/div[1]/label[2]/span[1]/span")).isSelected();
        //Assert.assertTrue(bs);
        Assert.assertFalse(bs);
    }
    /**
     * 截图操作
     */
    @Test
    public void jie(){
        webDriver.get("http://www.youshiyun.com.cn/#/index");
        webDriver.manage().window().maximize();
        File file =((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        /*try {
            FileUtils.copyFile(file,new File("J:\\test.png"));
        }catch (IIOException e){
            e.printStackTrace();
        }
        FileU*/


    }


    /**
     * 关闭谷歌浏览器，并结束谷歌进程
     */
    @AfterMethod
    public void ShutdownGoole(){
        webDriver.quit();
    }
}
