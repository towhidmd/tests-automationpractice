package helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHelper {

	public WebDriver driver;

	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void setField(By by, String text) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}

	public void clickOnElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.DAFAULT_TIMEOUT_SECOND_FIFTEEN));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public String getText(By by) {
		return driver.findElement(by).getText().trim();
	}

	public List<String> getListOfString(By by) {
		List<String> strings = new ArrayList<String>();

		List<WebElement> elements = driver.findElements(by);

		for (WebElement webElement : elements) {
			strings.add(webElement.getText());
		}
		return strings;

	}
}