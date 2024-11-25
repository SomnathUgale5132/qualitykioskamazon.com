package pageobjects;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	 WebDriver driver;
	   
	    @FindBy(xpath = "(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[2]/a/span")
	    String productTitle;
	    @FindBy(xpath = "(//div[@class='puisg-col-inner']//span[@class='a-price-whole'])[2]")
	    String productPrice;
	    
	    @FindBy(xpath = "//input[@id='add-to-cart-button']")
	    WebElement addToCartButton;
	    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	    WebElement buyNowButton;

	    public ProductDetailsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	  

	    public String[] getProductDetailsByIndex(int index) {
	    	
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        String titleXPath = String.format(productTitle, index);
	        String priceXPath = String.format("productPrice", index);

	        String title = driver.findElement(By.xpath(titleXPath)).getText();
	        String price = "Price Not Available";

	        try {
	            price = driver.findElement(By.xpath(priceXPath)).getText();
	        } catch (NoSuchElementException e) {
	            System.out.println("Price not found for product at index " + index);
	        }

	        return new String[]{title, price};
	    }

	    
	    public void addToCart() {
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        addToCartButton.click();
	    }

	    public void buyNow() {
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        buyNowButton.click();
	    }
	}

