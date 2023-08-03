package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterContainerPageObject;

public class MyAccountPageObject extends FooterContainerPageObject{
	WebDriver driver; 
	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
}
