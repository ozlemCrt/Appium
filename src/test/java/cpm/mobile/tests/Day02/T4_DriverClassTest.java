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

public class T4_DriverClassTest {
    AppiumDriver<MobileElement> driver;
    By ldigit2=By.id("com.google.android.calculator:id/digit_2");
    By lplusBtn=By.xpath("//android.widget.ImageButton[@content-desc=\"plus\"]");
    By ldigit3=By.id("com.google.android.calculator:id/digit_3");
    By lequalBtn=By.id("com.google.android.calculator:id/eq");
    By lresult=By.id("com.google.android.calculator:id/result_final");
    @Before
    public void beforeTest(){
        Driver.runAppium();

        driver=Driver.getDriver(Device.PIXEL2, App.CALCULATOR);
    }

    @After
    public void afterTest(){

        Driver.stopAppium();
    }
    @Test
    public void test1(){


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



    }

    @Test
    public void test2() {
        click(ldigit2);
        click(lplusBtn);
        click(ldigit3);
        click(lequalBtn);
        Assert.assertEquals("5",getText(lresult));
    }

    void click(By locater){
        Driver.getDriver().findElement(locater).click();
    }
    String getText(By locator){
        return Driver.getDriver().findElement(locator).getText();
    }
}
