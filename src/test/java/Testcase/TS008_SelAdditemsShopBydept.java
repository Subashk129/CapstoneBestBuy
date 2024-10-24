package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.CartPageBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;
import PagesBB.ProductPageBB;

public class TS008_SelAdditemsShopBydept extends BaseBB{

	@BeforeTest
	public void setup() {

		testName = "ts008_SelAdditemsShopBydept";
		testDescription = "Search a Item by Department in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "subash";
	}

	@Test(priority=8)
	public void tc_07_selAddItemShopByDeptMenu() throws Exception {
		LocationBB lp = new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp = new HomepageBB();
		hp.selectTvMenuInHomePage();
		ProductPageBB pp = new ProductPageBB();
		String sony75TitleAtProdPage = pp.addSony75InchTVInProdPageM2();
		hp.goToCartPage();
		CartPageBB cp = new CartPageBB();
		String sony75TitleAtCartPage = cp.validateSonyTvInCart();
		softAssert(sony75TitleAtCartPage, sony75TitleAtProdPage);
		if (sony75TitleAtCartPage.equals(sony75TitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
