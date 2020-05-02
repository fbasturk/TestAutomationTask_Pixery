/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :BDD olarak oluşturduğumuz senaryoları temsil eden kodların bulunduğu sınıf. Senaryolar ile metotları eşlendirilimesi sağlanır.
 */
package bsturk.TestSteps;


import bsturk.Tests.FunimateTest;
import bsturk.Utils.CreateDriverUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

import static bsturk.Utils.AppiumUtils.errorMessage;
import static bsturk.Utils.AppiumUtils.getScreenshot;
import static bsturk.Utils.AutomationProcess.*;


public class AutomationSteps extends BaseStep {

    private DesiredCapabilities capabilities;
    private FunimateTest funimateTest;

    @Before
    public void InitializeTest(Scenario scenario) {
        scenarioName = scenario.getName();
        appName = scenario.getName().substring(scenario.getName().indexOf("for ") + 4);

        if (scenario.getName().contains("Driver create")) {
            MobileAppTest_Automation_Task_Start();
            startTime = System.currentTimeMillis();

            capabilities = new DesiredCapabilities();
            scenarioCount = 0;
        } else {

            settingsApplication(appName, driver);
            driver.closeApp();
            driver.launchApp();
        }

        if (!scenario.getName().contains("Driver create") && !scenario.getName().contains("Finish Test") )
            MobileAppTest_Automation_Task_Start_Scenario(scenarioCount, scenario.getName(), appName);

        stepCount = 1;
    }

    private void settingsApplication(String applicationName, AndroidDriver<AndroidElement> driver) {
        switch (applicationName) {
            case "Funimate":
                funimateTest = new FunimateTest(driver, appName, scenarioName);
                break;
            default:
                errorMessage(driver, appName, scenarioName, "Before Settings " + applicationName + " app was not defined");
                break;
        }

    }


    @After
    public void TearDownTest(Scenario scenario) {
        if (!scenario.getName().contains("Driver create") && !scenario.getName().contains("Finish Test") ) {
            MobileAppTest_Automation_Task_Finish_Scenario(scenarioCount, scenario.getName(), scenario.getStatus().toString());
            if (scenario.getStatus().toString().equals("PASSED")) {
                passCount++;
            } else {
                getScreenshot(driver, appName, scenarioName);
                failCount++;
            }
        }


        scenarioCount++;
    }

    @Given("Set Capability Key {string} Value {string}")
    public void set_capability(String key, String value) {
        capabilities.setCapability(key, value);
        if (key.equals("platformName"))
            MobileAppTest_Automation_Task_Start_Platform(value);
    }

    @When("Create Driver ID {string} Port {string} with Test capability")
    public void create_driver(String id, String port) {
        try {
            driver = CreateDriverUtil.createDriver(capabilities, id, port);
            MobileAppTest_Automation_Task_Create_Driver(appName);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        MobileAppTest_Automation_Task_TestStart(appName);
    }

    @Given("At {string} Click {string}")
    public void at_Click(String applicationName, String purpose) {

        switch (applicationName) {
            case "Funimate":
                funimateTest.click(purpose);
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At Click " + applicationName + " app was not defined");
                break;
        }
    }

    @When("At {string} SetText {string} Type {string}")
    public void at_SetText_Type(String applicationName, String purpose, String message) {
        switch (applicationName) {
            case "Funimate":
                funimateTest.setText_Type(purpose, message);
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At Click " + applicationName + " app was not defined");
                break;
        }
    }

    @Then("At {string} Check {string}")
    public void at_Check(String applicationName, String purpose) {
        switch (applicationName) {
            case "Funimate":
                funimateTest.check(purpose);
                break;
            default:
                errorMessage(driver, appName, scenarioName, "At Click " + applicationName + " app was not defined");
                break;
        }
    }


    @Then("Finish Test")
    public void at_finish_Test() {
        long testTime = System.currentTimeMillis() - startTime;
        MobileAppTest_Automation_Task_Finish_Browser(appName, testTime, driver.getPlatformName(), driver.getCapabilities().getCapability("appVersion").toString(),
                scenarioCount-1, passCount, failCount);
        driver.quit();
    }

}
