package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends Preconditions {

    @DataProvider(name = "products")
    public Object[][] productsAndPrices() {
        return new Object[][] {
                {SAUCE_LABS_BACKPACK, "$29.99"},
                {SAUCE_LABS_BOLT_T_SHIRT, "$15.99"},
                {SAUCE_LABS_BIKE_LIGHT, "$9.99"},
                {SAUCE_LABS_FLEECE_JACKET, "$49.99"},
                {SAUCE_LABS_ONESIE, "$7.99"},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED, "$15.99"},
        };
    }

    /**
     *
     * @param productName
     * @param price
     */
    @Test(dataProvider = "products")
    public void addProductToCartTest(String productName, String price){
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .waitForPageOpened()
                .login(userSuccess)
                .addProductToCart(productName);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(productName), price);
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkQuantityTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userSuccess)
                .addProductToCart(SAUCE_LABS_BOLT_T_SHIRT, SAUCE_LABS_BACKPACK);
        cartPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity(), 2);
    }

    @Test
    public void removeItemFromCartTest() {
        loginPage
                .openPage(LOGIN_PAGE_URL);
        loginPage
                .login(userSuccess)
                .addProductToCart(SAUCE_LABS_BACKPACK);
        cartPage
                .openCartPage(CART_PAGE_URL)
                .removeProductFromCart(SAUCE_LABS_BACKPACK);
        Assert.assertFalse(cartPage.isProductDisplayed(SAUCE_LABS_BACKPACK));
    }
}
