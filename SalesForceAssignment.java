package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAssignment {

	public static void main(String[] args) {
		// Step 1: Download and set the path 

		WebDriverManager.chromedriver().setup();

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL 
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		         //  https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Step 6: Fill in all the text boxes
		driver.findElement(By.name("UserFirstName")).sendKeys("Monica");
		driver.findElement(By.name("UserLastName")).sendKeys("Prasad");
		driver.findElement(By.name("UserEmail")).sendKeys("monica25monu@gail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("Testleaf");
		driver.findElement(By.name("UserPhone")).sendKeys("7659643896");
		
		// Step 7: Handle all the dropdowns
		WebElement drpTitle = driver.findElement(By.name("UserTitle"));
		Select title = new Select(drpTitle);
		title.selectByIndex(2);
		
		WebElement drpEmployee = driver.findElement(By.name("CompanyEmployees"));
		Select employee = new Select(drpEmployee);
		employee.selectByValue("250");
		
		WebElement drpCountry = driver.findElement(By.name("CompanyCountry"));
		Select country = new Select(drpCountry);
		country.selectByVisibleText("India");
		
		// Step 8: Click the check box
		driver.findElement(By.className("checkbox-ui")).click();
		
		// Step 9: Close the browser
		driver.close();
	}

}
