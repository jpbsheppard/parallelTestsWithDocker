package com.fc572;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class TestParallel extends BaseClass {

    //@Test(threadPoolSize = 3, invocationCount = 2, timeOut = 1000)
    @Test
    public void test_01() throws InterruptedException, MalformedURLException{
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

    @Test
    public void thisIsATest()
    {
        long id = Thread.currentThread().getId();
        System.out.println("Before test " + ". Thread id is: " + id);
        System.out.println("Executing test with " + driver.getCapabilities().getBrowserName());

        WebElement findMeById = driver.findElement(By.id("fieldId"));
        WebElement findMeByName = driver.findElement(By.name("fieldName"));
        WebElement findMeByClassName = driver.findElement(By.className("fieldClass"));
        WebElement findMeByLinkText = driver.findElement(By.linkText("FullLinkText"));
        WebElement findMeByPartialLinkText = driver.findElement(By.partialLinkText("Partial"));
        WebElement findMeByIdToo = driver.findElement(By.id("fieldIdTwo"));
        WebElement findMeByCssSelector = driver.findElement(By.cssSelector("#maincontainer > ul > li > ul > li > ol > li:last-child"));
        WebElement findMeByCssSelector2 = driver.findElement(By.cssSelector("#maincontainer > ul > li:nth-child(2)"));
        WebElement findMeByCssSelector3 = driver.findElement(By.cssSelector("#maincontainer > ul > li:last-child"));
        WebElement findMeByXPathCheckBox = driver.findElement(By.xpath("//input[@type='checkbox' and @value='HappyTesting']"));
        WebElement findMeByXPath2RadioButton = driver.findElement(By.xpath("//input[@name='pickMe' and @value='HappyTesting']"));

        findMeById.sendKeys("Found By.id");
        findMeByName.sendKeys("Found By.Name");
        findMeByClassName.click();
        Assert.assertTrue(findMeByLinkText.getText().equalsIgnoreCase("FullLinkText"));
        Assert.assertTrue(findMeByPartialLinkText.getText().equalsIgnoreCase("PartialLinkText"));
        Assert.assertTrue(findMeByIdToo.getText().contains("Find me and verify the text"));
        Assert.assertTrue(findMeByCssSelector.getText().equalsIgnoreCase("Sub Sub Item 1.2"));
        Assert.assertTrue(findMeByCssSelector2.getText().contains("Item 2"));
        Assert.assertTrue(findMeByCssSelector3.getText().equalsIgnoreCase("Item 3"));
        findMeByXPathCheckBox.click();
        findMeByXPath2RadioButton.click();
    }
}