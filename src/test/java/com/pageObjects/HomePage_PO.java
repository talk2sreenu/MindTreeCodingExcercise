package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.BaseTest;

public class HomePage_PO extends BaseTest{

	public HomePage_PO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="twotabsearchtextbox")
	public static WebElement txtSearchBox;
	
	@FindBy(id="nav-search-submit-button")
	public static WebElement btnSearchIcon;
	
	public void launchApplication() {
		String appName = prop.getProperty("application_URL");
		String searchWord = prop.getProperty("search_Input");
		driver.get(appName);
		txtSearchBox.sendKeys(searchWord);
		btnSearchIcon.click();
	}
	
}
