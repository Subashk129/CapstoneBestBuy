package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.CartPageBB;
import PagesBB.CheckOutPageBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;
import PagesBB.ProductPageBB;

public class TS010_ChekOutPagefilling extends BaseBB {
	

	@BeforeTest
	public void setup() {
		testName = "ts010_CheckOutPageFilling";
		testDescription = "Navigating to the checkout page and filling the form with dummy payment information";
		testCategory = "Regression";
		testAuthor = "subash";
	}
	
	@Test(priority=10)
	public void tc_09_CheckOutPageFilling() throws Exception {
		LocationBB lp=new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp=new HomepageBB();
		hp.searchProduct("Mouse");
		Thread.sleep(8);
		ProductPageBB pp=new ProductPageBB();;		
		pp.addLogitechMouse();
		Thread.sleep(3);
		CartPageBB cp=new CartPageBB();//contactInfoAtCheckOut("testerat1229@gmail.com", "9876543210");
		cp.goToCheckOutPage();
		CheckOutPageBB cop=new CheckOutPageBB();
		cop.contactInfoAtCheckOut("testerat1229@gmail.com", "9876543210");		
		
	}

}
