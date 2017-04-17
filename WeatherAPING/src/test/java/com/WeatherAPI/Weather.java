package com.WeatherAPI;

import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class Weather {

	private static WebDriver dr;

	// Start BeforeClass to provide startup of the application
	@BeforeClass
	public static void start() {

		// Assigned the WebDriver
		dr = new FirefoxDriver();

	}// end start
		// Start of First Test

	@Test
	public void CityName() throws JSONException, ParseException {

		// Retrieved the URL
		dr.get("http://api.openweathermap.org/data/2.5/weather?q=Lagos,us&APPID=15bbc55515f9a14b1e1b097e6f918185");

		// Put a pause or wait for 60 second
		dr.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Find the Element from the link and click
		WebElement we_dat = dr.findElement(By.tagName("pre"));

		// Declare and assign element output to a variable
		String we_dats = we_dat.getText();

		// Declare and initalize JSon object to parse the string
		JSONObject jd = new JSONObject(we_dats);

		// Declare and assign output to a node for the variable to a string
		String names = jd.getString("name");

		// Output the value
		System.out.println(names);
		// verified the element to a string
		Assert.assertEquals(names, "Lagos");

	}

	@AfterClass
	public static void CleanUp() {
		// Close all WebDriver
		dr.close();

		// Print Displayed of the results of the test.
		//System.out.println("Test Successful");

	}
}
