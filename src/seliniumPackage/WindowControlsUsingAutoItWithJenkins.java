package seliniumPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowControlsUsingAutoItWithJenkins {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String downloadPath=System.getProperty("user.dir")+"\\Downloads";
		
		//refer: google documentation -for setting download preferences
		HashMap<String,Object> chromePrefs=new HashMap<String,Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		
		//setting experimental options "prefs" to chromePrefs
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		//passing ChromeOptions object to ChromeDriver
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement downloadButton=driver.findElement(By.id("downloadButton"));
		WebElement chooseFileButton=driver.findElement(By.xpath("//input[@id='fileinput']"));
		
		//download file
		downloadButton.click();
		Thread.sleep(2000);
		//for input[@id='fileinput'] , click() doesn't work. So we need to use Actions
		Actions actions = new Actions(driver);
		actions.moveToElement(chooseFileButton).click().perform();
		//chooseFileButton.click();
		Thread.sleep(5000);
		File file=new File(downloadPath+"/download.xlsx");
		
		//if file is downloaded,upload it
		if(file.exists()) {
			Runtime.getRuntime().exec("C:\\Users\\SUNNY\\eclipse-workspace\\Introduction\\autoItFileUploadJenkins.exe");
		}
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastMsg=driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)"));
		//wait for toaster msg to disapper
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		String toastText=toastMsg.getText();
		Assert.assertEquals("Updated Excel Data Successfully.",toastText );
		//delete the file
		file.delete();		
		driver.close();
		
	

	}

}
