package com.course.testng;

import org.testng.annotations.Test;

public class ExpectException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeException(){
        System.out.println("This is a failed exception test");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("This is a successful exception test");
        throw new RuntimeException();

    }
}
