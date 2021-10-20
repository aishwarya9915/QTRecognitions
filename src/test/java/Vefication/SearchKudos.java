package Vefication;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.KudosSearch;
import PageObjects.LoginPage;
import PageObjects.ActivityPage;
import Resources.base;

public class SearchKudos extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
public void sendKudos(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("aishwarya.patil@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		ActivityPage ap = new ActivityPage(driver);
		ap.clickKudosSearch().click();
		
		KudosSearch ks = new KudosSearch(driver);
		ks.getEmail().sendKeys("Amulya V Pujar");
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='s_e_add']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		ks.ClickSearch().click();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
}
