package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends BasePage {
	
	@FindBy(xpath = "//a[contains(text(),'Job openings')]")
	private WebElement jobsOpening;
	
	@FindBy(xpath = "//a/span[contains(text(),'All jobs')]")
	private WebElement allJobs;
	
	
	
	public LandingPage (WebDriver driver) {
		super(driver);
	}
	
	public LandingPage clickOnJobsOpening() {
		jobsOpening.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return this;
	}
	
	public JobsPage clickOnAllJobs() {
		allJobs.click();
		driver.navigate().refresh();
		return new JobsPage(driver);
	}

}
