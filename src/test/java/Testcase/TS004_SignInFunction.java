package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;
import PagesBB.SignInPageBB;

public class TS004_SignInFunction extends BaseBB {

	@BeforeTest
	public void setup() {
		testName = "ts004_SignInFunctionality";
		testDescription = "Sign-In Functionality";
		testCategory = "Regression";
		testAuthor = "Subash";
		sheetName="SignInTest";
	}
	
	@Test(dataProvider="getFromExcel", priority=4)
	public void tc_03_SignInFunctionality(String email,String password,String xpath,String expMsg) throws Exception {
		LocationBB lp=new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp=new HomepageBB();
		hp.goToSignIn();
		SignInPageBB sp=new SignInPageBB();
		String actMsg = sp.signInFunctionality(email,password,xpath);
		softAssert(actMsg, expMsg);
		if (actMsg.equals(expMsg)) {
			reportStep("Validating Sign-In Functionality - Pass", "Pass", testName);
		} else {
			reportStep("Validating Sign-In Functionality - Fail", "Fail", testName);
		}
	}
}
