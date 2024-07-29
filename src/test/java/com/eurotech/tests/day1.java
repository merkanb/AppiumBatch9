package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void name() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        // Device information set up
        // 1st way
//        desiredCapabilities.setCapability("platformName", "Android");

        //2.way
        desiredCapabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        // App. information set up
        // set Application`s package name
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");

        // set Application`s Activity name
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        // 2+3=5  and verify the result
        String expectedResult = "5";
        MobileElement digit2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plus = driver.findElementByAccessibilityId("plus");
        MobileElement digit3 = driver.findElementByAccessibilityId("3");
        MobileElement equals = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"equals\"]"));

        digit2.click();
        plus.click();
        digit3.click();
        equals.click();

        MobileElement resultArea = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = resultArea.getText();
        Assert.assertEquals(expectedResult, actualResult);

        Thread.sleep(3000);
        driver.closeApp();

    }



    @Test
    public void task() throws MalformedURLException, InterruptedException {
        // connect appium, open calculator, 6*8=48   verify result

        String expectedResult = "48";
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        // set Application`s package name and Activity name
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);

        MobileElement digit6 = driver.findElementByAccessibilityId("6");
        MobileElement multiply = driver.findElementById("com.google.android.calculator:id/op_mul");
        MobileElement digit8 = driver.findElementByAccessibilityId("8");
        MobileElement equals = driver.findElementByAccessibilityId("equals");

//        digit6.click();
//        multiply.click();
//        digit8.click();
//        equals.click();

        getDigit(6).click();                // uses pre defined method ..
        multiply.click();
        getDigit(8).click();
        equals.click();

        MobileElement resultArea = driver.findElementById("com.google.android.calculator:id/result_final");
        String actualResult = resultArea.getText();
        Assert.assertEquals(expectedResult, actualResult);

        Thread.sleep(2000);
        driver.closeApp();

    }

    public MobileElement getDigit(int digit){           // defining dynamic locator with providing text
        return driver.findElement(By.id("com.google.android.calculator:id/digit_"+digit));
    }


    // homework: create a method and locate all digits,

    public void clickElement(String AccessibilityId){
        driver.findElementByAccessibilityId(AccessibilityId).click();
    }

    @Test
    public void task3() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        clickElement("square root");
        clickElement("3");
        clickElement("6");
        clickElement("multiply");
        clickElement("8");
        clickElement("divide");
        clickElement("4");
        clickElement("equals");
        clickElement("power");
        clickElement("2");
        clickElement("plus");
        clickElement("6");
        clickElement("equals");
        clickElement("percent");
        clickElement("1");
        clickElement("0");

        String expectedResult= "15";
        MobileElement resultArea = driver.findElementById("com.google.android.calculator:id/result_preview");
        String actualResult = resultArea.getText();
        Assert.assertEquals(expectedResult,actualResult);

        Thread.sleep(2000);
        driver.closeApp();


    }

}
