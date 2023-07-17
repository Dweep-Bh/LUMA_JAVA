package com.lumaproject.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signinpage {
	
WebDriver ldriver;
 JavascriptExecutor jsExecutor;

	
	public Signinpage(WebDriver rdriver)
	{
		ldriver = rdriver;


		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement signin;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement password;
	
	@FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement submit;
	
	public void clickOnSignInButton()
	{
		signin.click();
	}
	
	public void enterEmail(String emailID) {
	   
		email.sendKeys(emailID);
	}
	
	public void enterPassword(String pwd) {
		   
		password.sendKeys(pwd);
	}
	
	public void clickOnsubmit() {
		submit.click();
	}
	public void scrollDownByPixels(int pixels) throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) ldriver;
        jsExecutor.executeScript("window.scrollBy(0, " + pixels + ");");
        Thread.sleep(5000); // It's better to use explicit waits, this is just an example.
    }
	public List<WebElement> getElementsList() {
        return ldriver.findElements(By.cssSelector("li[class='product-item']"));
    }

    // Method to click on a particular element from the list
	 public void clickElementByProductName(String productName) {
	        List<WebElement> elementsList = getElementsList();

	        // Iterate through the list of elements to find the desired product by name
	        for (WebElement element : elementsList) {
	            String elementText = element.getText();
	            if (elementText.contains(productName)) {
	                element.click();
	                System.out.println("Clicked on the product: " + productName);
	                return; // Return once the product is found and clicked
	            }
	        }

	        // If the product is not found
	        System.out.println("Product not found: " + productName);
	    }

}
