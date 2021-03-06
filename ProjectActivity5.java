package MavenTest.NewAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ProjectActivity5 {
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
	@Test (priority = 0)
	public void ValidLogin() throws InterruptedException 
	{
		driver.get("https://www.training-support.net/selenium");
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Login Form\"))"));
		driver.findElementByXPath("//android.widget.TextView[@text='Login Form']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("admin");
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		String msg = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "Welcome Back, admin");
	
	}
	@Test (priority = 1)
	public void InValidLogin() throws InterruptedException 
	{
		driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='username']").sendKeys("adminuser");
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").clear();
		driver.findElementByXPath("//android.widget.EditText[@resource-id='password']").sendKeys("password");
		driver.findElementByXPath("//android.widget.Button[@text='Log in']").click();
		String msgtwo = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
		System.out.println(msgtwo);
		Assert.assertEquals(msgtwo, "Invalid Credentials");
	}

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
