import config.BaseClass;
import org.junit.Test;
import pages.SettingsPage;

public class TestFirst extends BaseClass {
    static SettingsPage settingPage=new SettingsPage(driver);

    @Test
    public void test1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void test2(){
        settingPage.changeTemp(SettingsPage.TEMPERATURE.FAHRENHEIT);
    }

    @Test
    public void test3(){
        settingPage.changeTimeFormat(SettingsPage.TIMEFORMAT.TWENTYFOUR);
    }
    @Test
    public void test4() {
        settingPage.changeSpeed(SettingsPage.SPEED.METRES);
    }
    @Test
    public void test5() {
        settingPage.changeToggleState(SettingsPage.TOGGLESTATE.ON, settingPage.getNotificationToggle());
    }
    @Test
    public void test6() {
        settingPage.changeToggleState(SettingsPage.TOGGLESTATE.ON, settingPage.getStatusBarToggle());
    }
    @Test
    public void test7() {
        driver.findElement(settingPage.getDoneButton()).click();
    }

}