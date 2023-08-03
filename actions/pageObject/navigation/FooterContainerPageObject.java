package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AboutUsPageObject;
import pageObject.user.FooterContainerPageUI;
import pageObject.user.MyAccountPageObject;
import pageObject.user.SearchTermPageObject;

public class FooterContainerPageObject extends BasePage{
	WebDriver driver;
	public FooterContainerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public AboutUsPageObject openAboutUsPage() {
		waitForElementClickable(driver, FooterContainerPageUI.ABOUT_US_LINK);
		clickToElement(driver, FooterContainerPageUI.ABOUT_US_LINK);
		return PageGeneratorManagement.getAboutUsPage(driver);
	}
	public SearchTermPageObject openSeachTermPage() {
		waitForElementClickable(driver, FooterContainerPageUI.SEARCH_TERM);
		clickToElement(driver, FooterContainerPageUI.SEARCH_TERM);
		return PageGeneratorManagement.getSearchTermPage(driver);
	}
	public MyAccountPageObject openMyAccountPage() {
		waitForElementClickable(driver, FooterContainerPageUI.MY_ACCOUNT);
		clickToElement(driver, FooterContainerPageUI.MY_ACCOUNT);
		return PageGeneratorManagement.getMyAccountPage(driver);
	}
}
