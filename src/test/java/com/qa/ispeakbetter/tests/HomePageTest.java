package com.qa.ispeakbetter.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ispeakbetter.base.BasePage;
import com.qa.ispeakbetter.page.HomePage;
import com.qa.ispeakbetter.page.LoginPage;



public class HomePageTest {	
	WebDriver driver;
	Properties prop;
	BasePage base;
	HomePage homePage;
	LoginPage loginPage;
	
	@BeforeMethod
	
	public void setUP(){
	
	base = new BasePage();
	prop = base.init_properties();
	String browsername= prop.getProperty("browser"); 
	driver = base.init_drver(browsername);
	driver.get(prop.getProperty("url"));
	
	homePage = new HomePage(driver);
	loginPage = homePage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
	
	}
	
	@Test(priority = 1, description = "Gettin Title from IspeakBetter")
	public void verifyHomePageTitle(){
	String title = homePage.getTitle(); 
	System.out.println("Getting Title: " + title);
	Assert.assertEquals(title, "Learn English with Online Teachers - Get your Free Live English Class Now.");
	}
	
	@Test(priority = 2, description = "Gettin Url from IspeakBetter")
	public void verifyUrl(){
	String url = homePage.getUrl();
	System.out.println("Getting Url: " + url);
	Assert.assertEquals(url, "https://ispeakbetter.com/");
	
	}
	
	
	@Test(priority = 3, description = "Login Configuration in HomePage")
	public void doLogin(){
		
//		 loginPage = homePage.clickLogin(prop.getProperty("username"), prop.getProperty("password"));
		String accountName = loginPage.getAccountName();
		Assert.assertTrue(accountName.contains("Good Evening"));

		
		
	}
	
	
	
	
	@Test()
	public void fillOutProgram() throws InterruptedException{
		homePage.BuyProgram();
		Thread.sleep(5000);
		
	}
	
//	@AfterMethod
//	public void tearDown(){
//		driver.close();
//	}
//	
	
}



