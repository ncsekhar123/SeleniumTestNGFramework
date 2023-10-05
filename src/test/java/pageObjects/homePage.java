package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage extends basePage{

	// TODO Auto-generated constructor stub
	public homePage(WebDriver driver) {
		
		super(driver);
	}
	
	//Elements
	@FindBy(xpath="//img[@alt='client brand banner']")
	WebElement homeLogo;
	
	@FindBy(css=".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")
	WebElement dashboardText;
	
	//Action Methods
	public Boolean getHomePageLogo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return homeLogo.isDisplayed();
	}

	public String getDashboadText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return dashboardText.getText();
		
	}
	
	
}
