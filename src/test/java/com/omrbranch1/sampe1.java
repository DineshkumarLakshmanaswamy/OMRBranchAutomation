package com.omrbranch1;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

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
	
	public static  void getTextHtel() {
		WebElement element = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id='select_hotel_text']")); 
		String text
		= element.getText(); System.out.println(text);

	}
	public static void swipe() {
		Dimension size = driver.manage().window().getSize();
		System.out.println(size);

		int width = size.getWidth();
		System.out.println(width);

		int height = size.getHeight();
		System.out.println(height);

		int center =width/2;
		System.out.println(center);


		int start =(int) (height*0.70);
		System.out.println(start);

		int end=(int)(height*0.20);
		System.out.println(end);


		// Create Object for PointerInput Class
		PointerInput pointerInput = new PointerInput(Kind.TOUCH, "finger 1");

		// Create Object for Sequence Class
		Sequence sequence = new Sequence(pointerInput, 1);

		// Move to start position
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), center, start));

		// Press
		sequence.addAction(pointerInput.createPointerDown(MouseButton.LEFT.asArg()));

		// Move To end position
		sequence.addAction(pointerInput.createPointerMove(Duration.ofSeconds(1), Origin.viewport(), center, end));

		// Release
		sequence.addAction(pointerInput.createPointerUp(MouseButton.LEFT.asArg()));

		List<Sequence> asList = Arrays.asList(sequence);

		RemoteWebDriver remoteWebDriver = (RemoteWebDriver) driver;
		remoteWebDriver.perform(asList);


	}
	public static void selectHotel() {

		driver.findElement(By.xpath("//android.widget.TextView[@text=\'Continue\']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button2']")).click();
		WebElement bookHotel = driver
				.findElement(By.xpath("//android.widget.TextView[@resource-id='book_hotel_text']"));
		String text = bookHotel.getText();
		System.out.println(text);

	}
	public static void GuestDetails() {
		WebElement myselfRdoBtn = driver.findElement(By.xpath(
				"(//android.view.ViewGroup[@resource-id='book_hotel_booking_for'])[1]/android.widget.ImageView"));
		myselfRdoBtn.click();

		driver.findElement(By.xpath("//android.widget.TextView[@text='Select Salutation']")).click();


		driver.findElement(By.xpath("//android.widget.TextView[@text='Mr.']")).click();

		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_first_name']")).sendKeys("DineshKumar");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_last_name']")).sendKeys("Lakshmanaswamy");



	}
	public static void Gstdetails() {
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_mobile_no']")).sendKeys("9629470804");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='book_hotel_email']")).sendKeys("dineshkumarlakshmanaswamy2@gmail.com");


		WebElement gstBtn = driver.findElement(
				By.xpath("//android.view.ViewGroup[@resource-id='book_hotel_enter_gst']/android.widget.ImageView"));
		gstBtn.click();
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_registration\"]")).sendKeys("9043592058");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_company_name\"]")).sendKeys("Greens Tech OMR Branch");
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"book_hotel_company_address\"]")).sendKeys("Thoraipakkam");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
	}

	public static void specialRequest() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='filter_option_late']")).click();	
		driver.findElement(By.xpath("//android.widget.EditText[@content-desc='TextInput']")).sendKeys(" what food is special in the hotel");
		driver.findElement(By.xpath("//android.widget.TextView[@text='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.View[@resource-id='step-3']/android.view.View/android.view.View[3]/android.view.View")).click();


	}
}
