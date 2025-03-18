package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static pages.LoginPage.*;

public class LoginTest extends Preconditions {
    @Test
    public void loginWithEmptyUsernameTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyUsername);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Parameters({"username", "password"})
    @Test
    public void successLoginTest1(@Optional(USERNAME) String user,
                                 @Optional(PASSWORD) String pass) {
        loginSteps.loginAndWaitForPageOpened(user, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void successLoginTest2() {
        loginSteps.loginAndWaitForPageOpened(
                System.getenv().getOrDefault("username", PropertyReader.getProperty("username")),
                System.getenv().getOrDefault("password", PropertyReader.getProperty("password")));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(description = "QA-1 This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginSteps.loginAndWaitForPageOpened(userWithEmptyPassword);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userEmptyFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginSteps.loginAndWaitForPageOpened(userIncorrectFields);
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }
}
