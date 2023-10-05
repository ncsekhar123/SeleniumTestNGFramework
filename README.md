# SeleniumTestNGFramework

Pre Steps: 
1. Java Installation
2. Eclipse Installation
3. Maven Project in Eclipse: 
File -> New - > Maven Project -> Create Sample Project -> Group id, Artifact id SeleniumCucumber -> Finish
Project -> Right Click -> Properties -> Java Build Path -> Libraries tab -> Add Library -> JRE System Library -> Alternate JRE -> 
					C:\Program Files\Java\jdk-11


4. Add Dependencies:

	selenium-java: 		4.12.0
	webdrivermanager: 	5.5.2
	log4j-core: 		2.20.0
	log4j-api: 		2.20.0
	testng: 		7.7.1
	extentreports: 		5.1.0

    <dependencies>
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.12.0</version>
	</dependency>
	
    <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
    <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.5.2</version>
	</dependency>
	
    <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
    <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.20.0</version>
   	 </dependency>
    
    <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
    <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.20.0</version>
	</dependency>
	
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.1</version>
    <scope>test</scope>
	</dependency>
	
    <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
    <dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.0</version>
	</dependency>

    </dependencies>

 -> Maven -> Update Project -> Suggest Not to do force maven update
 -> Check Maven Dependencies

5. Folder Structure / Packages

 src/test/java -> New packages -> pageObjects, testBase, testScripts, utilites
 Project root  -> New folders  -> logs, reports, screenshots

Note: 
1. POM -> design pattern -> maintainable, reusable, readable 
2. Each web page - > Page Class -> WebElements of web page + Page methods to perform operations on WebElements
				-> Page class names logical to have ex loginPage, accountCreatePage, transactionsPage etc
				-> Method names as per the operations/actions performing ex accountCreate();, debitTransfer();
3. POM Structure -> Page Class (Web Elements + Action Methods) ex loginPage AND Test Class (Test Methods) ex loginTest
4. Page Factory  -> inbuilt in selenium -> initialize page elements or instantiate page elements
		 -> @FindBy (No driver. or no “FindElement/s”)

6.  src/test/java/pageObjects -> Create new classes -> basePage, loginPage, homePage

