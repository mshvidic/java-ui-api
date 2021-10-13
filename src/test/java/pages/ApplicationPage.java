package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationPage extends BasePage {
	
	
	@FindBy(css = "input#candidate_first_name")
	private WebElement firstName;
	
	@FindBy(xpath = "input#candidate_last_name")
	private WebElement lastName;
	
	@FindBy(xpath = "input#candidate_email")
	private WebElement email;
	
	@FindBy(xpath = "input#candidate_phone")
	private WebElement phone;
	
	@FindBy(xpath = "//ul[contains(@class,'jobs') and contains(@class,'card')]/li")
	private List<WebElement> openJobs;
	
	@FindBy(css = "input#candidate_resume_remote_url")
	private WebElement uploadCv;
	
	@FindBy(css = "input#candidate_file_remote_url")
	private WebElement uploadAdditionalFile;
	
	@FindBy(css = "//textarea")
	private WebElement textField;
	
	public static final String redBoxPositionHeader = "//h1[contains(text(),'Senior SDET Engineer - Redbox team')]";

	
	
	
	
	
	public ApplicationPage (WebDriver driver) {
		super(driver);
	}
	
	
	public ApplicationPage typeFirstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);		
		return this;
	}
	
	public ApplicationPage typeLastName(String lastName) {
		this.lastName.clear();
		this.lastName.sendKeys(lastName);		
		return this;
	}
	
	public ApplicationPage typeEmailName(String email) {
		this.email.clear();
		this.email.sendKeys(email);		
		return this;
	}
	
	public ApplicationPage typePhone(String phone) {
		this.phone.clear();
		this.phone.sendKeys(phone);		
		return this;
	}
	
	public ApplicationPage uploadCv (String fileRelativePath) {
		uploadCv.sendKeys(System.getProperty("user.dir") + fileRelativePath);
		return this;
		
	}
	
	public ApplicationPage uploadAdditionalFile (String fileRelativePath) {
		uploadAdditionalFile.sendKeys(System.getProperty("user.dir") + fileRelativePath);
		return this;
		
	}
	
	public ApplicationPage typeTextInTextfield(String text) {
		textField.clear();
		textField.sendKeys(text);
		return this;
	}
	
}
