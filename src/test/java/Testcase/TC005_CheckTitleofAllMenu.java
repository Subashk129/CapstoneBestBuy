package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;

public class TC005_CheckTitleofAllMenu extends BaseBB{


	@BeforeTest
	public void setup() {
		testName = "tc005_CheckTitleofAllMenu";
		testDescription = "Check the different menu titles";
		testCategory = "Regression";
		testAuthor = "subash";
		sheetName="menudata";
	}
	
	@Test(dataProvider="getFromExcel", priority=5)
	public void tc_04_CheckTitleOfAllMenu(String menuName,String expTitle) throws Exception {
		LocationBB lp=new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp=new HomepageBB();
		String actTitle = hp.menuValidation(menuName);
		softAssert(actTitle, expTitle);
		if (actTitle.equals(expTitle)) {
			reportStep("Validating the Title of different Menu - Pass", "Pass", testName);
		} else {
			reportStep("Validating the Title of different Menu - Fail", "Fail", testName);
		}
	}
}
