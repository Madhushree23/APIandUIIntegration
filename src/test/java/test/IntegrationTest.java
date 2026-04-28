package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pojo.User;
import services.UserService;
import testdata.TestDataFactory;
import utils.ConfigReader;
@Listeners(utils.TestListners.class)
public class IntegrationTest extends BaseTest {
	
	
//	“Create data using API → use same data in UI → again validate using API”
	
	
	
	@Test
    public void fullFlowTest() {
	UserService service = new UserService();

    // API CREATE
    User user = TestDataFactory.createUser();
    var response = service.createUser(user);
    service.validateCreate(response);

    // UI LOGIN
    driver.get(ConfigReader.get("uiUrl"));

    LoginPage login = new LoginPage(driver);
    login.login(user.email, user.password);

    String text = driver.findElement(
            By.xpath("//a[contains(text(),'Logged in as')]")
    ).getText();

    Assert.assertTrue(text.contains(user.name));

    // API UPDATE
    service.updateUser(user);
    System.out.println(user.email);

    // API GET
    String updated = service.getUserName(user.email);
    Assert.assertEquals(updated, "UpdatedName");
    System.out.println("This is updated name" + updated);

    // API DELETE
    //service.deleteUser(user);
}
}