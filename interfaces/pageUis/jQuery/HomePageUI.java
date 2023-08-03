package pageUis.jQuery;

public class HomePageUI {
	public static final String HEADER_TEXTBOX_BY_HEADER_NAME = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_VALUES = "xpath=//td[@data-key = 'females' and text()='%s']/following-sibling::td[@data-key = 'country' and text()='%s']/following-sibling::td[@data-key = 'males' and text()='%s']/following-sibling::td[@data-key = 'total' and text()='%s']";
	public static final String ACTION_BY_COUNTRY_NAME = "xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td/button[contains(@class,'%s')]";
	public static final String PAGE_NUMBER = "xpath=//a[text()='%s']";
	public static final String HEADER_NAME = "xpath=//a[text()='%s']";
	public static final String HEADER_INDEX_BY_NAME = "xpath=//th[text()='%s']/preceding-sibling::th";
	public static final String CELL__TEXTBOX_BY_HEADER_INDEX_AND_ROW_INDEX = "xpath=//tr[%s]/td[%s]/input";
	public static final String UPLOAD_FILE = "xpath=//input[@type='file']";
	public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
	public static final String START_BUTTON = "xpath=//table//button[contains(@class,'start')]";
	public static final String FILE_NAME_UPLOADED = "xpath=//p[@class='name']/a[@title='%s']";
}
 