package pageUis.user;

public class UserLoginPageUI {
	public static final String EMAIL_TEXTBOX = "xpath=//input[@id='email']";
	public static final String PASS_TEXTBOX = "id=pass";
	public static final String LOGIN_BUTTON = "XPATH=//button[@id='send2']";
	public static final String EMAIL_EMPTY_ERROR_MESSAGE = "Xpath=//div[@id='advice-required-entry-email']";
	public static final String PASS_EMPTY_ERROR_MESSAGE = "xpath=//div[@id='advice-required-entry-pass']";
	public static final String EMAIL_INVALID_ERROR_MESSAGE = "xpath=//div[@id='advice-validate-email-email']";
	public static final String PASS_INVALID_ERROR_MESSAGE = "xpath=//div[@id='advice-validate-password-pass']";
	public static final String ACCOUNT_INVALID_ERROR_MESSAGE = "xpath=//li[@class='error-msg']//span";
}
