package babyarkWeb.PageUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PageBase {

	protected WebDriver driver;

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}
	
	
	protected void scrolUntilElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	
	protected void scrolTolElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		
	}
	
	
	//example to scroll down 1000, up -1000
	protected void scrolByPixels(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+pixel+")");
		
	}
	
	

	public String takeScrenshotAndReturnFilePath(String testCaseName) throws IOException {

		// take screenshot
		final File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// save screenshot in folder
		final String destinationFile = "/Users/igorvainman/eclipse-workspace/babyarkWeb/reports/" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));

		// send path to listener for extentReport
		return destinationFile;
	}

	protected PageBase waitUntilWindowIsOpened(int numOfWindows, int time) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(time))
					.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	protected PageBase implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return this;
	}

	protected PageBase waitUntilElementIsClickabl(WebElement element, int time) {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	protected PageBase waitUntilElementIsVisable(WebElement element, int time) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	protected String getPagTitle() {
		return driver.getTitle();
	}

	protected void waitUntilTitleIs(String str, int time) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.titleIs(str));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected PageBase fillField(WebElement element, String value) {
	
		element.clear();
		element.click();
		element.sendKeys(value);
		return this;
	}
	
	//select from dropdown list by name
	public PageBase  dropdownSelect(WebElement element, String option){    
        Select select = new Select(element);
        select.selectByVisibleText(option);        
   return this;
    }

	protected PageBase waiterWithThread(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	protected void openNewTab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
	}

	protected List<String> handlesTabList() {
		return new ArrayList<>(driver.getWindowHandles());

	}

	public PageBase goToTabByName(String currentTabName) {
		driver.switchTo().window(currentTabName);
		return this;
	}

	protected PageBase closeCurrentWindow() {
		driver.close();
		return this;
	}

	protected String generateRandomMail() {
		return "name" + (new Random()).nextInt() + "@mail.com";
	}
	
	
}
