package commons;

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	

	private WebDriver driver;
	protected final Log log;
	public  BaseTest() {

		log = LogFactory.getLog(getClass());
	}

	
	public WebDriver getBrowserDriver(String browserName, String urlValue) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			driver = WebDriverManager.chromedriver().create();
			break;
		case FIREFOX:
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case EDGE:
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Browser name is not valid");
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(LongTimeOut));
		driver.get(urlValue);
		return driver;
	}
	public WebDriver getDriver() {
		return this.driver;
	}
	private long LongTimeOut = 30;
}
