package testScripts;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;

public class loginTest extends baseClass{

	public loginTest() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
    public void beforeClass(){
		loginPage login = new loginPage(driver);

		login.openUrl();
		login.userName();
		login.passWord();
		login.clickSubmit();
    }
	
	@Test
	void test_login() {
		homePage home = new homePage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertTrue(home.getHomePageLogo());

	} // End of Test Method
	
}
