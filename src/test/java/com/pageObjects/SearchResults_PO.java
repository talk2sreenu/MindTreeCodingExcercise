package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testCases.BaseTest;

public class SearchResults_PO extends BaseTest{

	public SearchResults_PO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@class='a-link-normal a-text-normal'])[1]")
	public static WebElement lnkSearchResults;
	
	@FindBy(xpath = "(//span[@class='a-price']/span)[1]")
	public static WebElement lblItemPrice_SearchResults;
	
	@FindBy(css = "span#newBuyBoxPrice")
	public static WebElement lblItemPrice;
	
	@FindBy(name = "submit.add-to-cart")
	public static WebElement btnAddToCart;
	
	public static String itemPrice;
	
	public void selectSearchResults() {
		String searchItemPrice = null;
		List<WebElement> itemAmounts = driver.findElements(By.xpath("//span[@class='a-price']"));
		for(WebElement itemAmount:itemAmounts) {
			if(itemAmount.isDisplayed()) {
				String tempVal[] = itemAmount.getText().trim().split("\\n");
				searchItemPrice = tempVal[0].trim()+"."+tempVal[1].trim();
				break;
			}
		}
		lnkSearchResults.click();
		itemPrice = lblItemPrice.getText().trim();
		Assert.assertEquals(itemPrice, searchItemPrice, "Item Price not matched from Search Results to Cart");
		btnAddToCart.click();
	}
}
