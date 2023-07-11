package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SettingsPage {
    By temperatureToggle = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By windSpeedItemsSection = By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView");
    By windSpeedItemsList = By.className("android.widget.LinearLayout");
    By windSpeedItem = By.className("android.widget.TextView");
    By speedButton = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By speedFormat = By.id("com.weather.forecast.weatherchannel:id/tv_wind_speed_format");
    By timeFormatToggle = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");
    By notificationToggle = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusBarToggle = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By doneButton = By.id("com.weather.forecast.weatherchannel:id/tvDone");

    public By getNotificationToggle() {
        return notificationToggle;
    }
    public By getStatusBarToggle() {
        return statusBarToggle;
    }
    public By getDoneButton() {
        return doneButton;
    }
    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private static AndroidDriver driver;

    public void changeTemp(TEMPERATURE temperature) {
        WebElement element = driver.findElement(temperatureToggle);
        switch (temperature) {
            case FAHRENHEIT: {
                if (element.getAttribute("checked").equals("false")) {
                    element.click();
                }
            }
            break;

            case CELSIUS: {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }
    }

    public void changeTimeFormat(TIMEFORMAT timeFormat) {
        WebElement element = driver.findElement(timeFormatToggle);
        switch (timeFormat) {
            case TWELVE: {
                if (element.getAttribute("checked").equals("false")) {
                    element.click();
                }
            }
            break;

            case TWENTYFOUR: {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }
    }

    public void changeSpeed(SPEED speed) {
        if (!driver.findElement(speedFormat).getText().equals(speed.speed)) {
            driver.findElement(speedButton).click();
            WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.presenceOfElementLocated(windSpeedItemsSection));
            List<WebElement> list = button.findElements(windSpeedItemsList);
            for (WebElement l : list) {
                if (l.findElement(windSpeedItem).getText().equals(speed.speed)) {
                    l.click();
                    break;
                }
            }
        }
    }

    public void changeToggleState(TOGGLESTATE toggleState, By by) {
        WebElement element = driver.findElement(by);
        switch (toggleState) {
            case ON: {
                if (element.getAttribute("checked").equals("false")) {
                    element.click();
                }
            }
            break;

            case OFF: {
                if (element.getAttribute("checked").equals("true")) {
                    element.click();
                }
            }
            break;
        }
    }
    public enum TEMPERATURE {
        FAHRENHEIT("f"),
        CELSIUS("c");
        String temperature;
        TEMPERATURE(String temperature) {
            this.temperature = temperature;
        }
    }
    public enum TIMEFORMAT {
        TWELVE(12),
        TWENTYFOUR(24);
        int timeFormat;
        TIMEFORMAT(int timeFormat) {
            this.timeFormat = timeFormat;
        }
    }
    public enum SPEED {
        METRES("m/s"),
        KILOMETRES("km/h");
        String speed;
        SPEED(String speed) {
            this.speed = speed;
        }
    }
    public enum TOGGLESTATE {
        ON("on"),
        OFF("off");
        String toggleState;
        TOGGLESTATE(String toggleState) {
        this.toggleState = toggleState;
    }
    }
}