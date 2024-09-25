package Test1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class WebForm extends PageObject{

	public WebForm(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String first_name;
	String last_name;
	String job_title;
	String date;
	String yearsOfExperience;
	
	@FindBy(id="first-name")
	WebElement First_name_textbox;
	
	@FindBy(id="last-name")
	WebElement Last_name_textbox;
	
	@FindBy(id="job-title")
	WebElement Job_title_textbox;
	
	@FindBy(xpath="//input[@id='radio-button-1']")
	WebElement High_School_radio_button;
	
	@FindBy(xpath="//input[@id='radio-button-2']")
	WebElement College_radio_button;
	
	@FindBy(xpath="//input[@id='radio-button-3']")
	WebElement Grad_School_radio_button;
	
	@FindBy(id="checkbox-1")
	WebElement Male_checkbox;
	
	@FindBy(id="checkbox-2")
	WebElement Female_checkbox;
	
	@FindBy(id="checkbox-3")
	WebElement Prefer_not_to_say_checkbox;
	
	@FindBy(id="select-menu")
	WebElement Years_of_experience;
	
	Select Years_of_experience_dropdown=new Select(Years_of_experience);
	String option0to1 ="0-1";
	String option2to4 = "2-4";
	String option5to9 = "5-9";
	String option10above = "10+";
	
	@FindBy(id="datepicker")
	WebElement Date;
	
	@FindBy(xpath="//a[text()='Submit']")
	WebElement Submit_Button;
	
	public void enterFirstName() {
		this.First_name_textbox.sendKeys(first_name);
	}
	public void enterLastName() {
		this.Last_name_textbox.sendKeys(last_name);
	}
	public void enterJobTitle() {
		this.Job_title_textbox.sendKeys(job_title);
	}
	public void enterDate() {
		this.Date.sendKeys(date);
	}
	public void chooseYearsOfExperience() {
		this.Years_of_experience_dropdown.selectByVisibleText(yearsOfExperience);
	}
	public void chooseMale() {
		this.Male_checkbox.click();
	}
	public void chooseFemale() {
		this.Female_checkbox.click();
	}
	public void choosePreferNotToSay() {
		this.Prefer_not_to_say_checkbox.click();
	}
	public void choosehighSchool() {
		this.High_School_radio_button.click();
	}
	public void chooseCollege() {
		this.College_radio_button.click();
	
	}
	public void chooseGradSchool() {
		this.Grad_School_radio_button.click();
	}
	public void clickSubmit() {
		this.Submit_Button.click();
	}
	
	

}
