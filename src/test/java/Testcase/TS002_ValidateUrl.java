package Testcase;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.LocationBB;

public class TS002_ValidateUrl extends BaseBB{

	@BeforeTest
	public void setup() {
		testName = "ts002_validateUrlIsNotBroken";
		testDescription = "Given URL Link is broken or not";
		testCategory = "Regression";
		testAuthor = "suabsh";
	}
	

	@Test(priority=2)
	public void tc_02_validateUrlIsNotBroken() throws Exception {
		LocationBB lp=new LocationBB();
		if (lp.urlResponseCode()==200) {
			reportStep("Validating Best Buy page URL is broken or not - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy page URL is broken or not - Fail", "Fail", testName);
		}
		AssertJUnit.assertTrue(lp.urlResponseCode()==200);
	}
}
