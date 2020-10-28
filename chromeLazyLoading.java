package Appium.SDET_MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class chromeLazyLoading {
	DesiredCapabilities caps=null;
	  URL myurl=null;
	  AppiumDriver<MobileElement> driver=null;
	  WebDriverWait wait = null;
	  
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
		  
		  wait = new WebDriverWait(driver,10);
	  }
	
	  @Test
	  public void lazyLoading()  {
		  driver.get("https://www.training-support.net/selenium/lazy-loading");
		  
		  //Get the number of images shown in the view
		  List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	      System.out.println("Number of image shown currently: " + numberOfImages.size());
	        
		  
		  //Scroll to the card with Helen's post
		  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
	        
		  
		  //Get number of images shown on the screen after scrolling
		  numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	      System.out.println("Number of image shown currently: " + numberOfImages.size());
	        
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  //driver.close();
	  }
}
