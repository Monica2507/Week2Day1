package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FceBookAssignment {

	public static void main(String[] args) {
		// Step 1: Download and set the path

		WebDriverManager.chromedriver().setup();

		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Monica");
		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("prasad");

		// Step 9: Enter the mobile number
		driver.findElement(By.name("reg_email__")).sendKeys("9087654385");

		// Step 10: Enterthe password
		driver.findElement(By.id("password_step_input")).sendKeys("qwerty123");

		// Step 11: Handle all the three drop downs
		WebElement drpDay = driver.findElement(By.id("day"));
		Select Day = new Select(drpDay);
		Day.selectByValue("25");

		WebElement drpMonth = driver.findElement(By.id("month"));
		Select Month = new Select(drpMonth);
		Month.selectByValue("Jul");

		WebElement drpYear = driver.findElement(By.id("year"));
		Select Year = new Select(drpYear);
		Year.selectByIndex(25);

		// Step 12: Select the radio button "Female"
		//driver.findElement(By.xpath("//*[@id=\"u_2_o_mB\"]/span[1]/label")).click();

	}

}
