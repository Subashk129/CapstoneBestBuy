package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.LocationBB;

public class TS001_navigatingtoBB extends BaseBB {
	@BeforeTest
	public void setup() {
		testName = "ts001_navgatingToBestBestApp";
		testDescription = "Navigating to the Best Buy e-commerce website";
		testCategory = "Regression";
		testAuthor = "subash";
	}
	
	@Test(priority=1)
	public void tc_01_navgatingToBestBestApp() throws Exception {
		LocationBB lp=new LocationBB();
		String actTitle = lp.bestBuyPageTitle();
		String expTitle="Best Buy International: Select your Country - Best Buy";
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating Best Buy Page Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Best Buy Page Title - Fail", "Fail", testName);
		}
	}	
	
}
