package testdata;

import pojo.User;
import utils.APIUtils;
import utils.ConfigReader;

public class TestDataFactory {

    public static User createUser() {

        User user = new User();

        user.name = "Madhushree";
        user.email = APIUtils.generateEmail();
        user.password = ConfigReader.get("password");

        user.title = "Mrs";
        user.birth_date = "10";
        user.birth_month = "May";
        user.birth_year = "1998";

        user.firstname = "Madhu";
        user.lastname = "QA";

        user.address1 = "Bangalore";
        user.country = "India";
        user.zipcode = "560001";
        user.state = "KA";
        user.city = "Bangalore";

        user.mobile_number = "9999999999";

        return user;
    }
}