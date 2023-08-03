package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AccountInfomationPageObject;
import pageObject.user.MyApplicationPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewsPageObject;
import pageUis.user.SidebarMyAccountPageUI;

public class SidebarMyAccountPageObject extends BasePage{
	WebDriver driver;
	public SidebarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AccountInfomationPageObject openAccountInformationPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.ACCOUNT_INFORMATION);
		clickToElement(driver, SidebarMyAccountPageUI.ACCOUNT_INFORMATION);
		return PageGeneratorManagement.getAccountInformationPage(driver);
	}
	public MyOrderPageObject openMyOrderPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.MY_ORDER);
		clickToElement(driver, SidebarMyAccountPageUI.MY_ORDER);
		return PageGeneratorManagement.getMyOrderPage(driver);
	}
	public MyApplicationPageObject openMyApplicationPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.MY_APPLICATIONS);
		clickToElement(driver, SidebarMyAccountPageUI.MY_APPLICATIONS);
		return PageGeneratorManagement.getMyApplicationPage(driver);
	}
	public MyProductReviewsPageObject openMyProductReviewsPage() {
		waitForElementClickable(driver, SidebarMyAccountPageUI.MY_PRODUCT_REVIEWS);
		clickToElement(driver, SidebarMyAccountPageUI.MY_PRODUCT_REVIEWS);
		return PageGeneratorManagement.getMyProductReviewsPagePage(driver);
	}
	public void openSideBarLinkByPageName(String pageName) {
		waitForElementClickable(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_SIDEBAR_LINK, pageName);
	}
	
}
