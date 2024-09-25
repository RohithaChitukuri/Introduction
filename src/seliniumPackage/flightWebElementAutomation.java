//Has Select class, implicitlyWait, getText() from a webElement

package seliniumPackage;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class flightWebElementAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement currency=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select currencyDropdown=new Select(currency);
		currencyDropdown.selectByIndex(1);
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByValue("AED");
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		currencyDropdown.selectByVisibleText("USD");
		System.out.println(currencyDropdown.getFirstSelectedOption().getText());
		
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=0;i<4;i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> suggestions= driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		for (WebElement webElement : suggestions) {
			if(webElement.getText().equalsIgnoreCase("India")) {
				webElement.click();
				break;
			}
			
		}
		
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		
	}

}
