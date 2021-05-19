package com.amazon.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.Base;
import com.amazon.utility.utils;


public class HomePage extends Base {
	
	Actions action = new Actions(driver);

	// 1_Constructor
	public HomePage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	// 2_Locators
	@FindBy(xpath="//a[@id='nav-link-accountList']") // MouseHover
	WebElement accountList;  
	
	@FindBy(xpath="(//span[contains(text(),'Sign in')])[2]") // SingIn
	WebElement singIn;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchBox;  
	
	@FindBy(xpath="//div[@id='suggestions-template']")
	WebElement searchSuggession;
	
	
	
	// 3_Actions
	public LoginPage validate_Sigin() throws IOException{
		
	action.moveToElement(accountList).build().perform(); // MouseeHover
	singIn.click();
	return new LoginPage();
	}
	
	public HomePage validate_SearchProduct() throws IOException{
		
		searchBox.sendKeys(prop.getProperty("searchProduct"));
		utils.searSuggession(driver);
		utils.selecProduct(driver);
		
		return new HomePage();
						
				}
		}