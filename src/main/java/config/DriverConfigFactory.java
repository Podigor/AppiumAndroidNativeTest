package config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class DriverConfigFactory {
    public static AndroidDriver create(DEVICES devices){
        switch (devices){
            case PIXEL6NATIVE -> {return createPixelNative();}
        }
        return null;
    }

    private static AndroidDriver createPixelNative() {
        AndroidDriver driver = null;
        DesiredCapabilities caps=new DesiredCapabilities();
        // caps.setCapability(MobileCapabilityType.APP,"C:\\path\\NativeAPK\\Weather.apk"); - set path to apk if it should be installed before test run
        caps.setCapability("appium:version", "7");
        caps.setCapability("appium:platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:newCommandTimeout", 1800);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.weather.forecast.weatherchannel");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.weather.forecast.weatherchannel.activities.SettingActivity");
        try {
            driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver ;
    }
}