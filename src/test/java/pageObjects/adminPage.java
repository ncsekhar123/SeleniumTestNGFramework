package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class adminPage extends basePage {

	public adminPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	// Elements 
		@FindBy(css="div#app li:nth-child(1) > a > span")
		WebElement admin;
		
	// Elements 
		@FindBy(xpath="//span[normalize-space()='Qualifications']")
		WebElement qualificationsTab;
		
		public void clickAdminTab() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			admin.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//logger.info("Login Button Clicked ");
		}
		
		public String tabName() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			return admin.getText();
		}
}
