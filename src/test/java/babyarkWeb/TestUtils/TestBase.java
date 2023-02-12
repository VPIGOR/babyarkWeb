package babyarkWeb.TestUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import babbyarkWeb.Pages.CheckoutPaymentPage;
import babbyarkWeb.Pages.CheckoutShipingPage;
import babbyarkWeb.Pages.CheckoutsInformationPage;
import babbyarkWeb.Pages.CoockieBarPage;
import babbyarkWeb.Pages.Futer;
import babbyarkWeb.Pages.Header;
import babbyarkWeb.Pages.MainPage;
import babbyarkWeb.Pages.ShopPage;


public class TestBase {

	final String baseURL = "https://www.babyark.com";

	public WebDriver driver;
	public MainPage mainPage;
	public CoockieBarPage coockieBarPage;
	public Header header;
	public Futer futer;
	public ShopPage shopPage;
	
	public CheckoutPaymentPage checkoutPaymentPage;
	public CheckoutsInformationPage checkoutsInformationPage;
	public CheckoutShipingPage checkoutShipingPage;

	@BeforeMethod
	public void startApp() {
//	        ChromeOptions options = new ChromeOptions();
//	        options.addArguments("--lang=" + "en");
//	        driver = new ChromeDriver(options);
		driver = new ChromeDriver();

		mainPage = PageFactory.initElements(driver, MainPage.class);
		coockieBarPage = PageFactory.initElements(driver, CoockieBarPage.class);
		header = PageFactory.initElements(driver, Header.class);
		futer = PageFactory.initElements(driver, Futer.class);
		shopPage = PageFactory.initElements(driver, ShopPage.class);
		
		checkoutPaymentPage = PageFactory.initElements(driver, CheckoutPaymentPage.class);
		checkoutsInformationPage = PageFactory.initElements(driver, CheckoutsInformationPage.class);
		checkoutShipingPage = PageFactory.initElements(driver, CheckoutShipingPage.class);
		
		

//        driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		mainPage.waitPageIsLoad();

	}

	@AfterMethod
	public void finishApp() {
		driver.quit();
	}

}
