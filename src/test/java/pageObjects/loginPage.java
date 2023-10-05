package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends basePage{
	
	// TODO Auto-generated constructor stub
	public loginPage(WebDriver driver) {
		
		super(driver);
	}

	// Elements 
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css="button[type='submit']")
	WebElement btnSubmit;
	
	
	//Action Methods
	
	
	// oprnURL()
	public void openUrl() {
		
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; // Deprecated Method
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	// Actions for userName()
	
	public void userName() {
		username.clear();
		//logger.info("Username field cleared");
		username.sendKeys("Admin");
		//logger.info("Username field - Data Entered - " + tduserName);
	}
	
	public void passWord() {
		password.clear();
		//logger.info("Password field cleared");
		password.sendKeys("admin123");
		//logger.info("Password field - Data Entered - " + tdpassWord);
	}
	
	public void clickSubmit() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		btnSubmit.click();
		//logger.info("Login Button Clicked ");
	}
	
}
