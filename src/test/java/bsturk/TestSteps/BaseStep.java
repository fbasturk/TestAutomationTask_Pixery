/**
 * 21/03/2020
 * Created by Furkan BASTURK
 * Project    :Digiturk - Test Mühendisi Ödevi
 * This Class :Her senaryo için baştan başlatılmaması ve ortak kullanılması gerekn değişkenlerin tanımlanması için oluşturulan sınıf.
 */
package bsturk.TestSteps;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseStep {
    public static AndroidDriver<AndroidElement> driver;
    public static String appName,scenarioName;
    public static int scenarioCount=1,stepCount=1,passCount=0,failCount=0;
    public static long startTime;

}
