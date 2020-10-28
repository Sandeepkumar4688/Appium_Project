package MavenTest.NewAppium;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ProjectActivity1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
    @BeforeClass
    public void GoogletaskPrep() throws InterruptedException, IOException {
    	
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "9721d69d");
        caps.setCapability("deviceName", "RealMe");
        caps.setCapability("platformName", "android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", "com.google.android.apps.tasks.ui.TaskListsActivity");
        caps.setCapability("noReset", "true");
    	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
 }
    
    @Test
    public void Googletaskone() throws InterruptedException, IOException {
       
    	//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("welcome_get_started")));
    	//driver.findElementById("welcome_get_started").click();
    	driver.findElementByAccessibilityId("Create new task").click();
    	//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
    	driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
    	driver.findElementById("add_task_done").click();
    	driver.findElementByAccessibilityId("Create new task").click();
    	//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
    	driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
    	driver.findElementById("add_task_done").click();
    	driver.findElementByAccessibilityId("Create new task").click();
    	//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("add_task_title")));
    	driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
    	driver.findElementById("add_task_done").click();
    	//driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Tab Opener\"))"));
    	String task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.widget.LinearLayout/android.widget.TextView").getText();
    	
    	String task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.widget.LinearLayout/android.widget.TextView").getText();
    	
    	String task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.widget.LinearLayout/android.widget.TextView").getText();
    	//String task1 = driver.findElementsByAccessibilityId("Complete  the second Activity Google Keep").getText();
    	
    	Assert.assertEquals(task1, "Complete the second Activity Google Keep");
    
    	Assert.assertEquals(task2, "Complete Activity with Google Keep");
    
    	Assert.assertEquals(task3, "Complete Activity with Google Tasks");
   
    }
}
