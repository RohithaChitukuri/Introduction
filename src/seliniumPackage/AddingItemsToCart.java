//has implicit, explicit wait, logic for adding list of items to cart

package seliniumPackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingItemsToCart {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] items = { "Brocolli", "Cucumber" };
		List<String> itemsList = Arrays.asList(items);

		List<WebElement> products = driver.findElements(By.xpath("//div[@class=\"product\"]"));
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@class=\"product-action\"]/button[@type=\"button\"]"));
		int j = 0;
		for (int i = 0; i < products.size(); i++) {
			String[] productNames = products.get(i).getText().split("-");
			String productName = productNames[0].trim();
			if (itemsList.contains(productName)) {
				addToCartButtons.get(i).click();
				j++;
				if (j == items.length)
					break;
			}

		}
		driver.findElement(By.xpath("//a[@class=\"cart-icon\"]")).click();
		driver.findElement(By.xpath("//a[@class=\"cart-icon\"]/following-sibling::div[@class=\"cart-preview active\"]/div[@class=\"action-block\"]/button[@type=\"button\"]")).click();
		driver.findElement(By.xpath("//input[@class=\"promoCode\"]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class=\"promoWrapper\"]/button[@class=\"promoBtn\"]")).click();
		
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"promoInfo\"]")));
		String code=driver.findElement(By.xpath("//span[@class=\"promoInfo\"]")).getText();
		if(code.equals("Code applied ..!")) {
			driver.findElement(By.xpath("//span[@class=\"totAmt\"]/following-sibling::button")).click();
		}
		
		}
		
		
		
	}
	

