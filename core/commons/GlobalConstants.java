package commons;

public class GlobalConstants {
	//system information
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	
	// application information user
	public static final String DEV_USER_URL = "http://dev.techpanda.org/";
	public static final String STAGING_USER_URL = "http://staging.techpanda.org/";
	public static final String LIVE_USER_URL = "http://live.techpanda.org/";
	
	// application information admin
	public static final String DEV_ADMIN_URL = "http://dev.techpanda.org/index.php/backendlogin";
	public static final String STAGING_ADMIN_URL = "http://staging.techpanda.org/index.php/backendlogin";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
	
	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	
	// wait information
	public static final long SHORT_TIMEOUT = 10;
	public static final long LONG_TIMEOUT = 30;
	
	// download/upload file
	public static final String UPLOAD_PATH = PROJECT_PATH + "\\uploadFile\\";
	public static final String DOWNLOAD_PATH = PROJECT_PATH + "\\downloadFiles";
	
	// retry case failed
	public static final int RETRY_CASE_FAILED_NUMBER = 2;
	
	// browser logs
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "\\browserLogs";
	
	// HTML report folder
	public static final String REPORT_PATH = PROJECT_PATH + "\\htmlReportNG";
	
	public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
	
	public static final String JAVA_VERSION = System.getProperty("java.version");
}
