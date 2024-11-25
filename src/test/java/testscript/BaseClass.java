package testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	 public static WebDriver driver;

	/*
	 * access the utility.ReadConfig class for get properties
	 * 
	 */
	
	utility.ReadConfig readconfig = new utility.ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		if (br.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--start-maximized");
		    options.addArguments("--remote-allow-origins=*");
		    options.addArguments("--disable-notifications");
		    
		    driver = new ChromeDriver(options);		
			

		} else if (br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());

			driver = new InternetExplorerDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

	

	
	@AfterTest
	public void tearDown() throws InterruptedException {
		
		Thread.sleep(30000);
	//driver.quit();
	}

}
