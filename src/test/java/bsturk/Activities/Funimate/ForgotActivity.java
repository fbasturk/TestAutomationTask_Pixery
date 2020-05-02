package bsturk.Activities.Funimate;

import bsturk.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static bsturk.TestSteps.BaseStep.*;
import static bsturk.Utils.AutomationProcess.MobileAppTest_Automation_Task_Scenario_Func;
import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class ForgotActivity extends AppiumUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By usernameOrMailEditText = By.id("com.avcrbt.funimate:id/usernameOrMail");
    By resetPasswordButton = By.id("com.avcrbt.funimate:id/resetPassword");

    By errorMessageTextView = By.id("android:id/message");

    public ForgotActivity(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void click_resetPassword() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount, "Clicking the 'reset password' button");
        try {
            click_ElementBy(resetPasswordButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'reset password' button", e.getMessage());
        }
        stepCount++;
    }

    public void setText_usernameOrMail(String message) {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount, "The given item is writing to usernameOrMail");
        try {
            String username;
            if (message.toLowerCase().contains("random")) {
                String randomText = getAlphaNumericString(5);
                username = "test" + randomText;
            } else {
                username = message;
            }

            clear_ElementBy(usernameOrMailEditText);
            setText_ElementBy(usernameOrMailEditText, username);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"The given item is writing to usernameOrMail", e.getMessage());
        }
        stepCount++;
    }

    public void check_forgot() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking the message of 'reset password' button");
        try {
            sleep(1500);
            assertEquals("The 'reset password' button did not work correctly.","Success. Kindly check your e-mail",getText_ElementBy(errorMessageTextView));
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking the message of 'reset password' button", e.getMessage());
        }
        stepCount++;
    }
}
