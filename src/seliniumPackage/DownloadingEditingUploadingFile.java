package seliniumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadingEditingUploadingFile {

	public static void main(String[] args) throws IOException {
		String fruitName="Apple";
		String priceColumnName="price";
		
		String sheetName="Sheet1";
		String newFruitPrice="100";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement downloadButton=driver.findElement(By.id("downloadButton"));
		WebElement chooseFileButton=driver.findElement(By.cssSelector("input[type='file']"));
		
		//downloading file
		downloadButton.click();
		
		File file =new File("C:\\Users\\SUNNY\\Downloads\\download.xlsx");
		String filePath=file.getAbsolutePath();
		
		//editing file
		ExcelInfo ei=new ExcelInfo();
		FileInputStream fis=new FileInputStream(filePath);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		//getting hold of "Sheet1"
		XSSFSheet sheet= ei.getSheet(workBook, sheetName);
		int fruitRowNumber=ei.getRowNumber(sheet, fruitName);
		int priceColumnNumber=ei.getColumnNumber(sheet, priceColumnName);
		String fruitPrice=ei.getCellValue(sheet, fruitRowNumber, priceColumnNumber);
		//getting hold of row using row number
		Row row=sheet.getRow(fruitRowNumber);
		//getting hold of cell using column number
		Cell cell=row.getCell(priceColumnNumber);
		//setting value in the cell
		cell.setCellValue(newFruitPrice);
		//creating output stream
		FileOutputStream fos=new FileOutputStream(filePath);
		//writing in workbook by passing output stream object
		workBook.write(fos);
		workBook.close();
		fis.close();
		
		//uploading file
		chooseFileButton.sendKeys(filePath);
		WebElement toastMsg=driver.findElement(By.cssSelector(".Toastify__toast-body div:nth-child(2)"));
		//wait for toaster msg to disapper
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		String toastText=toastMsg.getText();
		Assert.assertEquals("Updated Excel Data Successfully.",toastText );
		System.out.println(toastText);
		
		//verifying updated table from website
		WebElement price=driver.findElement(By.xpath("//div[text()=\"Price\"]"));
		String priceColumn=price.getAttribute("data-column-id");
		WebElement priceValueElement=driver.findElement(By.xpath("//div[text()='"+fruitName+"']/parent::div/parent::div/div[@id='cell-"+priceColumn+"-undefined']"));
		String priceValue=priceValueElement.getText();
		Assert.assertEquals(newFruitPrice, priceValue);
		
		driver.quit();
		
	}

}
