package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManagement;
import pageUis.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterUserName(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AdminLoginPageUI.USER_NAME);
		sendKeyToElement(driver, AdminLoginPageUI.USER_NAME, string);
	}
	public void enterPass(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AdminLoginPageUI.PASS);
		sendKeyToElement(driver, AdminLoginPageUI.PASS, string);
	}
	public AdminManageCustomerPageObject clickToLoginButton() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagement.getAdminManageCutomerPage(driver);
	}
}
