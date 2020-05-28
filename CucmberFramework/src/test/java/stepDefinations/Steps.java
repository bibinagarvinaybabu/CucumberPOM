package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.BookingPage;
import Pages.LoginPage;
import Pages.SuccessPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.testBase;

public class Steps extends testBase{
	
	private WebDriver driver;
	private LoginPage login_page;
	private BookingPage bookings;
	private SuccessPage successpage; 
	

	@Before
    public void beforeScenario(){
        System.out.println("This will run before the Scenario");
        
//        LaunchBrowser();
    } 
	
	
	@Given("Launch the application browser")
	public void launch_the_application_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 
	}

	@When("Open the login web page in the browser.")
	public void open_the_login_web_page_in_the_browser() {
		driver.get("file://" +System.getProperty("user.dir") + "/Casestudy_HotelBooking/login.html");
	}

	@When("Verify login page heading as {string} using xpath.")
	public void verify_login_page_heading_as_using_xpath(String Login_Title) {
		login_page = new LoginPage(driver);
		String Heading = login_page.Get_Login_title();

		login_page.error_validation(Heading, Login_Title);
		
		
	}

	@When("Enter UserName. Ensure that displays the error message {string} upon clicking on the Login button without entering any data in the text box.")
	public void enter_UserName_Ensure_that_displays_the_error_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String error) {
		login_page.enter_UserName("");
		login_page.Click_Login();
		String U_name_error = login_page.Get_User_error();
		//login_page.error_validation(U_name_error, "Please enter UserName");
		if(U_name_error.equals(error)) {
			
			System.out.println("Title displayed as : \"" + error + "\" as expected");
			
		}else {
			System.out.println("Expected title : " + error + ", Actual title : " + U_name_error);
			
		}
		
	}

	@When("Enter Password. Ensure that displays the error message {string} upon clicking on the Login button without entering any data in the text box.")
	public void enter_Password_Ensure_that_displays_the_error_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String error) {
		
		login_page.enter_UserName("admin");
		login_page.enter_Password("");
		login_page.Click_Login();
		String Password_error = login_page.Get_Password_error();
		//login_page.error_validation(Password_error, "Please enter Password");
		if(Password_error.equals(error)) {
			
			System.out.println("Title displayed as : \""+error+"\" as expected");
			
		}else {
			System.out.println("Expected title : " + error + ", Actual title : " + Password_error);
			
		}
	}

	@When("Enter {string} as username and {string} as password for valid login.")
	public void enter_as_username_and_as_password_for_valid_login(String u_name, String pwd) {
		login_page.enter_UserName(u_name);
		login_page.enter_Password(pwd);
		login_page.Click_Login();
		
		
	    
	}

	@Then("Verify the title {string} of the page.")
	public void verify_the_title_of_the_page(String title) {
		bookings = new BookingPage(driver);
		String page_Title = bookings.Page_Title();
		login_page.error_validation(page_Title, title);
	   
	}

	@When("Enter First_Name {string}  Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_Confirm_Button_without_entering_any_data_in_the_text_box(String first_name, String error) {
		bookings.enter_firstName(first_name);
	}

	@When("Enter Last_Name {string}  Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Last_Name_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String last_name, String error) {
	   bookings.enter_LastName(last_name);
	   
	}

	@When("Enter Email {string} Ensure that the alert box displays the message {string} upon wrong email format entered in the text box.")
	public void enter_Email_Ensure_that_the_alert_box_displays_the_message_upon_wrong_email_format_entered_in_the_text_box(String Email, String error) {
		bookings.enter_Email(Email);
	}

	@When("Enter mobile_no {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_mobile_no_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String phone, String error) {
	   bookings.enter_Phone(phone);
	}

//	@When("Ensure that the alert box displays the message {string} upon clicking on the button {string} on entering wrong data that doesn’t start with either {double} or {int} and doesn’t have {int} digits in the text box.")
//	public void ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_on_entering_wrong_data_that_doesn_t_start_with_either_or_and_doesn_t_have_digits_in_the_text_box(String string, String string2, Double double1, Integer int1, Integer int2) {
//	    
//	}


	@When("Enter address_details {string} validation for address.")
	public void enter_address_details_validation_for_address(String Address) {
		
	   bookings.enter_Address(Address);
	}

	@When("Select City {string}  Ensure that alert box display the message {string} upon clicking on the Confirm Button without selecting any city.")
	public void select_City_Ensure_that_alert_box_display_the_message_upon_clicking_on_the_button_without_selecting_any_city(String City, String error) {
	   bookings.enter_City(City);
	}

	@When("Select State {string} Ensure that alert box display the message {string} upon clicking on the Confirm Button without selecting any state.")
	public void select_State_Ensure_that_alert_box_display_the_message_upon_clicking_on_the_button_without_selecting_any_state(String State, String error) {
	   bookings.enter_State(State);
	}
	
	@When("Select Number_of_people {string} staying at the Hotel. Ensure that the alert box displays the message {string} upon clicking on the  Confirm button without entering any data in the box.")
	public void select_Number_of_people_staying_at_the_Hotel_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_box(String persons, String error) {
	   bookings.enter_Persons(persons);
	}

	@When("Enter Card_Holder_Name {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Card_Holder_Name_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String Holder_name, String error) {
	   bookings.enter_Card_Holder_name(Holder_name);
	}

	@When("Enter Debit_card_Number {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Debit_card_Number_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String Card_number, String error) {
	   bookings.enter_Card_Number(Card_number);
	}
	@When("Enter CVV {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_CVV_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_Confirm_Button_without_entering_any_data_in_the_text_box(String CVV, String error) {
	    bookings.enter_CVV_Number(CVV);
	}

	@When("Enter Card_expiration_month {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Card_expiration_month_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String Expire_Month, String error) {
	   bookings.enter_Exp_Month(Expire_Month);
	}

	@When("Enter Card_expiration_year {string} Ensure that the alert box displays the message {string} upon clicking on the Confirm Button without entering any data in the text box.")
	public void enter_Card_expiration_year_Ensure_that_the_alert_box_displays_the_message_upon_clicking_on_the_button_without_entering_any_data_in_the_text_box(String Expire_Year, String error) {
	   bookings.enter_Exp_Year(Expire_Year);
	}

	@When("Click on Confirm Booking button.")
	public void click_on_Confirm_Booking_button() {
	   bookings.Click_Confirm_btn();
	}

	@Then("Ensure that it navigates to success page which displays the message {string}.")
	public void ensure_that_it_navigates_to_success_page_which_displays_the_message(String title) {
		
		successpage = new SuccessPage(driver);
		successpage.Status_check(title);
		try {
			Thread.sleep(5000 );
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	    
	}
	
 
	@After
    public void afterScenario(){
		login_page = null;
		bookings = null;
		successpage = null;
		//teardown();
    }
	

}
