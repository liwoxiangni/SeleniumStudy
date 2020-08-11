package com;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testng {

    @Test
    public void study(){
        String a = "a";
        String b = "b";
        Assert.assertEquals(a,b,"这是错误的");
    }
    @Test
    public void test(){
        String a ="a";
        Assert.assertNull(a,"为空");
    }
}
