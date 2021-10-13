package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver = null;
	private static final String BASE_URL = "https://careers.interventure.info/";
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public LandingPage goTOLandingPage(WebDriver driver) {
		driver.get(BASE_URL);
		driver.manage().window().maximize();
		return new LandingPage(driver);
	}
	
	public void waitUntilelementVisible(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);        
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
	}
	
	public void scrolltoTheTop() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)");
	}
	
	public void waitUntilclickable(WebElement webElement) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);        
        wait1.until(ExpectedConditions.elementToBeClickable(webElement));
	}
}


