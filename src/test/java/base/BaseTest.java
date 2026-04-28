package base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import io.restassured.RestAssured;
import utils.ConfigReader;

public class BaseTest {

	 protected WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        RestAssured.baseURI = ConfigReader.get("baseUrl");

	        DriverFactory.initDriver();
	        driver = DriverFactory.getDriver();
	    }

	    @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }
	}