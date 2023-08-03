package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;

public class SearchTermPageObject extends FooterContainerPageObject{
	public SearchTermPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	WebDriver driver;
	
}
