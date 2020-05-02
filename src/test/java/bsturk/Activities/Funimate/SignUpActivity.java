package bsturk.Activities.Funimate;


import bsturk.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static bsturk.TestSteps.BaseStep.*;
import static bsturk.Utils.AutomationProcess.MobileAppTest_Automation_Task_Scenario_Func;
import static org.junit.Assert.assertEquals;

public class SignUpActivity extends AppiumUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By usernameEditText = By.id("com.avcrbt.funimate:id/usernameEdit");
    By emailEditText = By.id("com.avcrbt.funimate:id/emailEdit");
    By passwordEditText = By.id("com.avcrbt.funimate:id/passwordEdit");
    By allowUsCheckBox = By.id("com.avcrbt.funimate:id/adsAllowCheckbox");
    By okButton = By.id("com.avcrbt.funimate:id/action_done");

    By errorMessageTextView = By.id("android:id/message");

    public SignUpActivity(AndroidDriver<AndroidElement> driver) {
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
            click_ElementBy(emailEditText);

            clear_ElementBy(usernameEditText);
            setText_ElementBy(usernameEditText,username);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"The given item is writing to Username", e.getMessage());
        }
        stepCount++;
    }

    public void setText_Email(String message) {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"The given item is writing to Email");
        try {
            String mail;
            if (message.toLowerCase().contains("random")) {
                String randomText = getAlphaNumericString(6);
                mail=randomText+"@"+randomText+".com";
            } else {
                mail=message;
            }

            click_ElementBy(usernameEditText);

            clear_ElementBy(emailEditText);
            setText_ElementBy(emailEditText,mail);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"The given item is writing to Email", e.getMessage());
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

    public void click_AllowUsToShowFunimate() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Clicking the 'AllowUsToShow' button");
        try {
            click_ElementBy(allowUsCheckBox);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'AllowUsToShow' button", e.getMessage());
        }
        stepCount++;
    }

    public void click_SignUpOK() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Clicking the '✔' button");
        try {
            click_ElementBy(okButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the '✔' button", e.getMessage());
        }
        stepCount++;
    }

    public void check_InvalidUsername() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking the invalid Username message.");
        try {
            assertEquals("No Invalid Username error message was given.","Invalid Username",getText_ElementBy(errorMessageTextView));
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking the invalid Username message.", e.getMessage());
        }
        stepCount++;
    }

    public void check_InvalidEmail() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking the invalid Email message.");
        try {
            assertEquals("No Invalid Email error message was given.","Invalid Email",getText_ElementBy(errorMessageTextView));
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking the invalid Email message.", e.getMessage());
        }
        stepCount++;
    }

    public void check_InvalidPassword() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount,"Checking the invalid Password message.");
        try {
            assertEquals("No Invalid Password error message was given.","Invalid Password",getText_ElementBy(errorMessageTextView));
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Checking the invalid Password message.", e.getMessage());
        }
        stepCount++;
    }
}
