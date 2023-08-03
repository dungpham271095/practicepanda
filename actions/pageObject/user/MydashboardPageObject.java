package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;
import pageUis.user.MydashboardUI;

public class MydashboardPageObject extends SidebarMyAccountPageObject{
	WebDriver driver;
	public MydashboardPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public boolean getContactInformation(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MydashboardUI.CONTACT_INFORMATION);
		String actualResult = getElementText(driver, MydashboardUI.CONTACT_INFORMATION);
		return actualResult.contains(string);
	}
	public boolean getUpdateInformation(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, MydashboardUI.UPDATE_MESSAGE);
		String actualResult = getElementText(driver, MydashboardUI.UPDATE_MESSAGE);
		return actualResult.contains(string);
	}


}
