package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGeneratorManagement;
import pageUis.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
	WebDriver driver;
	public UserLoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public void sendKeyToEmailTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, string);
	}
	public void sendKeyToPassTextbox(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.PASS_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASS_TEXTBOX, string);
	}
	public MydashboardPageObject clickToLogin() {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManagement.getMydashboardPagePage(driver);
	}
	public boolean getEmptyEmailErrorMessage(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_EMPTY_ERROR_MESSAGE);
		String actualResult = getElementText(driver, UserLoginPageUI.EMAIL_EMPTY_ERROR_MESSAGE);
		return actualResult.contains(string);
	}
	public boolean getEmptyPassErrorMessage(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
		String actualResult = getElementText(driver, UserLoginPageUI.PASS_EMPTY_ERROR_MESSAGE);
		return actualResult.contains(string);
	}
	public boolean getInvalidEmailErrorMessage(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		String actualResult = getElementText(driver, UserLoginPageUI.EMAIL_INVALID_ERROR_MESSAGE);
		return actualResult.contains(string);
	}
	public boolean getInvalidPassErrorMessage(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.PASS_INVALID_ERROR_MESSAGE);
		String actualResult = getElementText(driver, UserLoginPageUI.PASS_INVALID_ERROR_MESSAGE);
		return actualResult.contains(string);
	}
	public boolean getInvalidAccountErrorMessage(String string) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, UserLoginPageUI.ACCOUNT_INVALID_ERROR_MESSAGE);
		String actualResult = getElementText(driver, UserLoginPageUI.ACCOUNT_INVALID_ERROR_MESSAGE);
		return actualResult.contains(string);
	}

}
