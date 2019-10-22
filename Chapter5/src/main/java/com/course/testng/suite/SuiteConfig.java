package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite running");
    }

    @AfterSuite
    public void afteSuite(){
        System.out.println("after suite running");
    }

    @BeforeTest
    public void BeforeTest(){
        System.out.println("BeforeTest");
    }

    @AfterTest
    public void AfterTest(){
        System.out.println("AfterTest");
    }
}
