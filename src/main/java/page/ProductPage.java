package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.PageHelper;

public class ProductPage extends PageHelper {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddToCart(String productName) {
		driver.findElement(By
				.xpath("//*[@class='inventory_item_name'][contains(text(),'" + productName + "')]//..//..//..//button"))
				.click();
	}

	public void clickOnCart() {
		driver.findElement(By.className("shopping_cart_link")).click();
	}

	public String getCartBadgeQuantity() {
		return driver.findElement(By.className("shopping_cart_badge")).getText();
	}
}
