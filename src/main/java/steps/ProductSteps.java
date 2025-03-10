package steps;

import constants.IConstants;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Step("Login and add product to cart")
    public ProductSteps loginAndAddProduct(String username, String password, String productName) {
        loginPage
                .openPage(IConstants.LOGIN_PAGE_URL);
        loginPage
                .login(username, password)
                .addProductToCart(productName);
        return this;
    }

    @Step("Add product to cart")
    public ProductSteps addProductToCart(String productName) {
        productsPage
                .addProductToCart(productName);
        return this;
    }
}