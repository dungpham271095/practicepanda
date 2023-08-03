package pageObject.jQuery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUis.jQuery.HomePageUI;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void enterToTextboxByHeaderName(String headerName ,String value) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, headerName);
		sendKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, value, headerName);
		pressKeyToElement(driver, HomePageUI.HEADER_TEXTBOX_BY_HEADER_NAME, Keys.ENTER, headerName);
	}
	public boolean isRowValuesDisplayed(String female, String countryName, String maleValue, String totalValue) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.ROW_VALUES, female,countryName,maleValue,totalValue);
		return isElementDisplayed(driver, HomePageUI.ROW_VALUES, female,countryName,maleValue,totalValue);
	
	}
	public void clickToACtionIconByCountryName(String countryName, String actionName) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionName);
		clickToElement(driver, HomePageUI.ACTION_BY_COUNTRY_NAME, countryName, actionName);
	}
	public void clickToPageByNumber(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementClickable(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		
	}
	public boolean isPageNumberActive(String pageNumber) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_NUMBER, pageNumber);
	}
	public void enterToTextBoxByHeaderNameAndRowNumber(String headerName, String rowNumber, String valueToInput) {
		// TODO Auto-generated method stub
		// lấy thứ tự cột
		int headerIndex = getListElementSize(driver, HomePageUI.HEADER_INDEX_BY_NAME, headerName) + 1;
		// khi đã biết được vị trí của cột và hàng giao index giữa hàng và cột là ô mình cần
		waitForElementVisible(driver, HomePageUI.CELL__TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(headerIndex));
		sendKeyToElement(driver, HomePageUI.CELL__TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX, valueToInput, rowNumber, String.valueOf(headerIndex));
		
	}
	public boolean isLoadSuccess(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}
	public void clickToStartButton() {
		// TODO Auto-generated method stub
		
		List<WebElement> startButtonElements = getListWebElement(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : startButtonElements) {
			waitForElementClickable(driver, startButton);
			startButton.click();
			sleepInSecond(2);
		}
		
	}
	public boolean isFileUpload(String fileName) {
		// TODO Auto-generated method stub
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED, fileName);
	}
}
