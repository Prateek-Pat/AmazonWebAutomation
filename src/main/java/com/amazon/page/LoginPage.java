package com.amazon.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;

public class LoginPage extends Base {

	// 1_Constructor
	public LoginPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}

	// 2_Locators
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement email;
		
	@FindBy(xpath="//input[@id='continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	WebElement singIn;
	
	//3_Actions
	public HomePage validate_Login() throws IOException{
		
		email.sendKeys(prop.getProperty("email"));
		continueButton.click();
		
		password.sendKeys(prop.getProperty("password"));
		singIn.click();
		return new HomePage();
	}
}


