package test;

import org.junit.Test;

import helper.Constants;
import helper.TestHelper;
import page.CartPage;
import page.LoginPage;
import page.ProductPage;

public class ShoppingCartTest extends TestHelper {
	ProductPage productPage = new ProductPage(driver);

	
	public void shouldBeAbleToAddProduct() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);
		
//		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart("Sauce Labs Backpack");
		
		String cartQuantityBadge = productPage.getCartBadgeQuantity();
		
		verifyEquals("Cart quantity not matched", "1", cartQuantityBadge);
	}
	
	@Test
	public void verifyShoppingCart() {
		String productName = "Sauce Labs Bike Light";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);
		
		ProductPage productPage = new ProductPage(driver);
		productPage.clickOnAddToCart(productName);
		productPage.clickOnCart();
		
		CartPage cartPage = new CartPage(driver);
		
		String actualQuanity = cartPage.getCartProductQuantity();
		verifyEquals("Cart quantity not matched", "2", actualQuanity);
		
		String actualProductName = cartPage.getCartProductName();
		verifyEquals("Product name not matched.", productName, actualProductName);
		
		String cartProdcutPrice = cartPage.getCartProductPrice();
		verifyEquals("Cart product price not matched", "$1.99", cartProdcutPrice);
		
		boolean continueButton = cartPage.isContinueButtonDisplayed();
		verifyTrue("Continu Shopping button not showed.", continueButton);
		
		boolean checkoutButton = cartPage.isCheckoutButtonDisplayed();
		verifyTrue("Checkout button not displayed.", checkoutButton);

	}
}
