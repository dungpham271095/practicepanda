package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.PageGeneratorManagement;
import pageObject.navigation.SidebarMyAccountPageObject;
import pageUis.user.AccountInformationUI;

public class AccountInfomationPageObject extends SidebarMyAccountPageObject{
	public AccountInfomationPageObject(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	WebDriver driver;

	public void sendKeyToFirstName(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AccountInformationUI.FIRST_NAME);
		sendKeyToElement(driver, AccountInformationUI.FIRST_NAME, string);
	}

	public void sendKeyToMiddleName(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AccountInformationUI.MIDDLE_NAME);
		sendKeyToElement(driver, AccountInformationUI.MIDDLE_NAME, string);
	}

	public void sendKeyToLastName(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AccountInformationUI.LAST_NAME);
		sendKeyToElement(driver, AccountInformationUI.LAST_NAME, string);
	}

	public void sendKeyToCurrentPass(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AccountInformationUI.CURRENT_PASS);
		sendKeyToElement(driver, AccountInformationUI.CURRENT_PASS, string);
	}

	public MydashboardPageObject clickSaveButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AccountInformationUI.SAVE_BUTTON);
		clickToElement(driver, AccountInformationUI.SAVE_BUTTON);
		return PageGeneratorManagement.getMydashboardPagePage(driver);
	}
	
}
