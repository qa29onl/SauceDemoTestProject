package tests;

import constants.IConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends Preconditions {
    @Test
    public void isAddToCartButtonDisplayedTest() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(userSuccess);
        Assert.assertTrue(productsPage.isAddToCartButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }

    @Test
    public void isRemoveButtonDisplayedTest() {
        loginPage.openPage(IConstants.LOGIN_PAGE_URL);
        loginPage.login(userSuccess);
        productsPage.addProductToCart(SAUCE_LABS_BOLT_T_SHIRT);
        Assert.assertTrue(productsPage.isRemoveButtonDisplayed(SAUCE_LABS_BOLT_T_SHIRT));
    }
}
