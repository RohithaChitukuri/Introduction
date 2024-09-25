//has moving to element, keyDown for pressing and holding  a key, 
//doubleClick to double click and select the string
//contextClick() to right-click

package seliniumPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Actions a=new Actions(driver);
		WebElement searchBox=driver.findElement(By.xpath("//input[@type=\"search\"]"));
		a.moveToElement(searchBox).click().sendKeys("carrot").build().perform();
		searchBox.clear();
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("brocolli").build().perform();
		searchBox.clear();
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("cucumber").doubleClick().build().perform();
		a.moveToElement(searchBox).contextClick().build().perform();
	}

}
