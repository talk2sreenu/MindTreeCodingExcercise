package com.pageObjects;

import java.util.Base64;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.BaseTest;

public class SignIn_PO extends BaseTest{
	
	public SignIn_PO() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='ap_email']")
	public static WebElement txtLogin;
	
	@FindBy(xpath = "//input[@id='continue']")
	public static WebElement btnContinueLogin;
	
	@FindBy(xpath = "//input[@name='password']")
	public static WebElement txtPassword;
	
	@FindBy(css = "input#signInSubmit")
	public static WebElement btnSignIn;
	
	public void signIntoAmazonAccount() {
		txtLogin.sendKeys(prop.getProperty("userName"));
		btnContinueLogin.click();
		byte[] decodedBytes = Base64.getDecoder().decode(prop.getProperty("password"));
		String password = new String(decodedBytes);
		txtPassword.sendKeys(password);
		btnSignIn.click();
	}
}
