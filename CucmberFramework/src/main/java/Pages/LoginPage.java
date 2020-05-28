package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()=' Hotel Booking Application ']")
	WebElement Login_Title;
	
	@FindBy(xpath="//input[@type='text' and @name='userName']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password' and @name='userPwd']")
	WebElement password;
	
	@FindBy(css="input.btn")
	WebElement login_btn;
	
	@FindBy(id="userErrMsg")
	WebElement User_error;
	
	@FindBy(id="pwdErrMsg")
	WebElement password_error;
	
	
	
	public void enter_UserName(String Uname) {
		username.clear();
		username.sendKeys(Uname);
		 }
		 
		 public void enter_Password(String pwd) {
			 password.sendKeys(pwd);
		 }
		 
		 public void Click_Login() {
			 login_btn.click();
		 }
		 
		 public String Get_Login_title() {
			 return Login_Title.getText();
		 }
		 public String Get_User_error() {
			 return User_error.getText();
		 }
		 public String Get_Password_error() {
			 return password_error.getText();
		 }
		 
		 public void error_validation(String Actual, String Expected) {
			 
			 if(Actual.equals(Expected)) {
					
					System.out.println("Title displayed as : \""+Expected + "\" as expected");
					
				}else {
					System.out.println("Expected title : " + Expected + ", Actual title : " + Actual);
					try {
						throw new Exception("Alert is not displaying as expected");
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			 
		 }

}
