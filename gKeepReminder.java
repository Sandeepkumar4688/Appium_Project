package Appium.SDET_MobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class gKeepReminder {
	  AppiumDriver<MobileElement> driver = null;
	  DesiredCapabilities caps = null;
	  URL myUrl = null;
		 
	  String noteTitle;
	  String noteDescription;
	  String noteReminder;
	  
	  @BeforeClass
	  public void beforeClass() throws MalformedURLException {
		  caps = new DesiredCapabilities();
		  caps.setCapability("deviceId", "");
	      caps.setCapability("deviceName", "OK6000 Plus");
	      caps.setCapability("platformName", "Android");
	      caps.setCapability("appPackage", "com.google.android.keep");
	      caps.setCapability("appActivity", ".activities.BrowseActivity");
	      caps.setCapability("noReset", true);
	      
	      myUrl = new URL("http://127.0.0.1:4723/wd/hub");
	      
	      driver = new AndroidDriver<MobileElement>(myUrl,caps);
	      
	      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  }
		
	  @Test
	  public void myNotes() {
		 
		  //click add note
		  driver.findElementById("com.google.android.keep:id/new_note_button").click();
		  //enter note title
		  driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("My Notes with reminder");
		  //enter note description
		  driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("Complete SDET project within next alarm");
		  //add and save reminder
		  driver.findElementById("com.google.android.keep:id/menu_reminder").click();
		  
		  //List<MobileElement> reminderOptions = driver.findElementsById("com.google.android.keep:id/text");
		  //System.out.println(reminderOptions);
		  driver.findElementById("com.google.android.keep:id/time_spinner").click();
		  driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Afternoon\")")).click();
		  
		  driver.findElementById("com.google.android.keep:id/save").click();
		  
		  //save note
		  driver.findElementByAccessibilityId("Navigate up").click();
		  
		  //capture the added note  
		  
		  //String noteTitle = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByTest(UiSelector().resourceId(\"com.google.android.keep:id/index_note_title\"),\"My Notes with reminder\")")).getText();
		  //String noteDescription = driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).getChildByText(UiSelector().resourceId(\"com.google.android.keep:id/index_note_text_description\"),\"Complete SDET project within next alarm\")")).getText();
		  //String noteReminder = driver.findElementById("com.google.android.keep:id/reminder_chip_text").getText();
		  
		  List<MobileElement> allTitles = driver.findElementsById("com.google.android.keep:id/index_note_title");
		  List<MobileElement> allDescription = driver.findElementsById("com.google.android.keep:id/index_note_text_description");
		  List<MobileElement> allReminder = driver.findElementsById("com.google.android.keep:id/reminder_chip_text");

		  
		  for (MobileElement x : allTitles) {
			  System.out.println(x.getText());
			  if (x.getText().equals("My Notes with reminder")) {
				  noteTitle = x.getText();
			  }
		  }
		  
		  for (MobileElement x: allDescription) {
			  System.out.println(x.getText());
			  if (x.getText().equals("Complete SDET project within next alarm")) {
				  noteDescription = x.getText();
			  }
		  }
		  
		  for (MobileElement x: allReminder) {
			  System.out.println(x.getText());
			  if (x.getText().contains("1:00 PM")) {
				  noteReminder = x.getText();
			  }
		  }
		  
		  System.out.println("noteTitle is "+ noteTitle);
		  System.out.println("noteDescription is "+ noteDescription);
		  System.out.println("noteReminder is "+ noteReminder);
		  
		  Assert.assertEquals(noteTitle, "My Notes with reminder");
		  Assert.assertEquals(noteDescription, "Complete SDET project within next alarm");
		  Assert.assertEquals(noteReminder, "Today, 1:00 PM");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}
