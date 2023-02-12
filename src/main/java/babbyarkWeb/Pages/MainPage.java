package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class MainPage extends PageBase{
	private final String expectedMainPageTitle = "babyark™ - The New Standard of Car Seat Safety";

	public MainPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//span[normalize-space()='Explore safety']")
	WebElement exploreSafetyButton;
	@FindBy(css = "button[id='engineered-btn'] span[class='MuiButton-label']")
	WebElement buyButton1Slide;
	@FindBy(xpath = "//span[normalize-space()='Learn more']")
	WebElement learnMoreButton;
	@FindBy(xpath = "//span[normalize-space()='Get the app']")
	WebElement getAppButton;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained "
			+ "buynow buy-babyark-text-button bring-saftey MuiButton-containedPrimary']"
			+ "//span[@class='MuiButton-label'][normalize-space()='Buy babyark']")
	WebElement buybabyarkButton;
	
	
	
	
//	driver.findElement(By.xpath("//button[normalize-space()='Accept']")).click();
	
	public MainPage waitPageIsLoad() {
		waitUntilTitleIs(expectedMainPageTitle, 10);
		return this;
	}
	public String getExpectedTitle() {
		return expectedMainPageTitle;
	}
	
	
}


		


