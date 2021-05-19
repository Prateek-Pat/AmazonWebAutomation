package com.amazon.utility;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.base.Base;

public class CopyOfutils extends Base {

	// Since Initialization in base class method is static and we need to use below class or instance var there,
	// hencce we need to Keep implicitylyWait & pageLoadTimeout as static as well otherwise it'll throw error

	public CopyOfutils() throws IOException {
		super();		
	}

	public static int implicitlyWait=30;
	public static int pageLoadTimeout=30;
	public static WebDriver driver;


	//Searching Sugession
	public static void searSuggession(WebDriver driver){

		List<WebElement> searchList =  driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax'] //div[@class='s-suggestion']"));		

		/* 2nd Method usng for Loop

		   for(int i=0; i<searchList.size(); i++){				
				 String shoeName = searchList.get(i).getText();		
				 	if(shoeName.equals("puma shoes")){				 		
				 		driver.findElements(By.xpath("//div[@class='s-suggestion']")).get(i).click();
				 	} 
				}  	*/
		 

		// 1st method using Advanced for loop
		for(WebElement searchList1 : searchList){
			if (searchList1.getText().equals("puma shoes for men")){
				searchList1.click();
				//break;
			}
		}	
	}	

	//Seleting Product
	//public static void selecProduct(){
	
	public static void selecProduct(WebDriver driver){

		List<WebElement> pumaShoe = driver.findElements(By.xpath("//span[contains(text(),'Puma')]"));

		for(WebElement pumaShoe1 : pumaShoe){			

			if(pumaShoe1.getText().equals("Men's Agile T1 Nm Idp Running Shoes")){				
				pumaShoe1.click();
				break;
			}	
		}
	}			
}


	/*
		for(int i=0; i<pumaShoe.size(); i++){	
			String shoeName = pumaShoe.get(i).getText();
			if (shoeName.equals("Men's Agile T1 Nm Idp Running Shoes")){				
				driver.findElements(By.xpath("//span[contains(text(),'Agile T1 Nm Idp Running Shoes')]")).get(i).click();
			}

			}  */










