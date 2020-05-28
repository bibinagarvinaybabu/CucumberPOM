package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class testBase {
	
	WebDriver driver;
	Properties prop;
	
	public void LaunchBrowser() {

			driver =Launch_browser();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("file://" +System.getProperty("user.dir") + prop.getProperty("URL"));
	}
	
	public void load_properties() {
		 prop = new Properties();
		 String path = "/Users/A1835947/eclipse-workspace/CucmberFramework/src/main/java/util/util.properties";
		 File file = new File(path);
		
		try {
			prop.load(new FileInputStream(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("browser"));
	}
	
	public WebDriver Launch_browser() {
		load_properties();
		if(prop.getProperty("browser")=="chrome"){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
			 driver = new ChromeDriver();
		}
//		else {
//			driver = new SafariDriver();
//		}
		return driver;
	}
	
	public void teardown() {
		driver.quit();
	}

}
