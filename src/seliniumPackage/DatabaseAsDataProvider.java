//works with mysql database

package seliniumPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DatabaseAsDataProvider {

	public static void main(String[] args) throws SQLException {
		String host="localhost";
		String port="3306";
		String person="rohitha";
		String username = null;
		String password = null;
		
		//connecting to database
		//connection url pattern  "jdbc:mysql://"+host+":"+port+"/databasename";
		
		Connection con= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadb", "root", "Rohitha@26");
		//creating statement object
		Statement st=con.createStatement();
		//executing statement
		ResultSet rs= st.executeQuery("select * from credentials where person='"+person+"'");
		//initially rs points to base index. We need to make it point to next() for it to point to real data
		while(rs.next()) {
			username=rs.getString("username");
			password=rs.getString("password");
		}
		
		  WebDriver driver=new ChromeDriver();
		  driver.get("https://rahulshettyacademy.com/client"); 
		  WebElement usernameBox=driver.findElement(By.id("userEmail"));
		  WebElement passwordBox=driver.findElement(By.id("userPassword"));
		  WebElement loginButton=driver.findElement(By.id("login"));
		  
		  usernameBox.sendKeys(username);
		  passwordBox.sendKeys(password);
		  loginButton.click();
		  
		  
		  
		 
	
		
		
	
	}

}
