package cpm.mobile.tests.utils;

public enum App {
    CALCULATOR("com.google.android.calculator", "com.android.calculator2.Calculator"),
    CALPHONE("com.miui.calculator","com.miui.calculator.cal.CalculatorActivity");

    public String appPackage;
    public String appActivity;
    App(String appPackage,String appActivity) {
        this.appPackage=appPackage;
        this.appActivity=appActivity;
    }
}
