package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHelper {
	
	public WebDriver driver;
	
	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setField(By by, String text) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}

}
