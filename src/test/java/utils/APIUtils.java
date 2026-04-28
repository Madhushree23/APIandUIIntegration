package utils;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class APIUtils  {
	
	  public static String generateEmail() {
	        return "madhu" + System.currentTimeMillis() + "@gmail.com";
	    }
	

	    }