package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage{

	WebDriver driver;
	   Actions act;
	
	 @FindBy(xpath = "(//span[contains(text(), 'Sign in') or contains(text(), 'Hello, Sign in')])[1]")
	    WebElement hellowsignin;
		@FindBy(xpath = "//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner'][normalize-space()='Sign in']")
		public WebElement signinbutton;
		@FindBy(xpath = "//label[@class='a-form-label'][normalize-space()='Email or mobile phone number']/following-sibling::input[@name='email']")
		public WebElement txtUserName;
		
		@FindBy(xpath = "//input[@id='continue']")
		public WebElement continuebutton;
		
		@FindBy(xpath = "//label[normalize-space(text())='Password']/ancestor::div[@class='a-section a-spacing-large']/descendant::input[@name='password']")
		public WebElement txtPassword;
		
		@FindBy(xpath = "//input[@id='signInSubmit']")
		public WebElement signIn;
		
		
		
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
		 
	
	public void navigateToSignInPage() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        act = new Actions (driver);
        act.moveToElement(hellowsignin);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    		jsExecutor.executeScript("arguments[0].click();", signinbutton);
    
    }
	
	
	

	public void setUserName(String uname) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		txtUserName.sendKeys(uname);

	}
	
	
	public void continueButton() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		continuebutton.click();
}
		

	public void setPassword(String pwd) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		txtPassword.sendKeys(pwd);

	}

	public void clickSignIn() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		signIn.click();

	}
	

//	public void clickLogout() {
//	userlogout.click();
	
//	}


}
