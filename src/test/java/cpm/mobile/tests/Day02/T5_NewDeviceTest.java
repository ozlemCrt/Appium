package cpm.mobile.tests.Day02;

import cpm.mobile.tests.utils.App;
import cpm.mobile.tests.utils.Device;
import cpm.mobile.tests.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class T5_NewDeviceTest {
    AppiumDriver<MobileElement> driver;
    By ldigit2=By.id("com.miui.calculator:id/btn_2_s");
    By lplusBtn=By.id("com.miui.calculator:id/btn_plus_s");
    By ldigit3=By.id("com.miui.calculator:id/btn_3_s");
    By lequalBtn=By.id("com.miui.calculator:id/btn_equal_s");
    By lresult=By.id("com.miui.calculator:id/result");
    @Before
    public void beforeTest(){
        Driver.runAppium();


        driver=Driver.getDriver(Device.PHONE, App.CALPHONE);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @After
    public void afterTest(){

        Driver.stopAppium();
    }


    @Test
    public void test1(){

        driver.findElement(By.id("android:id/button1")).click();

       click(ldigit2);
       click(lplusBtn);
       click(ldigit3);
        click(lequalBtn);
        Assert.assertEquals("= 5",getText(lresult));
    }

    void click(By locater){
        Driver.getDriver().findElement(locater).click();
    }
    String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
}
