/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Websitesinin anasayfasında ki işlemler.
 * web sayfasının elementlerinin tanımlandığı ve yapılan işlemlerin bulunduğu sınıf.
 */
package bsturk.Activities.Funimate;


import bsturk.Utils.AppiumUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import static bsturk.TestSteps.BaseStep.*;
import static bsturk.Utils.AutomationProcess.MobileAppTest_Automation_Task_Scenario_Func;

public class StartActivity extends AppiumUtils {

    ///Sayfada kullanılacak elementlerin tanımlanması
    By createAccountButton = By.id("com.avcrbt.funimate:id/createAccountButton");
    By loginButton = By.id("com.avcrbt.funimate:id/loginButton");
    By emailButton = By.id("com.avcrbt.funimate:id/signUpWithMail");

    public StartActivity(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    public void click_Login() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount, "Clicking the 'login' button");
        try {
            click_ElementBy(loginButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'login' button", e.getMessage());
        }
        stepCount++;
    }

    public void click_CreateAccount() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount, "Clicking the 'create account' button");
        try {
            click_ElementBy(createAccountButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'create account' button", e.getMessage());
        }
        stepCount++;
    }

    public void click_SignUpWith_Email() {
        MobileAppTest_Automation_Task_Scenario_Func(stepCount, "Clicking the 'Email' button");
        try {
            click_ElementBy(emailButton);
        } catch (Exception e) {
            errorMessage(appName,scenarioName,"Clicking the 'Email' button", e.getMessage());
        }
        stepCount++;
    }
}