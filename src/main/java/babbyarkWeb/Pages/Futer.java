package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class Futer extends PageBase {

	public Futer(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "#email_53678229")
	WebElement emailField;
	@FindBy(xpath = "(//img[@alt='facebook'])[1]")
	WebElement facebookLink;
	@FindBy(xpath = "(//img[@alt='instagram'])[1]")
	WebElement instagramLink;
	@FindBy(xpath = "//a[normalize-space()='App Store']")
	WebElement appStore;
	@FindBy(xpath = "//a[normalize-space()='Google Play']")
	WebElement googlePlay;
	@FindBy(css = "a[href='shipping']")
	WebElement shipingAndReturn;
	@FindBy(css = "a[href='register']")
	WebElement register;
	@FindBy(css = "a[href='about']")
	WebElement aboutUs;
	@FindBy(css = "a[href='contact-us']")
	WebElement contactUs;
	@FindBy(css = "a[href='faq']")
	WebElement fQA;
	@FindBy(css = "a[href='terms']")
	WebElement terms;
	@FindBy(css = "a[href='privacy']")
	WebElement privacy;
	@FindBy(css = "a[href='warranty']")
	WebElement waranty;
}
