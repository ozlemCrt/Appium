package cpm.mobile.tests.Day01;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Day01 {
    AppiumDriver<MobileElement> driver;
    @Test
    public void test1() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        //which platform ?
        //1 way
        // desiredCapabilities.setCapability("platformName","Android");
        //2 way
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //which version
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"11.0");
        //Device name
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        //com.google.android.calculator/com.android.calculator2.Calculator

        // set Application's package name
        desiredCapabilities.setCapability("appPackage","com.google.android.calculator");

        //set application's activity name
        desiredCapabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        driver=new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        //driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);

        //locate
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



        Thread.sleep(3000);
        driver.closeApp();
    }
}
