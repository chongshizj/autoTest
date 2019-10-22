package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {


    public void teacher1(){
        System.out.println("teacher1 is running in GroupsOnClass3");
    }

    public void teacher2(){
        System.out.println("teacher2 is running in GroupsOnClass3");
    }
}
