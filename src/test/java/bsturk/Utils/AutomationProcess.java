package bsturk.Utils;


public class AutomationProcess {

    //// 1. Adım
    public static void MobileAppTest_Automation_Task_Start() {
        LogUtil.info("1- Pixery's Funimate test set begins.");
    }

    ///// 2. Adım
    public static void MobileAppTest_Automation_Task_Start_Platform(String platformName) {
        LogUtil.info("2- Platform Name: " + platformName + " is getting ready to run.");
    }

    //// 3. Adım
    public static void MobileAppTest_Automation_Task_Create_Driver(String mobileApp) {
        LogUtil.info("3- Driver created for " + mobileApp + " Tests\n");
    }

    //// 4. Adım
    public static void MobileAppTest_Automation_Task_TestStart(String mobileApp) {
        LogUtil.info("4- Starting test scenarios in " + mobileApp + " Tests");
    }

    //// 4. Adım
    public static void MobileAppTest_Automation_Task_Start_Scenario(int index, String scenarioName, String mobileApp) {
        LogUtil.info("\tS." + index + "- Scenario Start: " + scenarioName + " Test in " + mobileApp);
    }

    //// Sayfaları oluşturma adımları
    public static void MobileAppTest_Automation_Task_Finish_Scenario(int index, String scenarioName, String status) {
        LogUtil.info("\tS." + index + "- Scenario Finish: " + scenarioName + " STATUS= " + status+"\n");
    }

    //// Sayfalarda yapılan işlemlerin adımları
    public static void MobileAppTest_Automation_Task_Scenario_Func(int stepCount, String funcMessage) {
        LogUtil.info(" \t\t " + stepCount + ". Step: " + funcMessage);
    }

    //// 5. Adım
    public static void MobileAppTest_Automation_Task_Finish_Browser(String mobileApp, long testTime, String platformName, String appVersion,
                                                                    int scenarioCount, int passScenario, int failCount) {
        LogUtil.info("5- Test Name: " + mobileApp + " \tComplete Time:" + testTime +
                "\n\t\t\t\t\t\t\t\t\tPlatformName: " + platformName+" \tAPP Version:" + appVersion +
                "\n\t\t\t\t\t\t\t\t\tNumber of scenarios run= " + scenarioCount +
                "\n\t\t\t\t\t\t\t\t\t\tPass: " + passScenario + "\t\tFail: " + failCount);
    }

}
