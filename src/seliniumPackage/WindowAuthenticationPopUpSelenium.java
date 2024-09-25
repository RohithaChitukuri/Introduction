package seliniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAuthenticationPopUpSelenium {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//https://username:password@siteUrl   - selenium stores the username,password and when auth pop up emeges,it passes the values into the pop up box
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Basic Auth")).click();
		
		

	}

}
