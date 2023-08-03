package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyOrderPageObject extends SidebarMyAccountPageObject{
	public MyOrderPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	WebDriver driver;
	
}
