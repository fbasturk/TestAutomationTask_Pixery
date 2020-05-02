package bsturk.Tests;


import bsturk.Activities.Funimate.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import static bsturk.Utils.AppiumUtils.errorMessage;

public class FunimateTest {

    private AndroidDriver<AndroidElement> driver;
    private String appName, scenarioName;

    private StartActivity startActivity;
    private SignUpActivity signUpActivity;
    private MainActivity mainActivity;
    private LoginActivity loginActivity;
    private ForgotActivity forgotActivity;

    public FunimateTest(AndroidDriver<AndroidElement> driver,String appName,String scenarioName) {
        this.driver = driver;
        this.appName = appName;
        this.scenarioName = scenarioName;

        startActivity = new StartActivity(driver);
        signUpActivity = new SignUpActivity(driver);
        mainActivity = new MainActivity(driver);
        loginActivity = new LoginActivity(driver);
        forgotActivity = new ForgotActivity(driver);
    }

    public void click(String purpose) {
        switch (purpose) {
            // Sign Up Scenario
            case "create account":
                startActivity.click_CreateAccount();
                break;
            case "Sign up with Email":
                startActivity.click_SignUpWith_Email();
                break;
            case "Allow us to show Funimate":
                signUpActivity.click_AllowUsToShowFunimate();
                break;
            case "Sign Up OK":
                signUpActivity.click_SignUpOK();
                break;
            /// Login Scenario
            case "login":
                startActivity.click_Login();
                break;
            case "Login OK":
                loginActivity.click_LoginOK();
                break;
            // Forgot Scenario
            case "Forgot":
                loginActivity.click_Forgot();
                break;
            case "reset password":
                forgotActivity.click_resetPassword();
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At Click " + purpose + " step of Funimate app was not defined");
                break;
        }
    }


    public void setText_Type(String purpose, String message) {
        switch (purpose) {
            // Sign Up Scenario
            case "Sign up Username":
                signUpActivity.setText_Username(message);
                break;
            case "Sign up Email":
                signUpActivity.setText_Email(message);
                break;
            case "Sign up Password":
                signUpActivity.setText_Password(message);
                break;
            /// Login Scenario
            case "Login Username":
                loginActivity.setText_Username(message);
                break;
            case "Login Password":
                loginActivity.setText_Password(message);
                break;
            /// Forgot Scenario
            case "Forgot Username or Mail":
                forgotActivity.setText_usernameOrMail(message);
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At SetText " + purpose + " step of Funimate app was not defined");
                break;
        }
    }


    public void check(String purpose) {
        switch (purpose) {
            case "Sign Up Invalid Username":
                signUpActivity.check_InvalidUsername();
                break;
            case "Sign Up Invalid Email":
                signUpActivity.check_InvalidEmail();
                break;
            case "Sign Up Invalid Password":
                signUpActivity.check_InvalidPassword();
                break;
            case "Login Invalid Password":
                loginActivity.check_InvalidPassword();
                break;
            case "Forgot":
                forgotActivity.check_forgot();
                break;
            case "Sign Up":
            case "Login":
                mainActivity.check_OpenActivity();
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At Check " + purpose + " step of Funimate app was not defined");
                break;
        }
    }

}
