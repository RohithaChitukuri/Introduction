package seliniumPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://google.com");
		//to maximise window
		driver.manage().window().maximize();
		//to delete cookies
		driver.manage().deleteAllCookies();
		//to delete a specific cookie/ or session key
		//driver.manage().deleteCookieNamed("cookie name/session key");
		
		

	}

}
