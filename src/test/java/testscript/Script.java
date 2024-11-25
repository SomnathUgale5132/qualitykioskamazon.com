package testscript;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;


import extentlistners.Listeners;
import pageobjects.AddToCartPage;
import pageobjects.HomePageAmazon;
import pageobjects.PaymentPage;
import pageobjects.ProductDetailsPage;
import pageobjects.SearchResultsPage;
import pageobjects.SignInPage;
import utility.ExcelReadWriteData;
import utility.WriteExcel;

public class Script extends Listeners {
	
	HomePageAmazon hpa;
	SignInPage sip;
	SearchResultsPage srp;
	ProductDetailsPage pdp;
	AddToCartPage atc;
	PaymentPage pp;
	 ExcelReadWriteData erd;

	@Test(enabled=true ,priority = 1)
	public void verifyTheURL() throws IOException {
		hpa = new HomePageAmazon(driver);
	    String getActualUrl = hpa.navigateToHomePage();
	    Assert.assertTrue(getActualUrl.contains("amazon"), "URL does not contain 'amazon'");
	}

	@Test(enabled=true ,priority = 2)
	public void navigateToSignIn() throws IOException, InterruptedException {
	 sip =new SignInPage(driver);
	    sip.navigateToSignInPage();
	    sip.setUserName(username);
	    sip.continueButton();
	    sip.setPassword(password);
	    sip.clickSignIn();
	}
	
	@Test(enabled=true ,priority = 3)
	public void homePgae() throws IOException {
		
	   hpa.searchProduct("Mobile");
	}
	
	
	
	@Test(enabled = true, priority = 4)
	public void searchResultsPage() {
	    srp = new SearchResultsPage(driver);

	    int productIndex = 4;
	    srp.selectProductByIndex(productIndex);

	    System.out.println("Successfully navigated to product at index " + productIndex);
	    srp.getProductTitle();
	    String productTitle = srp.getProductTitle();
	    Assert.assertNotNull(productTitle, "Product title is null!");

	    System.out.println("Selected Product: " + productTitle);

	}

	@Test(enabled = false, priority = 5)
	public void productDetailsPage() throws IOException {
	    pdp = new ProductDetailsPage(driver);

	    int productIndex = 4; 
	    String[] productDetails = pdp.getProductDetailsByIndex(productIndex);

	    // Print the product details (ensure the details are in an array or list)
	    System.out.println("Product Title: " + productDetails[0]);
	    System.out.println("Product Price: " + productDetails[1]);

	    // Initialize the ExcelReadData object
	    ExcelReadWriteData erd = new ExcelReadWriteData();

	    // Write product details to Excel
	    erd.writeData(productIndex, 0, productDetails[0]);  // Write title in the first column
	    erd.writeData(productIndex, 1, productDetails[1]);  // Write price in the second column
	}
	 
	 
	@Test(enabled=true,priority = 6)
	public void addToCart() throws IOException {
		
	atc=new AddToCartPage(driver);	
   
   srp.addToCart();
    atc.goaddToCarticon();
    String currentUrl = driver.getCurrentUrl();
    Assert.assertTrue(currentUrl.contains("cart"), "Failed to navigate to cart page!");
    System.out.println("Product added to cart successfully!");
    atc.proceedToBuy();
}
	
	
	
	@Test(enabled=true,priority = 7)
	public void paymentPage() throws IOException {
		 pp = new PaymentPage(driver);
	pp.creditOrDebitCard();
	pp.enterCardDetails();
	
	}


}