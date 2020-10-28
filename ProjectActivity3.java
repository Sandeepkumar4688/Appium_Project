package MavenTest.NewAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
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

public class ProjectActivity3 {
	AppiumDriver<MobileElement> driver = null;
WebDriverWait wait;
@BeforeClass
public void GoogletaskPrep() throws InterruptedException, IOException {
	
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceId", "9721d69d");
    caps.setCapability("deviceName", "RealMe");
    caps.setCapability("platformName", "android");
    caps.setCapability("appPackage", "com.google.android.keep");
    caps.setCapability("appActivity", ".activities.BrowseActivity");
    caps.setCapability("noReset", "true");
	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
@Test
public void GoogleKeep() 
{
//driver.findElementById("com.google.android.keep:id/skip_welcome").click();
  driver.findElementByAccessibilityId("New text note").click();
  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Google keep activity");
  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Activity for google keep");

  driver.findElementByAccessibilityId("Single-column view").click();
 
  List<MobileElement> items = driver.findElementsByClassName("android.widget.Spinner");
  MobileElement element = items.get(1);
  element.click();

		  driver.findElementById("com.google.android.keep:id/reminder_time_night").click();
  driver.findElementById("com.google.android.keep:id/save").click();
  driver.findElementByAccessibilityId("Open navigation drawer").click();
  
  //Check reminder:
  driver.findElementByAccessibilityId("Open navigation drawer").click();
  driver.findElementById("com.google.android.keep:id/drawer_navigation_reminders").click();
  
  String title = driver.findElementById("com.google.android.keep:id/index_note_title").getText();
  Assert.assertEquals(title, "Google keep activity");
  System.out.println(title+"is a reminder");
  
}


}
