package helper;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestHelper {
	
	public WebDriver driver;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Before
	public void setupDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DAFAULT_TIMEOUT_SECOND_FIFTEEN));
		
		driver.get("");
		
		
	}
	
	@After
	public void terardownDriver() {
		driver.quit();
	}
	
	public void verifyEquals(String message, String expected, String actual) {
		try {
			Assert.assertEquals(message, expected, actual);
		} catch (Error e) {
			error.addError(e);
		}
	}
 public void verifyTrue(String message, boolean isTrue) {
	 try {
		 assertTrue(message, isTrue);
	 } catch(AssertionError e) {
		 error.addError(e);
	 
	 }
 }

}
