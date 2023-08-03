package javaBasic;

public class Dynamic_Locator {
	public static final String ACCOUNT_INFORMATION = "xpath=//a[text()='Account Information']";
	public static final String MY_PRODUCT_REVIEWS = "xpath=//a[text()='My Product Reviews']";
	public static final String MY_APPLICATIONS = "xpath=//a[text()='My Applications']";
	public static final String MY_ORDER = "xpath=//a[text()='My Orders']";
	// 1 tham so dong page name
	public static final String DYNAMIC_SIDBAR_LINK = "xpath=//a[text()='%s']";
	// 2 tham so dong
	public static void main(String[] args) {
		clickToElement(ACCOUNT_INFORMATION);
		clickToElement(MY_APPLICATIONS);
		clickToElement(MY_ORDER);
		clickToElement(DYNAMIC_SIDBAR_LINK, "Account Information");
		clickToElement(DYNAMIC_SIDBAR_LINK, "My Applications");
		clickToElement(DYNAMIC_SIDBAR_LINK, "My Orders");
		// parse 1 gia tri tu ngoai vao
	}

	public static void clickToElement(String locator, String... values) {
		locator = String.format(locator, (Object[])values);
		// locator = xpath=//a[text()='%s']
		// lay pagename thay vao vi tri %s , 'Account Information'
		// locator =
		System.out.println(locator);
	}
}
