package services;

import constants.Endpoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.User;
import specs.RequestSpecUtil;
import specs.ResponseSpecUtil;

public class UserService {

    public Response createUser(User user) {

        return RestAssured.given()
                .spec(RequestSpecUtil.getRequestSpec())
                .formParam("name", user.name)
                .formParam("email", user.email)
                .formParam("password", user.password)
                .formParam("title", user.title)
                .formParam("birth_date", user.birth_date)
                .formParam("birth_month", user.birth_month)
                .formParam("birth_year", user.birth_year)
                .formParam("firstname", user.firstname)
                .formParam("lastname", user.lastname)
                .formParam("address1", user.address1)
                .formParam("country", user.country)
                .formParam("zipcode", user.zipcode)
                .formParam("state", user.state)
                .formParam("city", user.city)
                .formParam("mobile_number", user.mobile_number)
        .when()
                .post(Endpoints.CREATE_USER);
    }

    public void validateCreate(Response res) {

        res.then().spec(ResponseSpecUtil.getResponseSpec());

        if (res.jsonPath().getInt("responseCode") != 201) {
            throw new RuntimeException("API user creation failed");
        }
    }

    public void updateUser(User user) {

        user.name = "UpdatedName";

        RestAssured.given()
                .spec(RequestSpecUtil.getRequestSpec())
                .formParam("name", user.name)
                .formParam("email", user.email)
                .formParam("password", user.password)
        .when()
                .put(Endpoints.UPDATE_USER)
        .then()
                .spec(ResponseSpecUtil.getResponseSpec());
    }

    public String getUserName(String email) {

        return RestAssured.given()
                .spec(RequestSpecUtil.getRequestSpec())
                .queryParam("email", email)
        .when()
                .get(Endpoints.GET_USER)
                .jsonPath()
                .getString("user.name");
    }

    public void deleteUser(User user) {

        RestAssured.given()
                .spec(RequestSpecUtil.getRequestSpec())
                .formParam("email", user.email)
                .formParam("password", user.password)
        .when()
                .delete(Endpoints.DELETE_USER)
        .then()
                .spec(ResponseSpecUtil.getResponseSpec());
    }
}