package seliniumPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UsingStreamsDemo {
	static WebDriver driver = new ChromeDriver();

	public static Map<String, String> getItemsPrices(WebDriver driver) {
		// nextDisabled=driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).getAttribute("aria-disabled").contains("true");
		List<String> names = new ArrayList<String>();
		List<String> prices = new ArrayList<String>();
		//TreeMap is used to get sorted Map
		Map<String, String> itemPrice = new TreeMap<String, String>();
		
		// finding number.of pages
		List<WebElement> pages = driver.findElements(By.xpath("//ul[@class='pagination pull-right']/li"));
		int pagesCount = pages.size() - 4;
		// collecting all items and corresponding prices
		for (int i = 1; i <= pagesCount; i++) {
			List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
			List<WebElement> price = driver.findElements(By.xpath("//tr/td[2]"));

			List<String> tempNames = items.stream().map(s -> s.getText()).collect(Collectors.toList());
			names.addAll(tempNames);
			List<String> tempPrices = price.stream().map(s -> s.getText()).collect(Collectors.toList());
			prices.addAll(tempPrices);

			if ((driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).getAttribute("aria-disabled")
					.contains("false"))) {
				driver.findElement(By.xpath("//a[@aria-label=\"Next\"]")).click();
			}

		}
		//putting values to Map
		for (int i = 0; i < names.size(); i++) {
			itemPrice.put(names.get(i), prices.get(i));
		}

		return itemPrice;
	}

	public static Map<String, String> search(WebDriver driver, String searchItem) {
		// searching items for their prices from collected Map of names and prices

		return getItemsPrices(driver).entrySet().stream().filter(e -> e.getKey().contains(searchItem))
				.collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue()));
				// .map(Map.Entry::getValue)
	}

	@Test(testName = "sort functionality")
	// test if sort functionality is working or not
	// getting list of items in ascending order
	public static void testSort() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//tr/th[1]")).click();
		Set<String> items = getItemsPrices(driver).keySet();
		List<String> list1 = items.stream().collect(Collectors.toList());
		List<String> list2 = items.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(list1, list2);
	}

	@Test(testName = "search Functionality")
	public static void testSearch() {
		String searchItem = "to";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// using search() method to return items with the given search name.
		// search uses getItemsPrices() to get all items, corresponding prices
		Map<String, String> list1 = search(driver, searchItem);
		
		//collecting search results which appeared on webpage
		driver.findElement(By.id("search-field")).sendKeys(searchItem);
		Map<String, String> list2 = getItemsPrices(driver);
//			list2.entrySet().stream().forEach(s->System.out.println(s.getKey()));
//			list1.entrySet().stream().forEach(s->System.out.println(s.getKey()));
		
		//comparing if both are equal
		Assert.assertEquals(list1, list2);

	}

}
