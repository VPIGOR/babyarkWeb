package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class CheckoutShipingPage extends PageBase{

	public CheckoutShipingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "button[class='_2pOWh uWTUp _1Kqoj _2tVwl _276ql _10zXD sd4hU _1E46a']")
	WebElement continueButton;
	@FindBy(className = "._2pOWh._1omM3._10zXD.sd4hU")
	WebElement returnButton;
	@FindBy(className = "._19gi7yt0._19gi7ytm._1fragem1w._19gi7yt2._19gi7yt9.notranslate")
	WebElement totalSum;
	@FindBy(id = "primary-header")
	WebElement title;
	
	
	public CheckoutShipingPage clickContinueButton() {
		continueButton.click();
		return this;
	}
	
	public CheckoutShipingPage waitPageLoaded() {
		waitUntilElementIsVisable(title, 5);
		return this;
	}
	
	public String getTitleText() {
		return title.getText();
	}
	
	public double getTotalSum() {
		String totalS = totalSum.getText().substring(1);
		double total = Double.parseDouble(totalS);
		return total;
	}

	

}
