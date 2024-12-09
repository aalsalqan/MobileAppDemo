package core.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver<WebElement> driver;

    public void setUp() throws MalformedURLException {
//        AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
        DesiredCapabilities caps = new DesiredCapabilities();

        //Setting the desired options based on the emulator settings that you opened from android studio

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability("appPackage", "com.wdiodemoapp");
        caps.setCapability("appActivity", "com.wdiodemoapp.MainActivity");
        caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/apps/android.wdio.native.app.v1.0.8.apk");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/android.wdio.native.app.v1.0.8.apk");


       // this for defining the time for appium server  600 seconds (10 minutes) this is essential for managing idle sessions
        caps.setCapability("newCommandTimeout", 600);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
