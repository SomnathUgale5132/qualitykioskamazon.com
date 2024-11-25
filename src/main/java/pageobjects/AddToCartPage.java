package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	
	@FindBy(xpath = "//a[contains(@class, 'nav-a') and contains(@id, 'nav-cart')]")
    WebElement addToCarticon;
	/////span[@id='nav-cart-count']
	////span[@class='nav-cart-icon nav-sprite']
    
	@FindBy(xpath = "//input[@class='a-button-input' and @value='Proceed to checkout']")
    WebElement proceedtobuy;
	

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
    
    
    public void goaddToCarticon() {
    	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	jsExecutor = (JavascriptExecutor) driver;
    	jsExecutor.executeScript("arguments[0].scrollIntoView();", addToCarticon);
      
    		jsExecutor.executeScript("arguments[0].click();", addToCarticon);
    	
    }

    public void proceedToBuy() {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	proceedtobuy.click();
    }

   
}
