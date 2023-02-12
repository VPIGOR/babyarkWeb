package babbyarkWeb.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import babyarkWeb.PageUtils.PageBase;

public class CheckoutsInformationPage extends PageBase {

	public CheckoutsInformationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(className = "JXMCh")
	WebElement logo;
	@FindBy(id = "email")
	WebElement emailField;
	@FindBy(id = "marketing_opt_in")
	WebElement emailMeCheckBox;
	@FindBy(id = "TextField0")
	WebElement firstNameField;
	@FindBy(id = "TextField1")
	WebElement lastNameField;
	@FindBy(id = "address1")
	WebElement addressField;
	@FindBy(id = "TextField3")
	WebElement apartmentField;
	@FindBy(id = "TextField4")
	WebElement cityField;
	@FindBy(id = "Select1")
	WebElement stateDropDownList;
	@FindBy(id = "TextField5")
	WebElement zipCodeField;
	@FindBy(css = "button[class='_2pOWh uWTUp _1Kqoj _2tVwl _276ql _10zXD sd4hU _1E46a']")
	WebElement continueButton;
	@FindBy(className = "._19gi7yt0._19gi7ytm._1fragem1w._19gi7yt2._19gi7yt9.notranslate")
	WebElement totalSum;
	@FindBy(css = "h2[class='n8k95w1 _1fragemcx n8k95w4']")
	WebElement title;

	public String getTitle() {
		return title.getText();
	}
	
	
	public CheckoutsInformationPage scrolPixels(int pixel) {
		scrolByPixels(pixel);
		return this;
	}

	public CheckoutsInformationPage clickContinueButton() {
		continueButton.click();
		return this;
	}

	public CheckoutsInformationPage waitPageLoaded() {
		waitUntilElementIsVisable(title, 1);
		return this;
	}

	public CheckoutsInformationPage enterEmail(String email) {
		emailField.click();
		emailField.sendKeys(email);
		// fillField(emailField, email);
		return this;
	}

	public CheckoutsInformationPage enterFirstName(String fName) {
		fillField(firstNameField, fName);
		return this;
	}

	public CheckoutsInformationPage enterLasttName(String lName) {
		fillField(lastNameField, lName);
		return this;
	}

	public CheckoutsInformationPage enterAddress(String address) {
		fillField(addressField, address);
		return this;
	}

	public CheckoutsInformationPage enterApartment(String apartment) {
		fillField(apartmentField, apartment);
		return this;
	}

	public CheckoutsInformationPage enterCity(String city) {
		fillField(cityField, city);
		return this;
	}

	public CheckoutsInformationPage dropdownSelect(String state) {
		dropdownSelect(stateDropDownList, state);
		return this;
	}

	public CheckoutsInformationPage enterZipCode(String zip) {
		fillField(zipCodeField, zip);
		return this;
	}

	public double getTotalSum() {
		String totalS = totalSum.getText().substring(1);
		double total = Double.parseDouble(totalS);
		return total;
	}

}
