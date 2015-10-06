package test.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

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
	    //Check if label is on screen
		driver.findElement(By.name("My Label"));
			
	  	// find button with label Button
		WebElement button=driver.findElement(By.name("Button"));
		// click on button and change the label text to something
		button.click();
		
		// find button with label or content-description New Button
		driver.findElement(By.name("something"));
	}
  
@BeforeTest
public void setUp() throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS 6.0");
    capabilities.setCapability("device", "iPhone Simulator");
    capabilities.setCapability(CapabilityType.PLATFORM, "Mac 10.8");

    //zip file containing your app to be tested
    capabilities.setCapability("app", "http://appium.s3.amazonaws.com/TestApp6.0.app.zip");
    
    
}



@AfterTest
  public static void tearDown(){
		driver.quit();
	}

}