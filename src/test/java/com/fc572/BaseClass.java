package com.fc572;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    protected RemoteWebDriver driver = null;
    @Parameters("myBrowser")
    @BeforeClass(alwaysRun = true)
    public void beforeTest(String myBrowser) throws MalformedURLException{
        long id = Thread.currentThread().getId();
        System.out.println("Before test " + ". Thread id is: " + id);
        if(myBrowser.equalsIgnoreCase("chrome")){
            DesiredCapabilities capability = DesiredCapabilities.chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }
        else if(myBrowser.equalsIgnoreCase("firefox")){
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.LINUX);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }
    }

    @AfterClass
    public void afterTest() {
        long id = Thread.currentThread().getId();
        System.out.println("After test Thread id is: " + id + " quitting " + driver.getCapabilities().getBrowserName());
        driver.close();
        driver.quit();
    }
}