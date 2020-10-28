package Appium.SDET_MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class chromePopups {
	  DesiredCapabilities caps=null;
	  URL myurl=null;
	  AndroidDriver<MobileElement> driver=null;
	
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "");
	      caps.setCapability("deviceName", "OK6000 Plus");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("appPackage", "com.android.chrome");
	      caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	      caps.setCapability("noReset", true);
		  
		  myurl = new URL("http://127.0.0.1:4723/wd/hub");
		  driver = new AndroidDriver<MobileElement>(myurl,caps);	
		  
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
	
	  @Test (priority=1)
	  public void loginForm() throws InterruptedException {
		  //access the webpage
		  driver.get("https://www.training-support.net/selenium");
		  Thread.sleep(3000);
		  
		  //scroll to and click Login Form List
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).getChildByDescription(UiSelector().className(\"android.view.View\"), \"Popups\")"));
		  driver.findElementByXPath("//android.view.View[@content-desc=\"Popups Tooltips and Modals\"]").click();
		  
	  }
	  @Test (priority=2)
	  public void validCred() throws InterruptedException {
		  //click sign in button
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign In\")")).click();
		  
		  //enter valid username & password
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"username\")")).sendKeys("admin");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log in\")")).click();

		  //capture the confirmation text
		  String result = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"action-confirmation\")")).getText();
		  
		  Assert.assertEquals(result, "Welcome Back, admin");
	  }
	  @Test (priority=3)
	  public void invalidCred() throws InterruptedException {
		  //click sign in button
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign In\")")).click();
		  
		  //enter invalid username & password
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"username\")")).sendKeys("user");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"password\")")).sendKeys("password");
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Log in\")")).click();

		  //capture the confirmation text
		  String result = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().resourceId(\"action-confirmation\")")).getText();
		  
		  Assert.assertEquals(result, "Invalid Credentials");
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }
}
