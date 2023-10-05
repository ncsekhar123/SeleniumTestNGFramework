package testScripts;

import java.time.Duration;

//ExtentReports extentReport;
//ExtentTest extentTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.homePage;
import pageObjects.loginPage;

public class homePageTest extends baseClass{

	public homePageTest() {
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
	void test_homePageLogo() {
		homePage home = new homePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertTrue(home.getHomePageLogo());

	} // End of Test Method
	
	@Test
	void test_dashboardText() {
			
		homePage home = new homePage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		Assert.assertEquals(home.getDashboadText(), "Dashboard");

	} // End of Test Method
	
}
