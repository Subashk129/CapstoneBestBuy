package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.CreateAccpage;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;

public class TS003_CreateAccount extends BaseBB {

	@BeforeTest
	public void setup() {
		testName = "ts003_validateCreatAccountFunctionality";
		testDescription = "CreatAccount Functionality";
		testCategory = "Regression";
		testAuthor = "subash";
		sheetName="SignInTest";
	}
	
	@Test(dataProvider="getFromExcel", priority=3)
	public void tc_03_validateCreatAccountFunctionality(String fname, String lname, String emailId,
			String pass, String repass, String mob, String xpathText, String expMsg) throws Exception {
		LocationBB lp=new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp=new HomepageBB();
		hp.goToCreatAccount();
		CreateAccpage ca=new CreateAccpage();
		String actMsg = ca.creatAccountFunctionality(fname, lname, emailId, pass, repass, mob, xpathText);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating CreatAccount Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating CreatAccount Functionality - Fail", "Fail", testName);
		}
	}
	
}
