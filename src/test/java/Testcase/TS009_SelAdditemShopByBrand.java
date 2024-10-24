package Testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseBestBuy.BaseBB;
import PagesBB.CartPageBB;
import PagesBB.HomepageBB;
import PagesBB.LocationBB;
import PagesBB.ProductPageBB;

public class TS009_SelAdditemShopByBrand extends BaseBB {
	
	@BeforeTest
	public void setup() {

		testName = "ts009_selAddItemShopByBrand";
		testDescription = "Search a Item by Brands in Menu and add it in cart";
		testCategory = "Regression";
		testAuthor = "suabsh";
	}

	@Test(priority=9)
	public void ts009_selAddItemShopByBrand() throws Exception {
		LocationBB lp = new LocationBB();
		lp.deliveryAtUSA();
		HomepageBB hp = new HomepageBB();
		hp.selectLenovoBrand();
		ProductPageBB pp = new ProductPageBB();
		String lenovoThinkPadTitleAtProdPage = pp.addLenovoThinkPadInProdPage();
		hp.goToCartPage();
		CartPageBB cp = new CartPageBB();
		String lenovoThinkPadTitleAtCartPage = cp.validateLenovoThinkPadInCart();
		softAssert(lenovoThinkPadTitleAtCartPage, lenovoThinkPadTitleAtProdPage);
		if (lenovoThinkPadTitleAtCartPage.equals(lenovoThinkPadTitleAtProdPage)) {
			reportStep("Validating Product Title - Pass", "Pass", testName);
		} else {
			reportStep("Validating Product Title - Fail", "Fail", testName);
		}
	}

}
