package com.fc572;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ClassTwo extends BaseClass {

    @Test
    public void testIdFieldOnly() throws InterruptedException, MalformedURLException {
        try{
            long id = Thread.currentThread().getId();
            System.out.println("Before test " + ". Thread id is: " + id);
            System.out.println("Executing test with " + driver.getCapabilities().getBrowserName());
            driver.navigate().to("http://fc572.github.io/testexercise/");
            driver.findElement(By.id("fieldId")).sendKeys("Hello world");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
