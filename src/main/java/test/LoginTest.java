package test;

import org.junit.Test;
import org.openqa.selenium.By;

import automationpractice.ui.test.LoginPage;
import helper.Constants;
import helper.TestHelper;

public class LoginTest extends TestHelper {

	@Test
	public void loginWithValidData() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin(Constants.USERNAME, Constants.PASSWORD);

		verifyTrue("Cart not found after login", driver.findElement(By.id("shopping_cart_container")).isDisplayed());
	}

	@Test
	public void loginWithInvalidDataShouldNotBeSuccessful() {
		String expectedErrorMessage = "Epic sadface: Username & Password do not match";

		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin("standard_user", "fake-password");

		String actualErrorMessage = driver.findElement(By.cssSelector(".login-box h3[data-test='error']")).getText();

		verifyEquals("Login error message not matched", expectedErrorMessage, actualErrorMessage);
	}

}
