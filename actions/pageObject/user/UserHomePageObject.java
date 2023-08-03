package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManagement;
import pageUis.user.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	WebDriver driver;
	public UserHomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public UserLoginPageObject openLoginPage() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT);
		return PageGeneratorManagement.getUserLoginPage(driver);
	}
	

}
