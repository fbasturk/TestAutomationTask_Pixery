package bsturk.Activities.Funimate;

import bsturk.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static bsturk.TestSteps.BaseStep.*;
import static bsturk.Utils.AutomationProcess.MobileAppTest_Automation_Task_Scenario_Func;
import static org.junit.Assert.assertEquals;

public class LoginActivity extends AppiumUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By usernameEditText = By.id("com.avcrbt.funimate:id/usernameEdit");
    By passwordEditText = By.id("com.avcrbt.funimate:id/passwordEdit");
    By okButton = By.id("com.avcrbt.funimate:id/action_done");
    By forgotButton = By.id("com.avcrbt.funimate:id/forgotTextView");

    By errorMessageTextView = By.id("android:id/message");


    public LoginActivity(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void setText_Username(String message) {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"The given item is writing to Username");
        try {
            String username;
            if (message.toLowerCase().contains("random")) {
                String randomText = getAlphaNumericString(5);
                username="test"+randomText;
            } else {
                username=message;
            }
            click_ElementBy(passwordEditText);

            clear_ElementBy(usernameEditText);
            setText_ElementBy(usernameEditText,username);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"The given item is writing to Username", e.getMessage());
        }
        stepCount++;
    }

    public void setText_Password(String message) {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"The given item is writing to Password");
        try {
            click_ElementBy(usernameEditText);

            clear_ElementBy(passwordEditText);
            setText_ElementBy(passwordEditText,message);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"The given item is writing to Password", e.getMessage());
        }
        stepCount++;
    }

    public void click_LoginOK() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Clicking the '✔' button");
        try {
            click_ElementBy(okButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the '✔' button", e.getMessage());
        }
        stepCount++;
    }


    public void click_Forgot() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Clicking the 'Forgot' button");
        try {
            click_ElementBy(forgotButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'Forgot' button", e.getMessage());
        }
        stepCount++;
    }

    public void check_InvalidPassword() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking the invalid Password message.");
        try {
            assertEquals("No Invalid Username or Password error message was given.",
                    "Invalid username or password. (If you signed up with Facebook before, please login with Facebook)",getText_ElementBy(errorMessageTextView));
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking the invalid Password message.", e.getMessage());
        }
        stepCount++;
    }
}
