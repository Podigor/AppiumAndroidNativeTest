package config;

import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseClass {
    public  static AndroidDriver driver;

    @BeforeClass
    public static void b(){
        driver=DriverConfigFactory.create(DEVICES.PIXEL6NATIVE);

    }
    @AfterClass
    public static void a() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
}