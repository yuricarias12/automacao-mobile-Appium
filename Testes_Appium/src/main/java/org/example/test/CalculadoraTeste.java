package org.example.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraTeste {

    @Test
    public void deveSomarDoisValores() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        WebElement el1 = (WebElement) driver.findElement(AppiumBy.accessibilityId("2"));
        el1.click();
        WebElement el2 = (WebElement) driver.findElement(AppiumBy.accessibilityId("plus"));
        el2.click();
        WebElement el3 = (WebElement) driver.findElement(AppiumBy.accessibilityId("2"));
        el3.click();
        WebElement el4 = (WebElement) driver.findElement(AppiumBy.accessibilityId("equals"));
        el4.click();
        WebElement el5 = (WebElement) driver.findElement((AppiumBy.id("com.google.android.calculator:id/result_final")));
	    //System.out.println(el4.getText());
        Assert.assertEquals("4", el5.getText());

        driver.quit();
    }
}
