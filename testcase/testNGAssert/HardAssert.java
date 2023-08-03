package testNGAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssert {
	
	SoftAssert softAssert = new SoftAssert();
	@Test
	public void TC_01() {
		String name = "Automation FC";
		
		verifyEqual(name, "automation FC");
		
		name = "API Testing";
		
		verifyEqual(name, "Ui testing");
		
	
	
	}
	public boolean verifyEqual(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			// TODO: handle exception
			pass = false;
		}
		return pass;
	}
	public boolean verifyTrue(boolean condition) {
		condition = true;
		try {
			Assert.assertTrue(condition);;
		} catch (Throwable e) {
			// TODO: handle exception
			condition = false;
		}
		return condition;
	}
	public boolean verifyFalse(boolean condition) {
		condition = true;
		try {
			Assert.assertFalse(condition);;
		} catch (Throwable e) {
			// TODO: handle exception
			condition = false;
		}
		return condition;
	}
}
