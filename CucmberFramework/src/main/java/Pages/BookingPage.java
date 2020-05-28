package Pages;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BookingPage {
	WebDriver driver;
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtFirstName")
	WebElement f_name;
	@FindBy(id="txtLastName")
	WebElement l_name;
	@FindBy(id="txtEmail")
	WebElement Email;
	@FindBy(id="txtPhone")
	WebElement Phone_No;
	@FindBy(css="textarea")
	WebElement Address;
	@FindBy(name="city")
	WebElement city;
	@FindBy(name="state")
	WebElement state;
	@FindBy(name="persons")
	WebElement persons;
	@FindBy(id="txtCardholderName")
	WebElement Card_Holder_name;
	@FindBy(id="txtDebit")
	WebElement Card_Number;
	@FindBy(id="txtCvv")
	WebElement Cvv_No;
	@FindBy(id="txtMonth")
	WebElement Exp_Month;
	@FindBy(id="txtYear")
	WebElement Exp_Year;
	@FindBy(id="btnPayment")
	WebElement Confirm_btn;
	
	public void enter_firstName(String name) {
		firstName_validation(name);
		 }
		 
		 public void enter_LastName(String lastName) {
			 lastName_validation(lastName);
		 }
		 
		 public void enter_Email(String email) {
			 Email_validation(email);
			 
		 }
		 
		 public void enter_Phone(String phone) {
			 phone_validation(phone);
			 
		 }
		 
		 public void enter_City(String City) {
			City_validation(City);
//			 Select s = new Select(city);
//			 s.selectByVisibleText(City);
		 }
		 public void enter_State(String State) {
//			 Select s = new Select(state);
//			 s.selectByVisibleText(State);
			 State_validation(State);
		 }
		 
		 
		 public void enter_Persons(String total_persons) {
			 
			 Persons_validation(total_persons);
		 }
		 
		
		 
		 public void enter_Address(String address) {
			 Address.sendKeys(address);
		 }
		 
		 public void enter_Card_Holder_name(String Holder_name) {
			 card_holder_name_validation(Holder_name);
		 }
		 public void enter_Card_Number(String Card_number) {
			 card_Number_validation(Card_number);
			
		 }
		 public void enter_CVV_Number(String CVV) {
			 CVV_Number_validation(CVV);
			 
		 }
		 public void enter_Exp_Month(String Expire_Month) {
			 Expire_Month_validation(Expire_Month);
			 
		 }
		 public void enter_Exp_Year(String Expire_Year) {
			 Expire_Year_validation(Expire_Year);
			 
		 }
		 public void Click_Confirm_btn() {
			 Confirm_btn.click();
		 }
		 public String Page_Title() {
			 return driver.getTitle();
		 }
		 
		 public void firstName_validation(String name) {
			 f_name.sendKeys(name);
			 System.out.println(name + ";" + name.length());
			 if(name.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the First Name")) {
					 System.out.println("alert message is dispalyed \"Please fill the First Name\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							f_name.sendKeys("vinaybabu");
							
							
						}
				 }else {
					 try {
							throw new Exception("Alert is not displaying as expected");
						} catch (Exception e) {
							throw new AssertionError("A clear description of the failure", e);
						}
//					 Assert.assertEquals("Please fill the First Name.", alert);
					 
				 }
			 }
		 }
		 public void lastName_validation(String lastname) {
			 l_name.sendKeys(lastname);
			 if(lastname.length()==0) {
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the Last Name")) {
					 System.out.println("alert message is dispalyed as \"Please fill the Last Name\" expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							l_name.sendKeys("Bibinagar");
						}
				 }else {
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new AssertionError("A clear description of the failure", e);
						}
//					 Assert.assertEquals("Please fill the Last Name", alert);
				 }
			 }
		 }
		 
		 public void Email_validation(String email) {
			 Email.sendKeys(email);
			 if(email.length()==0) {
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the Email")) {
					 System.out.println("alert message is dispalyed as \"Please fill the Last Name\" expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							Email.sendKeys("xyz@tcs.com");
						}
				 }else {
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new AssertionError("A clear description of the failure", e);
						}
//					 Assert.assertEquals("Please fill the Last Name", alert);
				 }
			 }
		 }
		 //Please fill the Mobile No.
		 @SuppressWarnings({ "unlikely-arg-type", "deprecation" })
		public void phone_validation(String phone) {
			 Phone_No.sendKeys(phone);
			 String pattern = "[789]{1}[0-9]{9}";
			 if(phone.length()==0) {
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 	if(alert.equals("Please fill the Mobile No.")) {
				 		System.out.println("alert message is dispalyed as \"Please fill the Mobile No.\" expected");
				 		alt.accept();
				 		try {
							throw new Exception("Alert is displaying as expected");
				 		} catch (Exception e) {
				 			System.out.println(e.getMessage());
				 			Phone_No.sendKeys("9566039231");
						}
				 	}else {
				 		try {
							throw new Exception("Alert is not displaying as expected");
				 		} catch (Exception e) {
				 			System.out.println(e.getMessage());
				 			throw new AssertionError("A clear description of the failure", e);
						}
//				 		Assert.assertEquals("Please fill the Mobile No.", alert);
				 	}
			
				 		
			 }else {
					 if(Pattern.matches(pattern, phone)){
					 return;
				 	}else {
				 		Click_Confirm_btn();
				 		Alert alt = null;
						 try {
						 alt = driver.switchTo().alert();
						 }catch(NoAlertPresentException e){
							 System.out.println("No Alert Present");
							 //driver.close();
						 }
						 if(alt.getText().equals("Please enter valid Contact no.")) {
						 		System.out.println("alert message is dispalyed as \"Please enter valid Contact no.\" expected");
						 		alt.accept();
						 		try {
									throw new Exception("Alert is displaying as expected");
						 		} catch (Exception e) {
						 			System.out.println(e.getMessage());
						 			Phone_No.clear();
						 			Phone_No.sendKeys("9566039231");
								}
						 }
						 		else {
//				 		System.out.println("alert message is dispalyed as \"Please enter valid Contact no.\" expected");
//				 		alt.accept();
				 		try {
							throw new Exception("Alert is not displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new AssertionError("A clear description of the failure", e);
						}
//						 			Assert.assertEquals("Please enter valid Contact no.", alt.getText());
				 	}
				 	}
				 }
			 } 
		 
		 public void City_validation(String City) {
			 Select s = new Select(city);
			 //if(City.length()==0) {
			 	if(dropdown_check(City)) {
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please select city")) {
					 System.out.println("alert message is dispalyed as \"Please select city\" expected");
					 alt.accept();
					 
					 s.selectByVisibleText("Bangalore");
					 //driver.close();
				 }else {
					 try {
							throw new Exception("Alert is not displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new AssertionError("A clear description of the failure", e);
						}
//					 Assert.assertEquals("Please select city", alert);
				 }
			 }else {
				 
				 s.selectByVisibleText(City);
			 }
			 s  = null;
		 }
		 public void Persons_validation(String person) {
			 Select s = new Select(persons);
			 //if(person.length()==0) {
				 if(dropdown_check(person)) {
				 
			 }else {
				 s.selectByVisibleText(person);
			 }
		 }
		 public void State_validation(String State) {
			 Select s = new Select(state);
			 //if(State.length()==0) {
				 if(dropdown_check(State)) {
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
					 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please select state")) {
					 System.out.println("alert message is dispalyed as \"Please select state\" expected");
					 alt.accept();
					 s.selectByVisibleText("Maharashtra");
				 }else {
					 try {
							throw new Exception("Alert is not displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							throw new AssertionError("A clear description of the failure", e);
						}
					 
//					 Assert.assertEquals("Please select state", alert);
				 }
			 }else {
				 s.selectByVisibleText(State);
			 }
		 }
	
		 public void card_holder_name_validation(String name) {
			 Card_Holder_name.sendKeys(name);
			 if(name.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the Card holder name")) {
					 System.out.println("alert message is dispalyed \"Please fill the Card holder name\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							Card_Holder_name.sendKeys("Vinaybabu");
						}
				 }else {
					 try {
						throw new Exception("Alert is not displaying as expected");
					} catch (Exception e) {
						System.out.println(e.getMessage());
						throw new AssertionError("A clear description of the failure", e);
					}
//					 Assert.assertEquals("Please fill the Card holder name", alert);
				 }
			 }
		 }
		 public void card_Number_validation(String Card_number) {
			 Card_Number.sendKeys(Card_number);
			 if(Card_number.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the Debit card Number")) {
					 System.out.println("alert message is dispalyed \"Please fill the Debit card Number\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							System.out.println(e.getMessage());
							Card_Number.sendKeys("123456789");
						}
				 }else {
					 try {
						throw new Exception("Alert is not displaying as expected, expected : \"Please fill the Debit card Number\", but acutal : " +alert);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						throw new AssertionError("A clear description of the failure", e);
					}
//					 Assert.assertEquals("Please fill the Debit card Number", alert);
				 }
			 }
		 }
		 public void CVV_Number_validation(String Cvv_number) {
			 Cvv_No.sendKeys(Cvv_number);
			 if(Cvv_number.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the CVV")) {
					 System.out.println("alert message is dispalyed \"Please fill the CVV\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected, expected : \"Please fill the CVV\", but acutal : " + alert);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
							Cvv_No.sendKeys("111");
						}
				 }else {
					 try {
						throw new Exception("Alert is not displaying as expected");
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
						throw new AssertionError("A clear description of the failure", e);
					}
//					 Assert.assertEquals("Please fill the CVV", alert);
				 }
			 }
		 }
		 public void Expire_Month_validation(String expire_Month) {
			 Exp_Month.sendKeys(expire_Month);
			 if(expire_Month.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill expiration month")) {
					 System.out.println("alert message is dispalyed \"Please fill expiration month\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
							
						} catch (Exception e) {
							
							System.out.println(e.getMessage());
							Exp_Month.sendKeys("12");
						}
				 }else {
					 try {
						throw new Exception("Alert is not displaying as expected : \"Please fill expiration month\", but acutal : " + alert);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
						throw new AssertionError("A clear description of the failure", e);
					}
//					 Assert.assertEquals("Please fill expiration month", alert);
				 }
			 }
		 }
		 public void Expire_Year_validation(String expire_Year) {
			 Exp_Year.sendKeys(expire_Year);
			 if(expire_Year.length()==0) {
				 
				 Click_Confirm_btn();
				 Alert alt = null;
				 try {
				 alt = driver.switchTo().alert();
				 }catch(NoAlertPresentException e){
					 System.out.println("No Alert Present");
				 }
				 String alert = alt.getText();
				 if(alert.equals("Please fill the expiration year")) {
					 System.out.println("alert message is dispalyed \"Please fill the expiration year\" as expected");
					 alt.accept();
					 try {
							throw new Exception("Alert is displaying as expected");
						} catch (Exception e) {
							
							System.out.println(e.getMessage());
							 Exp_Year.sendKeys("2024");
						}
				 }else {
					 try {
						throw new Exception("Alert is not displaying as expected : \"Please fill the expiration year\", but acutal : " + alert);
					} catch (Exception e) {
						
						System.out.println(e.getMessage());
						throw new AssertionError("A clear description of the failure", e);
					}
//					 Assert.assertEquals("Please fill the expiration year", alert);
				 }
			 }
		 }
		 
		 public boolean dropdown_check(String Option) {
			 boolean status  = false;
			 
			 List<WebElement> opt = city.findElements(By.tagName("option"));
			 for (WebElement drop_option : opt) {
				if(drop_option.getText().equals(Option)) {
					status = true;
					break;
				}
			}
			 
			 return status;
		 }
		 
}
