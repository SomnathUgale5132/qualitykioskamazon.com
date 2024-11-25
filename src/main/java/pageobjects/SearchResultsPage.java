package pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {
	
	 WebDriver driver;
	 JavascriptExecutor jsExecutor;
	 WebDriverWait wait;
	 
	    @FindBy(xpath = "//div[contains(@class, 's-main-slot')]/div[@data-component-type='s-search-result']")
	    List<WebElement> productList;
	    
	    @FindBy(xpath = "(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[2]/a/span")
	    WebElement productTitle;
	    
	    @FindBy(xpath = "//button[@id='a-autoid-2-announce' and text()='Add to cart']")
	    WebElement addToCartButton;
	    
	    

	    public SearchResultsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public int getProductCount() {
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        return productList.size();
	    }

	    
	    
	   
	    	 public void selectProductByIndex(int index) {
	    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	        String dynamicXpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']/div[contains(@class, 's-result-item')][" + index + "]";
	    	        WebElement productElement = driver.findElement(By.xpath(dynamicXpath));
	    	        jsExecutor = (JavascriptExecutor) driver;
	    	        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", productElement);
	    	         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	        wait.until(ExpectedConditions.elementToBeClickable(productElement));
	    	        productElement.click();
	    	        System.out.println("Navigating to product at index " + index + ": " + productElement.getText());
	    	    }
	    	 
	    	 
	    	 public String getProductTitle() {
	    		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	        return productTitle.getText();
	    	    }
	    	 
	    	 
	    	 

	    	 
	    	 public void addToCart() {
	    		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	        addToCartButton.click();
	    	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	    }
	    
}
