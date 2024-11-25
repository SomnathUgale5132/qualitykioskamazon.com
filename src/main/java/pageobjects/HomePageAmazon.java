package pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAmazon {
    WebDriver driver;

    
    
   
    
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement Searchtextbox;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchButton;
    

    public HomePageAmazon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    /*
	 * This method is created to get the URL of the page.
	 * 
	 */
	public String navigateToHomePage() {

		String actualUrl = driver.getCurrentUrl();

		return actualUrl;
	}

    
	   public void searchProduct(String productName) {
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	       Searchtextbox.sendKeys(productName);
	       searchButton.click();
	    }
    
   
    
}
