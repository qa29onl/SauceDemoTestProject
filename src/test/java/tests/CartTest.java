package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void checkProductPriceInCartTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(SAUCE_LABS_BOLT_T_SHIRT), "$15.99");
    }

    @Test
    public void checkQuantityTest() {
        loginPage.openPage(LOGIN_PAGE_URL);
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity(), 2);
    }
}
