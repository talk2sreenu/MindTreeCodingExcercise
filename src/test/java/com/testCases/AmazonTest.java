package com.testCases;

import org.testng.annotations.Test;

import com.pageObjects.HomePage_PO;
import com.pageObjects.SearchResults_PO;
import com.pageObjects.ShippingPage_PO;
import com.pageObjects.ShoppingCart_PO;
import com.pageObjects.SignIn_PO;

public class AmazonTest extends BaseTest{
	
	@Test
	public void validateAmazon() {
		HomePage_PO login = new HomePage_PO();
		SearchResults_PO search = new SearchResults_PO();
		ShoppingCart_PO cart = new ShoppingCart_PO();
		SignIn_PO sign = new SignIn_PO();
		ShippingPage_PO ship = new ShippingPage_PO();
		
		login.launchApplication();
		search.selectSearchResults();
		cart.validateCart();
		sign.signIntoAmazonAccount();
		ship.proceedtoShipping();
	}
}
