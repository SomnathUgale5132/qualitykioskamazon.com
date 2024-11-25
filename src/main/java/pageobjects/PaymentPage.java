package pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
	
WebDriver driver;

    
  
    @FindBy(xpath = "//input[@value='SelectableAddCreditCard']")
    WebElement cardrediobutton;
   
    @FindBy(xpath = "(//div[@class='a-row pmts-add-cc-default-trigger']/child::a[@class='a-link-emphasis pmts-add-cc-default-trigger-link' and text()='Enter card details'])[1]")
    WebElement entercarddetails;
    

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public void creditOrDebitCard() {
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	cardrediobutton.click();
    }

    
    public void   enterCardDetails() {
    	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        entercarddetails.click();
    }

   

}
