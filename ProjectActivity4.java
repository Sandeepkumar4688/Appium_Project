package MavenTest.NewAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class ProjectActivity4 {

	AppiumDriver<MobileElement> driver = null;
WebDriverWait wait;
@BeforeClass
public void GoogletaskPrep() throws InterruptedException, IOException {
	
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceId", "9721d69d");
    caps.setCapability("deviceName", "RealMe");
    caps.setCapability("platformName", "android");
    caps.setCapability("appPackage", "com.android.chrome");
    caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
    caps.setCapability("noReset", "true");
	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
@Test
public void GoogleChrome() throws InterruptedException 
{
	driver.get("https://www.training-support.net/selenium");
	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"To-Do List\"))"));
	driver.findElementByAccessibilityId("To-Do List Elements get added at run time").click();
	Thread.sleep(500);
	driver.findElementByClassName("android.widget.EditText").sendKeys("Task1");
	//driver.findElementById("taskInput").sendKeys("Task1");
	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	//driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[1]").sendKeys("Task1");
	driver.findElementByClassName("android.widget.EditText").sendKeys("Task2");
	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	driver.findElementByClassName("android.widget.EditText").sendKeys("Task3");
	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	driver.findElementByClassName("android.widget.EditText").sendKeys("Task4");
	driver.findElementByXPath("//android.widget.Button[@text='Add Task']").click();
	
	 List<MobileElement> ListofTasks = driver.findElementsByXPath("//android.view.View/android.view.View/android.view.View/android.view.View");
	 System.out.println("Number of tasks: "+ListofTasks.size());
	 for (int i = 0; i < ListofTasks.size(); i++) 
	 {
		 ListofTasks.get(i).click();
	 }

	// driver.findElementByXPath("//android.widget.TextView[@text='Clear List']").click();
	 String title = driver.findElementByClassName("android.widget.TextView").getText();
	 System.out.println("Title: "+title);
	 Assert.assertEquals(title, "To-Do List");
}
}
