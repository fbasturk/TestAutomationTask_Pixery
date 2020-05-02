package bsturk.Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AppiumUtils {

    public enum XpathType {
        TEXT("text"), CLASZ("class"), CONTENT_DESC("content-desc"), CHECKABLE("checkable"), CHECKED("checked"),
        CLICKABLE("clickable"), ENABLED("enabled"), FOCUSABLE("focusable"), FOCUSED("focused"), SCROLLABLE("scrollable"),
        LONG_CLICKABLE("long-clickable"), PASSWORD("password"), SELECTED("selected");

        private String val;

        private XpathType(String val) {
            this.val = val;
        }

        public String value() {
            return val;
        }

        @Override
        public String toString() {
            return val;
        }
    }

    private AndroidDriver<AndroidElement> androidDriver;
    private WebDriverWait wait;

    public AppiumUtils(AndroidDriver<AndroidElement> androidDriver) {
        this.androidDriver = androidDriver;

        this.wait = new WebDriverWait(androidDriver, 30);

        if (androidDriver.isDeviceLocked())
            androidDriver.unlockDevice();
    }

    private AndroidElement waitForElement(MobileElement element) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOf(element));
    }

    public AndroidElement waitForElementBy(By cssSelector) {
        return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));

    }

    public List<AndroidElement> waitForElementsBy(By cssSelector) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cssSelector));
        return androidDriver.findElements(cssSelector);
    }

    public AndroidElement elementBy(By cssSelector) {
        return androidDriver.findElement(cssSelector);
    }

    public List<AndroidElement> elementsBy(By cssSelector) {
        return androidDriver.findElements(cssSelector);
    }


    public void view_ElementBy(By cssSelector) {
        waitForElementBy(cssSelector);
    }

    public void click_ElementBy(By cssSelector) {
        waitForElementBy(cssSelector).click();
    }

    public void longClick_ElementBy(By cssSelector) {
        new TouchAction(androidDriver)
                .longPress(longPressOptions().withElement(element(waitForElementBy(cssSelector)))
                        .withDuration(Duration.ofMillis(1000))).release().perform();
    }

    public void scroll_Clicked_ElementBy(By cssSelector) {
        Dimension dimensions = androidDriver.manage().window().getSize();

        Double screenHeightStart = dimensions.getHeight() * 0.5;
        int scrollStart = screenHeightStart.intValue();

        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        int scrollEnd = screenHeightEnd.intValue();

        boolean don = true;
        while (don) {
            new TouchAction(androidDriver).press(PointOption.point(0, scrollStart)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(0, scrollEnd)).release().perform();
            try {
                androidDriver.findElement(cssSelector).isDisplayed();
                don = false;
            } catch (Exception e) {
                don = true;
            }
        }
    }

    public String getText_ElementBy(By cssSelector) {
        return waitForElementBy(cssSelector).getText();
    }

    protected String getAttribute_ElementBy(By cssSelector, XpathType xpathtype) {
        String attribute;
        if (xpathtype.value().equals("content-desc")) {
            attribute = "contentDescription";
        } else {
            attribute = xpathtype.value();
        }
        return waitForElementBy(cssSelector).getAttribute(attribute);
    }

    public void setText_ElementBy(By cssSelector, String value) {
        waitForElementBy(cssSelector).setValue(value);
    }

    public void clear_ElementBy(By cssSelector) {
        waitForElementBy(cssSelector).clear();
    }

    public Integer getSize_ElementListBy(By cssSelector) {
        return waitForElementsBy(cssSelector).size();
    }

    public Integer getSize_ListViewBy_ElementListBy(By listSelector, By cssSelector) {
        return waitForElementBy(listSelector).findElements(cssSelector).size();
    }

    public void click_ListViewBy_ElementListBy_Index(By listSelector, By cssSelector, int index) {
        waitForElementBy(listSelector).findElements(cssSelector).get(index).click();
    }

    public void click_ListViewBy_ElementBy(By listSelector, By cssSelector) {
        waitForElementBy(listSelector).findElement(cssSelector).click();
    }

    public void click_ListViewBy_ElementListBy_Index_ElementBy(By listSelector, By elementListSelector, int index, By cssSelector) {
        waitForElementBy(listSelector).findElements(elementListSelector).get(index).findElement(cssSelector).click();
    }


    public String getText_ListViewBy_ElementBy(By listSelector, By cssSelector) {
        return waitForElementBy(listSelector).findElement(cssSelector).getText();
    }

    public String getText_ListViewBy_ElementListBy_Index(By listSelector, By cssSelector, int index) {
        return waitForElementBy(listSelector).findElements(cssSelector).get(index).getText();
    }

    public String getText_ListViewBy_ElementListBy_Index_ElementBy(By listSelector, By elementListSelector, int index, By cssSelector) {
        return waitForElementBy(listSelector).findElements(elementListSelector).get(index).findElement(cssSelector).getText();
    }

    public String getAttribute_ListViewBy_ElementBy(By listSelector, By cssSelector, XpathType xpathtype) {
        String attribute;
        if (xpathtype.value().equals("content-desc")) {
            attribute = "contentDescription";
        } else {
            attribute = xpathtype.value();
        }
        return waitForElementBy(listSelector).findElement(cssSelector).getAttribute(attribute);
    }

    public String getAttribute_ListViewBy_ElementListBy_Index(By listSelector, By cssSelector, int index, XpathType xpathtype) {
        String attribute;
        if (xpathtype.value().equals("content-desc")) {
            attribute = "contentDescription";
        } else {
            attribute = xpathtype.value();
        }
        return waitForElementBy(listSelector).findElements(cssSelector).get(index).getAttribute(attribute);
    }

    public String getAttribute_ListViewBy_ElementListBy_Index_ElementBy(By listSelector, By elementListSelector, int index, By cssSelector, XpathType xpathtype) {
        String attribute;
        if (xpathtype.value().equals("content-desc")) {
            attribute = "contentDescription";
        } else {
            attribute = xpathtype.value();
        }
        return waitForElementBy(listSelector).findElements(elementListSelector).get(index).findElement(cssSelector).getAttribute(attribute);
    }

    public void getScreenshot(String appName, String scenarioName) {
        new Thread(() -> {
            try {
                SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
                Date date = new Date(System.currentTimeMillis());
                String time = formatterDate.format(date);

                String screenshotLoc = System.getProperty("user.dir") + "\\ScreenshotFile\\" + appName.replaceAll(" ", "") + "\\" +
                        time + "_" + scenarioName.replaceAll(" ", "") + ".png";

                System.out.println("Capturing the snapshot of the page ");
                File srcFiler = ((TakesScreenshot) androidDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFiler, new File(screenshotLoc));
            } catch (IOException e) {
                LogUtil.error("Error occurred in screenshot file operations!", e);
            }
        }).start();
    }

    public static void getScreenshot(AndroidDriver<AndroidElement> driver, String appName, String scenarioName) {
        new Thread(() -> {
            try {
                SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd_HH-mm");
                Date date = new Date(System.currentTimeMillis());
                String time = formatterDate.format(date);

                String screenshotLoc = System.getProperty("user.dir") + "\\ScreenshotFile\\" + appName.replaceAll(" ", "") + "\\" +
                        time + "_" + scenarioName.replaceAll(" ", "") + ".png";

                System.out.println("Capturing the snapshot of the page ");
                File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(srcFiler, new File(screenshotLoc));
            } catch (IOException e) {
                LogUtil.error("Error occurred in screenshot file operations!", e);
            }
        }).start();
    }

    // Verilen rakam uzunluğunda rondam kelime oluşturma metodu
    public static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public void errorMessage(String appName, String scenarioName, String message, String exceptionMessage) {
        getScreenshot(appName, scenarioName);
        LogUtil.error(message, exceptionMessage);
        Assert.fail(message);
    }

    public static void errorMessage(AndroidDriver<AndroidElement> driver, String appName, String scenarioName, String message) {
        getScreenshot(driver, appName, scenarioName);
        LogUtil.error(message, "");
        Assert.fail(message);
    }
}
