package automationpractice.ui.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	private WebDriver driver;

	@Before
	public void setupDriver() {

		// open browser
		System.setProperty("webdriver.chrome.driver", "C:\\\\Projects\\\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@After
	public void teardownDriver() {
		driver.quit();
	}

	@Test
	public void loginWithValidData() {
		driver.get("http://www.saucedemo.com/");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.submitLogin("standard_user", "secret_sauce");
		Assert.assertTrue("Cart not found after login",
				driver.findElement(By.id("shopping_cart_container")).isDisplayed());
	}

	@Test
	public void loginWithInvalidDataShouldNotBeSuccessful() {
		String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		driver.get("http://www.saucedemo.com/");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("fake-password-123");
		driver.findElement(By.id("login-button")).click();
		String actualErrorMessage = driver.findElement(By.cssSelector(".login-box h3[data-test='error']")).getText();
		Assert.assertEquals("Login error message not matched", expectedErrorMessage, actualErrorMessage);
	}

}
