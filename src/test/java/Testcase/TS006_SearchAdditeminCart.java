package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.CartPageBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;
import PagesBB.ProductPageBB;

public class TS006_SearchAdditeminCart extends BaseBB {

	@BeforeTest
	public void setup() {

		testName = "ts006_SearchAdditeminCart";
		testDescription = "Search a Item in search box and add it in cart";
		testCategory = "Regression";
		testAuthor = "subash";
	}

	@Test(priority=7)
	public void tc_06_SearchAddItemInCart() throws Exception {
		LocationBB lp = new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp = new HomepageBB();
		hp.searchProduct("Mouse");
		ProductPageBB pp = new ProductPageBB();
		String prodTitleAtProductPage = pp.addLogitechMouse();
		CartPageBB cp = new CartPageBB();
		String prodTitleAtCartPage = cp.validateLogitechMouseInCart();
		softAssert(prodTitleAtProductPage, prodTitleAtCartPage);
		if (prodTitleAtProductPage.equals(prodTitleAtCartPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}
}
