package Appium.SDET_MobileTest;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class calcMultiply {
	AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "");
        caps.setCapability("deviceName", "OK6000 Plus");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
 
    @Test
    public void multiply() throws IOException {
        driver.findElementById("digit_7").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_4").click();
        driver.findElementById("eq").click();
        
        //Display Result
        String result = driver.findElementById("result").getText();
        System.out.println(result);
        Assert.assertEquals(result, "28");
        
        File destFile = new File("C:\\Users\\XMT5NJV\\Documents\\Harini\\Auto\\LEARNINGS\\SDET Reskill\\Mobile testing-Appium\\SS\\ss.jpg");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
        System.out.println("File path is: "+ destFile.getPath());
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
