package tests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static pages.LoginPage.*;

public class LoginTest extends BaseTest {
    @Test
    public void loginWithEmptyUsernameTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", PASSWORD);
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Parameters({"username", "password"})
    @Test
    public void successLoginTest(@Optional("usernameExample") String user,
                                 @Optional("passwordExample") String pass) {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(user, pass);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(description = "QA-1 This test login on site with empty password")
    public void loginWithEmptyPasswordTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.waitForPageOpened();
        loginPage.login(USERNAME, "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_PASSWORD_ERROR);
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), EMPTY_FIELD_USERNAME_ERROR);
    }

    @Test
    public void loginWithIncorrectFieldsTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login("efwefwe", "efwfwe");
        Assert.assertEquals(loginPage.getErrorMessageText(), INCORRECT_DATA_IN_FIELDS);
    }
}
