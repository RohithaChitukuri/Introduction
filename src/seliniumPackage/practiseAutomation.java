//Has following-sibling, finding by text()

package seliniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class practiseAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.findElement(By.xpath("//h4[contains(text(),'Cauliflower')]/following-sibling::div[@class='product-action']/button")).click();	
		
	}

}
