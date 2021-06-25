package com.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testCases.BaseTest;

public class ShippingPage_PO extends BaseTest{

	public ShippingPage_PO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span.a-color-price")
	public static WebElement lblCheckOutPrice;
	
	@FindBy(xpath = "//input[contains(@name, 'AddressLine1')]")
	public static WebElement txtAdrressLine1;
	
	@FindBy(xpath = "//input[contains(@name, 'AddressLine2')]")
	public static WebElement txtAdrressLine2;
	
	@FindBy(xpath = "//input[contains(@name, 'enterAddressCity')]")
	public static WebElement txtCity;
	
	@FindBy(xpath = "//span[@data-action='a-dropdown-button']/following::span[.='Select'][1]")
	public static WebElement cboState;
	
	@FindBy(xpath = "//input[contains(@id, 'enterAddressPostalCode')]")
	public static WebElement txtZipCode;
	
	@FindBy(xpath = "//input[@class='a-button-input']")
	public static WebElement btnUsethisAddress;
	
	public static String btnDeliverAddress = "//a[contains(.,'Deliver to this address')]";
	public void proceedtoShipping() {
		boolean found = false;
		List<WebElement> deliveryAddress = driver.findElements(By.xpath(btnDeliverAddress));
		if(deliveryAddress.size() > 0) {
			for(WebElement btnDeliver: deliveryAddress) {
				if(btnDeliver.isDisplayed()) {
					btnDeliver.click();
					found = true;
					break;
				}
			}
		}
		
		if(!found) {
			txtAdrressLine1.sendKeys(prop.getProperty("addressLine1"));
			txtAdrressLine2.sendKeys(prop.getProperty("addressLine2"));
			txtCity.sendKeys(prop.getProperty("city"));
			cboState.click();
			driver.findElement(By.linkText(prop.getProperty("state"))).click();
			txtZipCode.sendKeys(prop.getProperty("zipCode"));;
			btnUsethisAddress.click();
		}
		
		Assert.assertEquals(SearchResults_PO.itemPrice, lblCheckOutPrice.getText().trim());	
	}
}
