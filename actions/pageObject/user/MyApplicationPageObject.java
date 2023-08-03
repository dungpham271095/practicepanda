package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyApplicationPageObject extends SidebarMyAccountPageObject{
	public MyApplicationPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	WebDriver driver;
	
}
