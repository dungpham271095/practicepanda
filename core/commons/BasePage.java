package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.AdminLoginPageObject;
import pageObject.navigation.FooterContainerPageObject;
import pageObject.navigation.PageGeneratorManagement;
import pageObject.user.UserHomePageObject;
import pageUis.admin.AdminBasePageUI;
import pageUis.admin.AdminManageCustomerPageUI;
import pageUis.jQuery.HomePageUI;

public class BasePage {
	public void openPageURL(WebDriver driver, String urlName) {
		driver.get(urlName);
	}
	public void getCurrentPageURL(WebDriver driver) {
		driver.getCurrentUrl();
	}
	public void getPageSourceCode(WebDriver driver) {
		driver.getPageSource();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public void refreshToPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public Alert waitForAlertPresent(WebDriver driver) {
		return (Alert) new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresent(driver).accept();
	}
	public void cancelAlert(WebDriver drive) {
		waitForAlertPresent(drive).dismiss();
	}
	public void sendKeyToAlert(WebDriver drive, String valueToSendKey) {
		waitForAlertPresent(drive).sendKeys(valueToSendKey);
	}
	public void switchToWindowByID(WebDriver driver, String currentWindowID) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String id : allWindowID) {
			if(!id.equals(currentWindowID)) {
				driver.switchTo().window(id);
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String id : allWindowID) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	public boolean closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String id : allWindowID) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if(driver.getWindowHandles().size() ==1)
			return true;
		else
			return false;
	}
	public String castRestParameter(String locator, String...values) {
		locator = String.format(locator,(Object[]) values);
		return locator;
	}
	
	//refactor
	//locator nay nhan tham so dau vao la id/class/name/xpath/css
	//quy uoc convention cua by locator: id=/ class=/ name=/ xpath=/ css=/
	// id =/ Id=/ ID =/ iD=/
	// ham nay chi su dung cho class nay nen co the de private
	private By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("id=") || locator.startsWith("ID=") || locator.startsWith("Id=")) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("class=") || locator.startsWith("Class=") || locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("name=") || locator.startsWith("Name=") || locator.startsWith("NAME=")) {
			by = By.className(locator.substring(5));
		} else if (locator.startsWith("css=") || locator.startsWith("Css=") || locator.startsWith("CSS=")) {
			by = By.cssSelector(locator.substring(4));
		} else if (locator.startsWith("xpath=") || locator.startsWith("Xpath=") || locator.startsWith("XPATH=")) {
			by = By.xpath(locator.substring(6));
		} else {
			throw new RuntimeException("Locator is not valid!");
		}
		return by;
	}
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, String locator, String...values) {
		getWebElement(driver, castRestParameter(locator, values)).click();
	}
	public void sendKeyToElement(WebDriver driver, String locator , String valueToSendKey, String...dynamicLocators) {
		getWebElement(driver, castRestParameter(locator, dynamicLocators)).clear();
		getWebElement(driver, castRestParameter(locator, dynamicLocators)).sendKeys(valueToSendKey);
	}
	public String getElementText(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, castRestParameter(locator, values)).getText();
	}
	public void selectItemDefaultDropdown(WebDriver driver, String locator, String expectedText) {
		Select select = new Select(getWebElement(driver, locator));
		select.selectByVisibleText(expectedText);
	}
	public void getFirstSelectItem(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		select.getFirstSelectedOption();
	}
	public boolean isMultipleDropdown(WebDriver driver, String locator) {
		Select select = new Select(getWebElement(driver, locator));
		return select.isMultiple();
	}
	public void selectItemCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expedtedText) {
		getWebElement(driver, childLocator).click();
		sleepInSecond(2);
		List<WebElement> items = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement item : items) {
			if(item.getText().trim().equals(expedtedText)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}
	public boolean isElementSelected(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, castRestParameter(locator, values)).isSelected();
	}
	public boolean isElementEnable(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, castRestParameter(locator, values)).isEnabled();
	}
	public boolean isElementDisplayed(WebDriver driver, String locator, String...values) {
		return getWebElement(driver, castRestParameter(locator, values)).isDisplayed();
	}
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		WebElement localElement = getWebElement(driver, locator);
		if(!localElement.isSelected()) {
			localElement.click();
		}
	}
	public void uncheckToCheckBox(WebDriver driver, String locator) {
		WebElement localElement = getWebElement(driver, locator);
		if(localElement.isSelected()) {
			localElement.click();
		}
	}
	public void waitForElementVisible(WebDriver driver, String locator, String...values) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(locator, values))));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String...values) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, values))));
	}
	
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementInvisible(WebDriver driver, String locator, String...values) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, values))));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String uploadFilePath = GlobalConstants.UPLOAD_PATH;

		// noi cac chuoi voi nhau
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + uploadFilePath + file + "\n";
		}
		// dam bao ki tu xuong dong khoang trang dau chuoi bi remove
		fullFileName = fullFileName.trim();
		getWebElement(driver, HomePageUI.UPLOAD_FILE).sendKeys(fullFileName);
		
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public FooterContainerPageObject getFooterContainerPage(WebDriver driver) {
		return new FooterContainerPageObject(driver);
	}
	public AdminLoginPageObject clickToLogOut(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, AdminBasePageUI.LOG_OUT_LINK);
		clickToElement(driver, AdminBasePageUI.LOG_OUT_LINK);
		return PageGeneratorManagement.getAdminLoginPage(driver);
	}
	public AdminLoginPageObject openAdminLoginPage(WebDriver driver, String adminURL) {
		openPageURL(driver, adminURL);
		return PageGeneratorManagement.getAdminLoginPage(driver);
	}
	public UserHomePageObject openUserHomePage(WebDriver driver, String userURL) {
		openPageURL(driver, userURL);
		return PageGeneratorManagement.getUserHomePage(driver);
	}
	public int getListElementSize(WebDriver driver, String locator, String...dynamicLocator) {
		return getListWebElement(driver, castRestParameter(locator, dynamicLocator)).size();
	}
	public int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	public void sleepInSecond1(long second) {
		try {
			Thread.sleep(second *1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String...dynamicLocators) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(locator, dynamicLocators)), key).perform();
	}
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
}
