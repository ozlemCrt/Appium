package cpm.mobile.tests.utils;

public enum Device {
    PIXEL2("emulator-5554",
                   "11.0",
                   "Pixel_2",
                   "Android"),
    PHONE("1699da64",
            "11",
            "Redmi Note 8",
            "Android");


    public String udid;
    public String version;
    public String deviceName;
    public String platformName;



    Device(String udid, String version, String deviceName, String platformName) {
        this.udid=udid;
        this.version=version;
        this.deviceName=deviceName;
        this.platformName=platformName;
    }


    @Override
    public String toString() {
        return this.name();
    }

}
