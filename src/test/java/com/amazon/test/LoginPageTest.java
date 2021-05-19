package com.amazon.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.page.HomePage;
import com.amazon.page.LoginPage;

public class LoginPageTest extends Base{

	public LoginPage lp;  // Since, we need to call the methods of LoginPage, Hence declared at class level
	public HomePage HomePage;
	public LoginPage LoginPage;
	
	public LoginPageTest() throws IOException 
	{
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		Base.Initialization();
		lp = new LoginPage();
		HomePage = new HomePage();
	}
	
	@Test(priority=1)
	public void validate_Login_Test() throws IOException{
		LoginPage = HomePage.validate_Sigin();
		HomePage = lp.validate_Login();
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
