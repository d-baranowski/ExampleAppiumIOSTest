package test.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.*;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

  private static WebDriver driver = null;
  @Test
  public void appiumExampleTest() throws Exception {
	    //Check if label with text My Label is visible on the screen 
		driver.findElement(By.name("My Label"));
			
	  	//Find the button with text Button and press it
		WebElement button=driver.findElement(By.name("Button"));
		//In the app im testing this should change the label text to "something"
		button.click();
		
		//See if the text has changed 
		driver.findElement(By.name("something"));
	}
  
@BeforeTest
public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability(MobileCapabilityType.VERSION, "7.0");
    //capabilities.setCapability(MobileCapabilityType.LAUNCH_TIMEOUT, "false");
    //capabilities.setCapability(MobileCapabilityType.DEVICE_READY_TIMEOUT, "0");
    capabilities.setCapability("platformVersion", "9.0");
    capabilities.setCapability("deviceName", "iPhone 4s");
    capabilities.setCapability("browserName", "");
    //Absolute path to the app file of the app to be tested 
    capabilities.setCapability("app", "//Users//Shared//Jenkins//Downloads//iOSapp//SampleiOsAppToBuildOnJenkinsMacSlave//build//Release-iphoneos//JenkinsTestBuild.app");
    
    try {
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4473/wd/hub"), capabilities);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}

	driver.manage().timeouts().implicitlyWait(380, TimeUnit.SECONDS);
}

@AfterTest
  public static void tearDown(){
		driver.quit();
	}
}
