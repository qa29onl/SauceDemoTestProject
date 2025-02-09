package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By CART_BUTTON = By.xpath("");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }
}
