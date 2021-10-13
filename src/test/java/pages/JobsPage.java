package pages;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class JobsPage extends BasePage {

	@FindBy(xpath = "//a[contains(text(),'Job openings')]")
	private WebElement jobsOpening;
	
	@FindBy(xpath = "//a/span[contains(text(),'All jobs')]")
	private WebElement allJobs;
	
	@FindBy(xpath = "//div[contains(@class,'dropdown') and contains(@data-name,'department')]")
	private WebElement departmentDropdown;
	
	@FindBy(xpath = "//div[contains(@class,'dropdown') and contains(@data-name,'location')]")
	private WebElement locationDropdown;
	
	@FindBy(xpath = "//ul[contains(@class,'jobs') and contains(@class,'card')]/li")
	private List<WebElement> openJobs;
	
	@FindBy(xpath = "//li//span[contains(text(),'Senior SDET Engineer - Redbox team')]")
	private WebElement jobRedBox;
	
	
	public static final String applyButtonXpath = "(//a[contains(@class,'btn') and contains(text(),'Apply')])[1]";
	
	
	public JobsPage (WebDriver driver) {
		super(driver);
	}
	
	public JobsPage clickOnDepartmentDropdown() {
		scrolltoTheTop();
		waitUntilclickable(departmentDropdown);
		departmentDropdown.click();
		return this;
	}
	
	public JobsPage clickOnQaFromDropDown() {
		departmentDropdown.findElement(By.xpath(".//ul/li[contains(text(),'QA/QE')]")).click();
		driver.navigate().refresh();
		return this;
	}
	
	
	public JobsPage clickOnLocationDropdown() {
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

		locationDropdown.click();  
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		return this;
	}
	
	public JobsPage clickOnBelgradeFromDropDown() {
		departmentDropdown.findElement(By.xpath("//ul/li[contains(text(),'Belgrade')]")).click();
		driver.navigate().refresh();
		return this;
	}
	
	
	public void showOpenJobPositions(String location, String position) {

		System.out.println("U" +  location +"u su otvorene sledece "+ position + " pozicije: ");
		System.out.println();
		
		
		for (WebElement e : openJobs) {
			System.out.println(e.getText());    
			System.out.println();
		}
	}
	
	
	public void verifyIsJobFoundAndItsTags() {
	
    List<WebElement> found = null;
    for (WebElement we : openJobs) {
    found = we.findElements(By.xpath(".//span[contains(@class,'title') and contains(text(),'Senior SDET Engineer - Redbox team')]"));        
    if(found.size() == 1) {
    	System.out.println("Job AD is found!");
    	assertEquals("QA/QE · Belgrade", found.get(0).findElement(By.xpath("./following-sibling::span")).getText(), "Position and location tags are wrong!");
    	break;
    }  
    }
    
    System.out.println(found.size());
    Assertions.assertEquals(1, found.size(), "Job AD is not found!");
	}
	
	public JobsPage clickOnRedBoxJob() {
		jobRedBox.click();
		return this;
	}
	
	public ApplicationPage clickOnApply() {
		driver.findElement(By.xpath(applyButtonXpath));
		return new ApplicationPage(driver);
	}

}
