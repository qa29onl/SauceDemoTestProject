package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.IConstants.*;

public class CartTest extends Preconditions {

    @DataProvider(name = "products")
    public Object[][] products() {
        return new Object[][] {
                {SAUCE_LABS_BACKPACK},
                {SAUCE_LABS_BOLT_T_SHIRT},
                {SAUCE_LABS_BIKE_LIGHT},
                {SAUCE_LABS_FLEECE_JACKET},
                {SAUCE_LABS_ONESIE},
                {TEST_ALL_THE_THINGS_T_SHIRT_RED},
        };
    }

    @DataProvider(name = "productsAndPrices")
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

    @Test(dataProvider = "products")
    public void addProductToCartWithDataProviderTest(String product){
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertTrue(cartPage.isProductDisplayed(product));
    }

    @Test(dataProvider = "productsAndPrices")
    public void addProductToCartTest(String product, String price){
        productSteps.loginAndAddProduct(USERNAME, PASSWORD, product);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(product), price);
    }

    @Test(dataProvider = "products")
    public void checkProductPriceTest(String product) {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        String productPrice = productsPage.getProductPrice(product);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice(product),productPrice);
    }

    @Test(dataProvider = "products")
    public void removeItemFromCartTest(String product) {
        productSteps.loginAndAddProduct(USERNAME,PASSWORD,product);
        cartPage
                .openCartPage(CART_PAGE_URL)
                .removeProductFromCart(product);
        Assert.assertFalse(cartPage.isProductDisplayed(product));
    }

    @Test(retryAnalyzer = Retry.class)
    public void checkQuantityTest() {
        productSteps.loginAndAddProduct(USERNAME, PASSWORD, SAUCE_LABS_BACKPACK);
        productsPage.addProductToCart(SAUCE_LABS_FLEECE_JACKET);
        cartPage.openCartPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductQuantity().toString(),"2");
    }
}
