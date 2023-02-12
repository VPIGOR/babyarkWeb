package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class CoockieBarPage extends PageBase {

	public CoockieBarPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//button[normalize-space()='Accept']")
	WebElement accept;
	@FindBy(xpath = "//button[normalize-space()='Decline']")
	WebElement decline;
	@FindBy(xpath = "//button[normalize-space()='Preferences']")
	WebElement preferenceButton;
	@FindBy(xpath = "//span[@class='t-preferencesLink']")
	WebElement preferenceLink;
	@FindBy(className = "t-CookiePolicyLink")
	WebElement cookiePolicy;
	
	public void acceptCookie() {
		accept.click();
	}
	public void declineCookie() {
		decline.click();
	}
}
