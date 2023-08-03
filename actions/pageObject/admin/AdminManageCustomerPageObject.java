package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUis.admin.AdminManageCustomerPageUI;

public class AdminManageCustomerPageObject extends BasePage{
	WebDriver driver;
	public AdminManageCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void closeIncomingMessagePopup() {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, AdminManageCustomerPageUI.MESSAGE_POPUP);
		waitForElementClickable(driver, AdminManageCustomerPageUI.MESSAGE_POPUP_CLOSE);
		clickToElement(driver, AdminManageCustomerPageUI.MESSAGE_POPUP_CLOSE);
	}

}
