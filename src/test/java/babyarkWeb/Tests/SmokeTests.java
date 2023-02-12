package babyarkWeb.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import babyarkWeb.TestUtils.TestBase;

public class SmokeTests extends TestBase {

	@Test()
	public void CheckHeaderOnmainPage() {
		header.checkIfHeaderLoaded();
	}

	@Test()
	public void shopPageTest() {
		// coockieBarPage.acceptCookie();
		header.waitLoadHeader();
		header.goToShopPage();
		Assert.assertEquals(shopPage.getProductTitle(), "The Convertible Car Seat");
	}

	@Test()
	public void foreverSafeFrameTest() {
		header.waitLoadHeader().goToShopPage();
		shopPage.waitPageIsLoaded().openForevereSafeAlert();
		Boolean alert = shopPage.ifForevereSafeAlertDisable();
		Assert.assertEquals(alert.toString(), "false");
		shopPage.closeForevereSafeAlert();
	}

	@Test(groups = "smoke")
	public void purchaseNotValidCard() {
		header.waitLoadHeader().goToShopPage();
		shopPage.waitPageIsLoaded().goToCheckoutPageByClickMainButton();
		checkoutsInformationPage.waitPageLoaded().scrolPixels(100).enterEmail("controlqa22@gmail.com")
				.enterLasttName("Test").enterAddress("Fort Lauderdale-Hollywood International Airport (FLL)")
				.enterCity("Fort Lauderdale").dropdownSelect("Florida").enterZipCode("33315").clickContinueButton();
		checkoutShipingPage.waitPageLoaded().clickContinueButton();
		checkoutPaymentPage.waitPageLoaded().clickPayButton();

		String alert = checkoutPaymentPage.getErrorAlertText();
		Assert.assertEquals(alert, "Your payment details couldn’t be verified. Check your card details and try again.");

	}
}
