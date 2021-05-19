package com.amazon.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.amazon.base.Base;
import com.amazon.page.HomePage;
import com.amazon.page.LoginPage;

public class HomePageTest extends Base {

	public HomePage hp;
	public LoginPage LoginPage;
	public LoginPage lp;
	public HomePage HomePage;
	
	public HomePageTest() throws IOException 
	{
		super();	
	}
	
	//@BeforeTest
	@BeforeMethod
	public void setUp() throws IOException{
		
		Base.Initialization();
		hp = new HomePage();		
	}
	
//	@Test(priority=1)
//	public void validate_Sigin_Test() throws IOException{
//		LoginPage = hp.validate_Sigin();
//	
//	}
	
	@Test(priority=2)
	//@Test(dependsOnMethods={"validate_Login_Test"})
	public void validate_SearchProduct_Test() throws IOException{
		
		hp = new HomePage();
		LoginPage = hp.validate_Sigin();
		lp = new LoginPage();
		HomePage = lp.validate_Login();
		HomePage = hp.validate_SearchProduct();
		hp.validate_SearchProduct();
	}
	
	@AfterMethod
	public void tearDown(){
		
		//driver.quit();
	}
}
