package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {

    public void stu1(){
        System.out.println("stu1 in GroupsOnClass2 is running");
    }

    public void stu2(){
        System.out.println("stu2 in GroupsOnClass2 is running");
    }


}
