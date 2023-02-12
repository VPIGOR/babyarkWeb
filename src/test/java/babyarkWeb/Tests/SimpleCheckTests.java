package babyarkWeb.Tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import babyarkWeb.TestUtils.TestBase;

public class SimpleCheckTests extends TestBase {

	@Test()
	public void foreverSafeFrameTest() {
		header.waitLoadHeader().goToShopPage();
		shopPage.waitPageIsLoaded().openForevereSafeAlert();
		Boolean alert = shopPage.ifForevereSafeAlertDisable();
		Assert.assertEquals(alert.toString(), "false");
		shopPage.closeForevereSafeAlert();
	}

}
