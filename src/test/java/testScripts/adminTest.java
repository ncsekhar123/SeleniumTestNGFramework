package testScripts;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.adminPage;
import pageObjects.homePage;
import pageObjects.loginPage;

public class adminTest extends baseClass{

	public adminTest() {
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
	void test_admin() {

		homePage home = new homePage(driver);
		adminPage admin = new adminPage(driver); 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		admin.clickAdminTab();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertEquals(admin.tabName(), "Admin1");

	} // End of Test Method

}
