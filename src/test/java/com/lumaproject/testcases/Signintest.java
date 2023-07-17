package com.lumaproject.testcases;

import org.testng.annotations.Test;

import com.lumaproject.pageobject.Signinpage;

public class Signintest extends BaseClass {
	
	@Test
	public void signin() throws InterruptedException {
		
		Signinpage signin=new Signinpage(driver);
		
		signin.clickOnSignInButton();
		signin.enterEmail("dweep25@yopmail.com");
		signin.enterPassword("dweep!@#123456");
		signin.clickOnsubmit();
		int scrollDownByPixels = 1500;
		signin.scrollDownByPixels(scrollDownByPixels);
		String productName = "Hero Hoodie";

        // Click on the element with the specified product name
		signin.clickElementByProductName(productName);
	}
	

}
