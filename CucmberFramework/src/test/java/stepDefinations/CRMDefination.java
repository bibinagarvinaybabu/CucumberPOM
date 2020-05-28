package stepDefinations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CRMDefination {
	WebDriver driver;
	@Given("User is already on login page")
	public void user_is_already_on_login_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://classic.crmpro.com/");
	    
	}

	@When("Title of login page is free crm")
	public void title_of_login_page_is_free_crm() {
		
		String loginTitle = driver.getTitle();
		System.out.println("Login title : " + loginTitle);
		Assert.assertEquals("CRMPRO - CRM software for customer", loginTitle);
	    
	}

	@Then("User enters credentials")
	public void user_enters_credentials(io.cucumber.datatable.DataTable usercredentials) {
	    
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		 driver.findElement(By.name("username")).sendKeys(data.get(0).get("username")); 
		     driver.findElement(By.name("password")).sendKeys(data.get(0).get("password"));
		     driver.findElement(By.xpath("//*[@value = 'Login']")).click();
		           
	}

	@Then("User click on login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//*[@value = 'Login']")).click();
	}

	@Then("User is on Home Page")
	public void user_is_on_Home_Page() {
	   String Home_page = driver.getTitle();
	   Assert.assertEquals("CRMPRO", Home_page);
	}
	
	@Then("User moves to New Deal page")
	public void user_moves_to_New_Deal_page() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@title='Deals']")));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@title='New Deal']")).click();
		
		
	    
	}

	@Then("User enters deal details")
	public void user_enters_deal_details(io.cucumber.datatable.DataTable dataTable) {
	    
	}

	@Then("User moves to New Contact page")
	public void user_moves_to_New_Contact_page() {
	   
	}

	@Then("User enters contact details")
	public void user_enters_contact_details(io.cucumber.datatable.DataTable dataTable) {
	    
	}


}
