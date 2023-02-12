package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class CheckoutPaymentPage extends PageBase {

	public CheckoutPaymentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button[class='_2pOWh uWTUp _1Kqoj _2tVwl _276ql _10zXD sd4hU _1E46a']")
	WebElement payButton;
	@FindBy(css = "div[role='alert']")
	WebElement errorPaymentAlert;
	@FindBy(id = "primary-header")
	WebElement title;
	
	public CheckoutPaymentPage waitPageLoaded() {
		waitUntilElementIsVisable(title, 6);
		return this;
	}
	
	public CheckoutPaymentPage clickPayButton() {
		payButton.click();	
		return this;
	}
	
	public String getErrorAlertText() {
		return errorPaymentAlert.getText();
	}
	
	
}
