package com.amazon.practisetest;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.base.Base;
import com.amazon.page.HomePage;

public class utils {
	
	// Since Initialization in base class method is static and we need to use below class or instance var there,
	// hencce we need to Keep implicitylyWait & pageLoadTimeout as static as well otherwise it'll throw error
	
	public utils() throws IOException 
	{	
		
	}


	public static int implicitlyWait=30;
	public static int pageLoadTimeout=30;
	//public static WebDriver driver;
	
	
	//SearchSugession
	public static void searSuggession(WebDriver driver){
		
//      How to pass driver instance n utils class,, Here we are using hardcoded value 
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\com\\amazon\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();

		List<WebElement> searchList =  driver.findElements(By.xpath("//div[@id='suggestions-template']"));		
		
//		this for loop is not valid for this scenario
//		for(int i=0;i<searchList.size();i++){			    
//		if (searchList.contains("puma shoes for men")){
		
			for(WebElement searchListSize :searchList){	
				
				
				if (searchListSize.getText().contains("puma shoes for men")){				
					searchListSize.click();
					break;
					}
				} 
			
			List<WebElement> pumaShoeList =    driver.findElements(By.xpath("//span[contains(text(),'Puma')]"));
			
					for(int i=0;i<pumaShoeList.size();i++){
						if(pumaShoeList.equals("Men's Beam Idp Running Shoes")){
						
			
				for(WebElement pumaShoeListSize : pumaShoeList){
					
					if (pumaShoeListSize.getText().contains("Men's Beam Idp Running Shoes")){
						
						pumaShoeListSize.click();
						
				}
			}
		}				
					} 
	}
}
