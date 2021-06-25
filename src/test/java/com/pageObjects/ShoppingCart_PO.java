package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testCases.BaseTest;

public class ShoppingCart_PO extends BaseTest{
	
	public ShoppingCart_PO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//b[contains(.,'Cart subtotal')]/following::span)[1]")
	public static WebElement lblCartTotal;
	
	@FindBy(id = "hlb-ptc-btn-native")
	public static WebElement btnProceedToCheckOut;
	
	@FindBy(xpath = "//h1[contains(.,'shipping')]//following::input[@value='Continue'][1]")
	public static WebElement btnContinue;
	
	
	
	public void validateCart() {
		String cartTotal = lblCartTotal.getText().trim();
		Assert.assertEquals(cartTotal, SearchResults_PO.itemPrice, "Item Price matches from Cart to CheckOut Page");	
		btnProceedToCheckOut.click();	
	}
}