7. testBase class -> Implement WebDriver instance in testBase 

	public class testBase {

	WebDriver driver;
	
	public testBase(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	}


8. loginPage class -> Extend testBase and extend the driver instance using super

public class loginPage extends basePage{

	public loginPage(WebDriver driver) {
		super(driver); 
		// TODO Auto-generated constructor stub
		}

	}
9. loginPage class -> Define elements and action methods

	// Elements 
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;

	//Action Methods
	public void userName() {
		username.clear();
		username.sendKeys();
	}
	
	public void passWord() {
		password.clear();
		password.sendKeys();
	}

10. homePage class -> Extend testBase and extend the driver instance using super

11. Create baseClass under package 'testScripts' to create reusable methods

	A. Setup() and tearDown() Methods:

	@BeforeClass
		void setup() {
	}
	
	@AfterClass(){
		void tearDown() {
		
	}

	Note: Import testng annotations for @BeforeClass and @AfterClass

	B. Create WebDriver driver instance:

	public WebDriver driver;


	C. Implement setup() method:

	String browser = "Chrome";
		
	@BeforeClass
	void setup() {
		String browser = "Chrome";
		
		if (browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			//logger.info("Browser is setup - " + browser);
	   		driver = new FirefoxDriver();
	   		//logger.info("Selenium driver - " + browser);
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   		
	   		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
			} 

		else if (browser.equalsIgnoreCase("chrome")) {  
			
			WebDriverManager.chromedriver().setup();
			//logger.info("Browser is setup - " + browser);
	   		driver = new ChromeDriver();
	   		//logger.info("Selenium driver - " + browser);
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   		
	   		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			} 
		else if (browser.equalsIgnoreCase("edge")) {  
			
			WebDriverManager.edgedriver().setup();
			//logger.info("Browser is setup - " + browser);
			driver = new EdgeDriver();
			//logger.info("Selenium driver - " + browser);
			
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   		driver.manage().window().maximize(); 
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	   		
	   		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   		
	   		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			}
		}

	D. 	Implement tearDown() Method:

		@AfterClass()
		void tearDown() {
		
		driver.quit();
	}

12. Implement loginTest Script:


	package testScripts;

	public class loginTest{

	public loginTest() {
		// TODO Auto-generated constructor stub
	}

	
	}


	A. public class loginTest extends baseClass

	B. Create actual test for login

	@Test
	void test_login() {
	}

	C. Create loginPage object and pass driver

		loginPage login = new loginPage(driver);

		Note: Import loginPage class from different package

NOTE: 
Install testng in Eclipse -> Help -> Eclipse Market Place -> Search for testng -> Select https://testng.org -> Trust Selected


mvn clean: Cleans the project and removes all files generated by the previous build.
mvn install: Deploys the packaged JAR/ WAR file to the local repository.
mvn test: Runs tests for the project.

Assert Methods of TestNG:

Extent Reports:

pom.xml Dependencies:
	
    <!-- https://mvnrepository.com/artifact/org.testng/testng -->
    <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.7.1</version>
    <scope>test</scope>
    </dependency>
	
    <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
    <dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.0</version>
    </dependency>

TestNG -> Test Automation Execution Reports -> Integrated with major testing frameworks - JUnit, NUnit, TestNG, BDD etc

Steps to implement: 
Step1: Create ExtentReportManager class under utilities package
Step2: captureScreenshot() method in baseClass
	Note: Generate Timestamp for screenshot and reports
Step3: Add listener tag for extentManager class in testng.xml

1. String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp for logs and reports
	  repName = "Test-Report-" + timeStamp + ".html";

2. sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName); // specify location of the report
	-> sparkReporter.config() for ReportDocument Title, Report Name, Report Theme for UI

3. extent = new ExtentReports(); // ExtentReports instance is created

4. extent.attachReporter(sparkReporter); // spartReporter instance to .attachReporter method

5. define .setSystemInfo fo display in the report
	
	extent.setSystemInfo(String, String);
	extent.setSystemInfo("Application", "OrangeHRM");
	extent.setSystemInfo("Module", "Module1");
	extent.setSystemInfo("Sub Module", "Admin");
	extent.setSystemInfo("Operating System", System.getProperty("os.name"));
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	extent.setSystemInfo("Environemnt", "QA");

    A. ExtentReports class
    B. ExtentTest class

A. ExtentReports reports = new ExtentReports("Path of directory to store the resultant HTML file", true/false);

	-> The ExtentReports class generates HTML reports based on a path specified
	->  Based on the Boolean flag, the existing report is overwritten or a new report is generated
	-> ‘True’ is the default value -> all existing data will be overwritten

ExtentTest test = reports.startTest("TestName");

	-> The ExtentTest class logs test steps onto the previously generated HTML report.

Extent Reports Builtin methods.
 
    createTest: The createTest method returns a ExtentTest object which can be used to publish logs or attach screenshots
    Log: Logs the status of each test step onto the HTML report being generated
    Flush: Erases any previous data on a relevant report and creates a whole new report

Test Status is indicated by the following values: Note: Just like log4j messages

    PASS
    FAIL
    SKIP
    INFO

TestNG Listeners:

Ex: ITestListener:
 	-> org.testng.ITestNGListener an interface 
	-> ITestListener is the listener for test running
	-> Using listeners, we can extend test management features using testng for ex notifications/logs, reports and test behavior

	-> ITestResult is used along with all the listeners

ITestListener has methods on following events:

    onStart is invoked after the test class is instantiated and before any configuration method is called
    onTestSuccess is invoked on success of a test
    onTestFailure is invoked on failure of a test
    onTestSkipped is invoked whenever a test is skipped
    onTestFailedButWithinSuccessPercentage is invoked each time a method fails but is within the success percentage requested.
    onFinish is invoked after all the tests have run and all their Configuration methods have been called.


Screenshot Capture in extent reports.

File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
File Dest = new File("src/../BStackImages/" + System.currentTimeMillis() + ".png");
FileUtils.copyFile(scrFile, Dest);

TestNG.XML:

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="OrangeHRM Application-Module1">
	<listeners>
	<listener class-name="utilities.ExtentReportManager"/>
	</listeners>

    <test name="Regression">
         <classes>
             <class name="testScripts.loginTest"/>
             <class name="testScripts.homePageTest"/>
             <class name="testScripts.adminTest"/>
          </classes>
     </test> <!-- Test -->
</suite> <!-- Suite -->

TESTNG.XML - Multiple Suites:

<suite name="allSuites">
  <suite-files>
    <suite-file path="testng-Module1.xml" />
    <suite-file path="suite2.xml" />
    ...
  </suite-files>
</suite>

UpdatedUser M User

git remote add origin https://github.com/ncsekhar123/SeleniumTestNGFramework.git
git branch -M main
git push -u origin main
$ git remote
$ git remote add origin "https://github.com/ncsekhar123/SeleniumTestNGFramework.git"

Added repository access to -> Ashishjscnd@gmail.com

