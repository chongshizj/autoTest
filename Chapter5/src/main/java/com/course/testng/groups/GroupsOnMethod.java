package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("This is test1 of server group");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("This is test2 of server group");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("This is test3 of client group");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("This is test4 of client group");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("This is method to be run before group server");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("This is method to be run after group server");
    }
}
