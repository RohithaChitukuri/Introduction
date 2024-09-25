package seliniumPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ScrollingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new  ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("window.scroll(0,500)");
		je.executeScript("document.querySelector(\".tableFixHead\").scrollTop=1000");
		
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		int onScreen=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum,onScreen);

	}

}
