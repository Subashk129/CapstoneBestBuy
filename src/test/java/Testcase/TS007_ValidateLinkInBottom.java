package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;

public class TS007_ValidateLinkInBottom extends BaseBB {

	@BeforeTest
	public void setup() {
		testName = "ts007_ValidateLinkInBottom";
		testDescription = "Link in HomePage bottom is broken or not";
		testCategory = "Regression";
		testAuthor = "subash";
	}
	
	@Test(priority=6)
	public void tc_05_validateLinkInBottomOfHomePage() throws Exception {
		LocationBB lp=new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp=new HomepageBB();
		String actTitle = hp.validateTermsAndCondtionLink();
		String expTitle="BestBuy.com Terms and Conditions";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of link in bottom of Home Page - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of link in bottom of Home Page - Fail", "Fail", testName);
		}
	}
	
}
