package bsturk.Utils;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverUtil {

    public static AndroidDriver<AndroidElement> createDriver(DesiredCapabilities capabilities,String appiumID, String appiumPort) throws MalformedURLException {


    //    capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
     //   capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);



        return new AndroidDriver<>(new URL("http://" + appiumID + ":" + appiumPort + "/wd/hub"), capabilities);
    }
}
