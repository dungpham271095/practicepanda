package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyProductReviewsPageObject extends SidebarMyAccountPageObject{
	public MyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	WebDriver driver;
	
}