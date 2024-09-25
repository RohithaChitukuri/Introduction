package seliniumPackage;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowsInNewTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stubb
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement footer=driver.findElement(By.id("gf-BIG"));
		WebElement discountLink= footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> discountLinks= discountLink.findElements(By.tagName("a"));
		for(int i=1;i<discountLinks.size();i++) {
			String openInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			discountLinks.get(i).sendKeys(openInNewTab);
			Thread.sleep(10000L);
		}
		
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> it= tabs.iterator();
		while(it.hasNext()) {
			System.out.println(driver.switchTo().window(it.next()).getTitle());
		}
	}

}
