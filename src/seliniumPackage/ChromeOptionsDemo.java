package seliniumPackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

	public static void main(String[] args) {
		//Refer https://developer.chrome.com/docs/chromedriver/capabilities
		// Create ChromeOptions object to change the behaviour of chrome browser
		ChromeOptions options=new ChromeOptions();
		//to accept insecure certificate
		options.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		
		//to add extensions
		//options.addExtensions("filePath")
		
		//to set proxy
		/*
		 * Proxy p=new Proxy(); p.setHttpProxy("ipaddress:portNumber");
		 * options.setCapability(null, p);
		 */
		
		//to block pop-up windows
		//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//set download directory
		/*
		 * Map<String,Object> pref= new HashMap<String,Object>();
		 * pref.put("download.default_directory", "C://Users/download");
		 * options.setExperimentalOption("prefs", pref);
		 */

	}

}
