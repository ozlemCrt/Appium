package cpm.mobile.tests.Day02;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class T1_Service {
    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;
    @Test
    public void test1() throws MalformedURLException, InterruptedException {


        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        service.start();

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setCapability("appium:udid","emulator-5554");
        desiredCapabilities.setCapability("appium:version","11.0");
        desiredCapabilities.setCapability("appium:deviceName","Pixel_2");
        desiredCapabilities.setCapability("platformName","Android");

        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AndroidDriver<>(service.getUrl(),desiredCapabilities);

        //locate element
        MobileElement digit2=driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        MobileElement plusBtn=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]"));
        MobileElement digit3=driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        MobileElement equalBtn=driver.findElement(By.id("com.google.android.calculator:id/eq"));
        digit2.click();
        plusBtn.click();
        digit3.click();
        equalBtn.click();

        MobileElement result=driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualResult=result.getText();
        String expectedResult="5";
        Assert.assertEquals(expectedResult,actualResult);

        Thread.sleep(2000);
        driver.closeApp();
    }
  }
