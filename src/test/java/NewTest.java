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
		driver.findElement(By.name("Hello World of Appium and Calabash"));		
		Thread.sleep(5000);
	}
  
@BeforeTest
public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("platformName", "iOS");
    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
    capabilities.setCapability("platformVersion", "9.0.2");
    capabilities.setCapability("deviceName", "iPhone 4s");
    capabilities.setCapability("app", "/Users/Shared/Jenkins/Desktop/JenkinsTestBuild.app");
    
    try {
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4475/wd/hub"), capabilities);
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
}

@AfterTest
  public static void tearDown(){
		driver.quit();
	}	
}
