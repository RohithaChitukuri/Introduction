package Test1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
	static WebDriver driver=new ChromeDriver();
	
	@BeforeSuite
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", Utils.Chrome_Driver_location);
	}
	@Test(testName="Submit a webForm")
	public static void submitForm() throws InterruptedException {
		driver.get(Utils.BASE_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebForm webForm=new WebForm(driver);
		webForm.first_name="Rohitha";
		webForm.last_name="Chitukuri";
		webForm.job_title="Tester";
		webForm.date="08/07/2024";
		webForm.yearsOfExperience=webForm.option2to4;
		
		webForm.enterFirstName();
		webForm.enterLastName();
		webForm.enterJobTitle();
		webForm.enterDate();
		webForm.chooseGradSchool();
		webForm.chooseFemale();
		webForm.chooseYearsOfExperience();
		webForm.clickSubmit();
		
	}
	@AfterSuite
	public static void cleanup() {
		driver.manage().deleteAllCookies();
		driver.close();
	}
	

}
