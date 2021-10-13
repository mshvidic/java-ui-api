package uiTests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ApplicationPage;
import pages.BasePage;
import pages.JobsPage;
import pages.LandingPage;

public class UITests {
	
	@BeforeAll
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

	}
	
	@Test
	public void firstFlow() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			
			BasePage basePage = new BasePage(driver);
			
			LandingPage landingPage = basePage.goTOLandingPage(driver);
			
			JobsPage jobsPage = landingPage.clickOnJobsOpening().clickOnAllJobs();
			
			jobsPage.verifyIsJobFoundAndItsTags();
			
			
		} finally {
			driver.quit();
		}

	}
	
	@Test
	public void secondFlow() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			
			BasePage basePage = new BasePage(driver);
			
			LandingPage landingPage = basePage.goTOLandingPage(driver);
			
			JobsPage jobsPage = landingPage.clickOnJobsOpening().clickOnAllJobs();
			
			jobsPage.clickOnDepartmentDropdown().clickOnQaFromDropDown();
			
			jobsPage.clickOnLocationDropdown().clickOnBelgradeFromDropDown();
			
			jobsPage.showOpenJobPositions("Beograd", "QA/QE");
			
			
		} finally {
			driver.quit();
		}

	}
	
	
	@Test
	public void thirdFlow() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		try {
			
			BasePage basePage = new BasePage(driver);
			
			LandingPage landingPage = basePage.goTOLandingPage(driver);
			
			JobsPage jobsPage = landingPage.clickOnJobsOpening().clickOnAllJobs();
			
			jobsPage.clickOnDepartmentDropdown().clickOnQaFromDropDown();
			
			jobsPage.clickOnLocationDropdown().clickOnBelgradeFromDropDown();
			
			jobsPage.clickOnRedBoxJob();
			
			basePage.waitUntilelementVisible(JobsPage.applyButtonXpath);
			
			assertTrue(driver.findElement(By.xpath("//h1/span")).getText().contains("Senior SDET Engineer"), "Pozicija ne sadrzi 'Senior SDET Engineer' u Boldu");
						
		    ApplicationPage applicationPage = jobsPage.clickOnApply();
		    
			basePage.waitUntilelementVisible(ApplicationPage.redBoxPositionHeader);
		    
		    applicationPage.typeFirstName("Peter");
		    applicationPage.typeLastName("Peterson");
		    applicationPage.typeEmailName("peter.peterson@gmail.com");
		    applicationPage.typePhone("123456");
		    applicationPage.uploadCv("\\documents\\test.pdf");
		    applicationPage.uploadAdditionalFile("\\documents\\test.pdf");
		    
            //submit
			
		} finally {
			driver.quit();
		}

	}
	

}
