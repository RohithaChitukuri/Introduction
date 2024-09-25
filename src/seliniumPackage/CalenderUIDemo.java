package seliniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class CalenderUIDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String year="2027";
		String month="6";
		String day="26";
		String[] date= {month,day,year};
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup__input.react-date-picker__inputGroup__year")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText.react-calendar__navigation__label__labelText--from")).click();
		driver.findElement(By.xpath("//button[text()="+year+"]")).click();
		List<WebElement> months= driver.findElements(By.xpath("//abbr"));
		months.get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()="+day+"]")).click();
		List<WebElement> c= driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int i=0;i<c.size();i++) {
			System.out.println(c.get(i).getAttribute("value"));
			Assert.assertEquals(c.get(i).getAttribute("value"), date[i]);
		}
		
		}

}
