package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	
	public SuccessPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[text()='Booking Completed!']")
	WebElement Status;
	
	public void Status_check(String title) {
		String status = Status.getText();
		if(status.equals(title)) {
			System.out.println("Status message displayed as : \"" + status + "\" as expected");
		}else {
			try {
				throw new Exception("Status is not displaying as expected");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}

}
