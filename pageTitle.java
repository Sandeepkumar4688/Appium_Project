package Appium.SDET_MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class pageTitle {

	  DesiredCapabilities caps=null;
	  URL myurl=null;
	  AppiumDriver<MobileElement> driver=null;
	
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
	  
	  @Test 
	  public void mainPage() {
		  //access the webpage
		  driver.get("https://www.training-support.net/");
		  //get title using getTitle method
//		  String mytitle = driver.getTitle();
//		  System.out.println("Title of home page is: "+ mytitle);
		  //get title using element identification
		  String title = driver.findElementByXPath("//android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
		  System.out.println("Title of home page is: "+ title);
		  
		  //click about us button
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true).instance(0)).scrollIntoView(UiSelector().resourceId(\"about-link\"))")).click();
		  //get new page title
		  String newTitle = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
		  System.out.println("Title of new page is: "+ newTitle);
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }

}
