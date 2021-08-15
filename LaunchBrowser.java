package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();

		// implicit wait - wait for defined element for the given time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);

		/// locate the usename and give the username as demosalesmanager
		WebElement webUser = driver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");

		// locate the password and give the username as demosalesmanager
		driver.findElement(By.id("password")).sendKeys("crmsfa"); // better way

		// click on the login button
		driver.findElement(By.className("decorativeSubmit")).click();

		// click on CRM/FSA
		driver.findElement(By.linkText("CRM/SFA")).click();

		// verify that succesfully landed on homepage
		
		  String titleOfHomePage = "My Home | opentaps CRM"; 
		  if(driver.getTitle().equals(titleOfHomePage)) {
		  System.out.println("Landed on home page"); } else
		  System.out.println("Not landed on home page");
		 
		
		// click on leads tab
		driver.findElement(By.linkText("Leads")).click();
		// click create lead
		driver.findElement(By.linkText("Create Lead")).click();
		// enter the company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("testleaf");
		// Step13: Enter FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("monica");
		// Step14: Enter LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("prasad");

		// handle dropdown Source
		WebElement drpSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select source = new Select(drpSource);
		source.selectByIndex(3);

		WebElement drpmarCamp = driver.findElement(By.name("marketingCampaignId"));
		Select marCamp = new Select(drpmarCamp);
		marCamp.selectByValue("CATRQ_CARNDRIVER");

		WebElement drpIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select indus = new Select(drpIndustry);
		indus.selectByVisibleText("Distribution");
		
		WebElement drpCurrency = driver.findElement(By.name("currencyUomId"));
		Select currency = new Select(drpCurrency);
		int size = currency.getOptions().size();
		System.out.println("The size of the the dropdown is " + size );
		

		// Step15: Click CreateLead button

		// driver.findElement(By.className("smallSubmit")).click();
		// clear the country code
		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("5");

	}

}
