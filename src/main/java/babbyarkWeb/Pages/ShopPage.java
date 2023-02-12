package babbyarkWeb.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class ShopPage extends PageBase {

	public ShopPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "button[class='product-form__submit button button--full-width button--secondary gPreorderBtn']")
	WebElement payDepositMainButton;
	@FindBy(xpath = "(//span[contains(text(),'Pay $50 Deposit')])[2]")
	WebElement payDepositFromPopUp;
	@FindBy(xpath = "(//div[@class='summary__title'])[1]")
	WebElement warantyDropDown;
	@FindBy(css = "a[title='#']")
	WebElement learnMoreAboutWaranty;
	@FindBy(xpath = "//div[@class='grid__item product__media-wrapper hidem']//div[@class='max-width']//div[@class='product']//div//"
			+ "div[@class='under-product-icon']//div[@class='row']//div[@class='col-3 col-md-3 col-lg-3']//div//a[@href=\"javascript:"
			+ "jQuery('#forever-modal').modal('show')\"][contains(text(),'ForeverSafe™')]")
	WebElement foreverSafeButton;
	@FindBy(xpath = "//a[@href=\"javascript:jQuery"
			+ "('#forever-modal').modal('hide')\"]//*[name()='svg']")
	WebElement foreverSafeCloseFrameButton;
	@FindBy(xpath = " //div[@id='forever-modal']//div[@class='modal-content']")
	WebElement ForevereSafeAlert;
	@FindBy(className = "product__title")
	WebElement productTitle;
	
	public String getProductTitle() {
		return productTitle.getText();
	}

	public ShopPage waitPageIsLoaded() {
		waitUntilElementIsClickabl(payDepositMainButton, 1);
		return this;
	}
	
	public ShopPage openForevereSafeAlert() {	
		scrolByPixels(900);
	    waitUntilElementIsClickabl(foreverSafeButton, 1);
		foreverSafeButton.click();
		return this;
	}
	public void closeForevereSafeAlert() {	
		foreverSafeCloseFrameButton.click();
	}
	public boolean ifForevereSafeAlertDisable() {
					return ForevereSafeAlert.isDisplayed();	
	}
	
	public ShopPage goToCheckoutPageByClickMainButton() {
		payDepositMainButton.click();
		return this;
	}
	public void goToCheckoutPageByClickPopUp() {
		payDepositFromPopUp.click();
	}

	public ShopPage choiceColor(int colorNum) {
		driver.findElement(By.cssSelector("label[for='template--14426536738887__main-1-" + colorNum + "'])")).click();
		return this;
	}

	public ShopPage choiseSeatFoto(int photoNum) {
		driver.findElement(By.xpath("//label[@for='slider-" + photoNum + "']")).click();
		return this;
	}
}
