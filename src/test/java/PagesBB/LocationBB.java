package PagesBB;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseBestBuy.BaseBB;

public class LocationBB extends BaseBB {

	@FindBy(className="us-link")
	WebElement countryUSA;
	
	@FindBy(className="canada-link")
	WebElement countryCanada;
	
	public LocationBB() {
		PageFactory.initElements(driver, this);
	}
	
	public void deliveryAtUSA() {
		clickOn(countryUSA);
	}
	
	public void deliveryAtCanada() {
		clickOn(countryCanada);
	}
	
	public String bestBuyPageTitle() throws Exception {
		return getPageTitle();
	}
	
	public int urlResponseCode() throws Exception {
		return getResponseCode(readProperty("url"));
	}
	
}
