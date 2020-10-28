package Appium.SDET_MobileTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class chromeTabOpener {
	WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;
 
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
 
        // Open page
        driver.get("https://www.training-support.net/selenium");
    }
 
    @Test
    public void scrollIntoViewTest() {
    	System.out.println("running scrollIntoView");
    	// Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
 
        // Scroll element into view and click it
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"Tab Opener\"))")).click();
        // driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"Tab Opener\")")).click();
        // driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollDescriptionIntoView(\"Tab Opener Launch new tabs with the click of a button.\")")).click();
 
        // Print page title
        String pageTitle = driver.findElementByClassName("android.widget.TextView").getText();
        System.out.println("Page title is: " + pageTitle);
 
        // Assertion
        //Assert.assertEquals(pageTitle, "New Tab");
 
        // Go back one page
        driver.navigate().back();
    }
 
    @Test
    public void getChildTest() {
    	System.out.println("running getChild");
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View")));
 
        // Scroll element into view and click it
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).getChildByText(UiSelector().className(\"android.widget.TextView\"), \"Tab Opener\")")).click();
        //driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByDescription(UiSelector().className(\"android.view.View\"), \"Tab Opener Launch new tabs with the click of a button.\")")).click();
 
        // Print page title
        String pageTitle = driver.findElementByClassName("android.widget.TextView").getText();
        System.out.println("Page title is: " + pageTitle);
 
        // Assertion
        //Assert.assertEquals(pageTitle, "New Tab Opener");
 
        // Go back one page
        driver.navigate().back();
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
