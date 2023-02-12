package babbyarkWeb.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import babyarkWeb.PageUtils.PageBase;

public class Header extends PageBase {

	public Header(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//img[@alt='Babyark']")
	WebElement babyarkLogo;
	@FindBy(css = ".MuiButtonBase-root.MuiButton-root.MuiButton-contained.small.buynow.MuiButton-containedSecondary")
	WebElement buyButtonMain;
	@FindBy(xpath = "//a[contains(text(),'Safety')]")
	WebElement safetyButton;
	@FindBy(xpath = "//a[@href='/install']")
	WebElement installButton;
	@FindBy(xpath = "//a[@id='cart-icon-bubble']//*[name()='svg']")
	WebElement cartButton;
	

	public Header makeHeaderVisible() {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.PAGE_UP).perform();
		return this;
	}

	public Header goToShopPage() {
		buyButtonMain.click();
		return this;
	}

	public Header goToSafetyPage() {
		buyButtonMain.click();
		return this;
	}

	public Header goToInstallPage() {
		buyButtonMain.click();
		return this;
	}

	public Header waitLoadHeader() {
		waitUntilElementIsClickabl(buyButtonMain, 7);
		return this;
	}

	public Header checkIfHeaderLoaded() {
		String logoText1 = buyButtonMain.getText();
		Assert.assertEquals(logoText1, "Buy");
		return this;
	}

}
