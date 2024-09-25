//has linkText

package seliniumPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class automationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com");
		//driver.findElement(By.id("email")).sendKeys("rohitha03@gmail.com");
		//driver.findElement(By.id("pass")).sendKeys("Lakshmi@72");
		//driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Forgot password?")).click();
		driver.findElement(By.id("identify_email")).sendKeys("rohitha03@gmail.com");
		driver.findElement(By.xpath("//a[@role='button']")).click();
		}

}
