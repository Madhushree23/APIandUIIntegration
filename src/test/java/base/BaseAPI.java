package base;


import io.restassured.RestAssured;
import utils.ConfigReader;

public class BaseAPI {

    static {
        RestAssured.baseURI = ConfigReader.get("baseUrl");
    }
}