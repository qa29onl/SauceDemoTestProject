package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {
    //loginPage.openPage()
    //loginPage.login(username, password)
    //productPage.addToCart("Product Name")
    //cartPage.openPage()
    //cartPage.getQuantity("Product Name")
    //cartPage.getPrice("Product Name")
    //Assertions

    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
