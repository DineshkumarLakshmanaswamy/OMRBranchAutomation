package com.omrbranch1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class sampe1 {
	static WebDriver driver;
	public static void applaunch() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium:platformVersion", "15");
		capabilities.setCapability("appium:appPackage", "com.omr_branch");
		capabilities.setCapability("appium:appActivity", "com.omr_branch.MainActivity");
		capabilities.setCapability("appium:automationName", "UIAutomator2");
		capabilities.setCapability("appium:deviceName", "10BE2K09Q7000SL");
		capabilities.setCapability("appium:platformName", "Android");

		URL url = new URL("http://127.0.0.1:4723/");
		driver = new AppiumDriver(url, capabilities);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}


	public static  void login() {

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Email Address']")).sendKeys(
				"dineshkumarlakshmanaswamy2@gmail.com");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='Password']")).sendKeys(
				"Dinesh@2002");
		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id='login_button']")).click();



	}
	
	public static  void searchhotel() {
		driver.findElement(By.
				xpath("//android.widget.TextView[@text=\'Select State\']")).click();
		driver.findElement(By.
				xpath("//android.widget.TextView[@text='Andhra Pradesh']")).click();
		driver.findElement(By.
				xpath("//android.widget.TextView[@text=\'Select City\']")).click();
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\'Tirupati\']")).click();
		driver.findElement(By.
				xpath("//android.widget.TextView[@text=\'Select Room Type\']")).click();
		driver.findElement(By.xpath(
				"//android.view.ViewGroup[@content-desc=\'Suite\']")).click();
		driver.findElement(By.xpath(
				"//android.widget.EditText[@content-desc=\'search_select_checkin\']")).click(
						);
		driver.findElement(By.xpath("//android.view.View[@content-desc=\'12 November 2025\']")).click();
		driver.findElement(By.xpath(	"//android.widget.Button[@resource-id=\'android:id/button1\']")).click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\'search_select_checkout\']")).click
		(); driver.findElement(By.xpath("//android.view.View[@content-desc=\'19 November 2025\']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\'android:id/button1\']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'No. Of Room\']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'1-One\']")).
		click(); 
		driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\'search_select_no_of_adults_container\']/android.view.ViewGroup"
				)).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text=\'1-One\']")).
		click(); 
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\'search_no_of_children\']")).
		sendKeys("2");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Search']")).
		click();

	}

}
