package bsturk.Activities.Funimate;


import bsturk.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static bsturk.TestSteps.BaseStep.*;
import static bsturk.TestSteps.BaseStep.scenarioName;
import static bsturk.Utils.AutomationProcess.MobileAppTest_Automation_Task_Scenario_Func;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainActivity extends AppiumUtils {



    public MainActivity(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void check_OpenActivity() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking 'MainActivity' visit");
        boolean result =false;
        try {
            sleep(2000);
            String activity = driver.currentActivity();
            if (activity.contains("MainActivity") || activity.contains("AnnouncementActivity") || activity.contains("FollowAllActivity"))
                result =true;
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking 'MainActivity' visit", e.getMessage());
        }
        assertTrue("Checking the opening status of 'MainActivity'",result);
        stepCount++;

    }
}
