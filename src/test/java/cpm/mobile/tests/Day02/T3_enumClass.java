package cpm.mobile.tests.Day02;

import cpm.mobile.tests.utils.App;
import cpm.mobile.tests.utils.Device;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class T3_enumClass {
    AppiumDriver<MobileElement> driver;
    AppiumDriverLocalService service;
    Device device=Device.PIXEL2;
    App app= App.CALCULATOR;


    @Test
    public void test1() throws InterruptedException {
        service=new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                //.usingPort(1111)
                .usingAnyFreePort()
                .build();
        service.clearOutPutStreams();//not to write appium log
        service.start();
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setCapability("appium:udid",device.udid);
        desiredCapabilities.setCapability("appium:version",device.version);
        desiredCapabilities.setCapability("appium:deviceName",device.deviceName);
        desiredCapabilities.setCapability("platformName",device.platformName);

        desiredCapabilities.setCapability("appPackage",app.appPackage);
        desiredCapabilities.setCapability("appActivity",app.appActivity);

        driver=new AndroidDriver<>(service.getUrl(),desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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


}}
