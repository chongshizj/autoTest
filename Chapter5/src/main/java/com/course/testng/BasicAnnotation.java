package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.println("测试用例");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }

    @BeforeSuite
    public void BeforeSuite(){
        System.out.println("BeforeSuite");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void AfterClass(){
        System.out.println("AfterClass");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite");
    }
}
