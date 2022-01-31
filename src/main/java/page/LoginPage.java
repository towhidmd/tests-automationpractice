package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helper.PageHelper;

public class LoginPage extends PageHelper {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void submitLogin(String username, String password) {

		setField(By.id("user-name"), username);

		setField(By.id("password"), password);

		driver.findElement(By.id("login-button")).click();
	}

}
