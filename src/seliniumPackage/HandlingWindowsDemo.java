package seliniumPackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.xpath("//a[@class=\"blinkingText\"]")).click();
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> windowsIterator = windows.iterator();
		String parentWindow = windowsIterator.next();
		String childWindow = windowsIterator.next();
		driver.switchTo().window(childWindow);
		String username=driver.findElement(By.xpath("//strong/a[@href]")).getText().split("@")[1].split("\\.")[0];
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(username);
		
		
		
	}

}
