package com.eurotech.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class day2 {
    AppiumDriver<MobileElement> driver;
    @Test
    public void Amazon() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "11.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        desiredCapabilities.setCapability("appPackage","com.amazon.mShop.android.shopping");
        desiredCapabilities.setCapability("appActivity","com.amazon.windowshop.home.HomeLauncherActivity");

        driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(4000);

        // TASK: open Amazon app, connect to Appium, skip sign in, write "msi gaming laptop", click 1st one

        // "Skip sign in"
        //in Selenium      --> text locator is -->        //*[text()='Skip sign in']
        //In Appium       --> text locator is -->         //*[@text='Skip sign in']           // GOOD ...  here we uses @

        MobileElement skipSignButton = driver.findElementByXPath("//*[@text='Skip sign in']");
        skipSignButton.click();
        Thread.sleep(9000);
        MobileElement searchBox = driver.findElementByXPath("//*[@text='Search Amazon']");

        searchBox.click();          // first we should click search area as real mobile devices ..
        searchBox.sendKeys("msi gaming laptop");

        // MobileElement searchResultsMsi= driver.findElementByXPath("//*[@text='msi gaming laptop']");
        MobileElement searchResultsMsi= driver.findElementByXPath("//*[@text='msi gaming laptop 2023']");
        searchResultsMsi.click();
        Thread.sleep(3000);

        // contains  method ...  in Mobile app.
        // MobileElement element = driver.findElement(MobileBy.xpath("//*[contains(@text, '" + containingText + "')]"));
        // MobileElement element = driver.findElement(MobileBy.xpath("//*[contains(@text, 'containingText')]"));

        MobileElement firstLaptop = driver.findElement(MobileBy.xpath("//*[contains(@text,'$828')]"));   // may change ..
        firstLaptop.click();

        Thread.sleep(2000);
        driver.closeApp();
    }
}
