package Vefication;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SendkudosPage;
import PageObjects.ActivityPage;
import Resources.base;

public class RecentKudos extends base{
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
		
		ActivityPage aP=new ActivityPage(driver);
		aP.clickRecentKudos().click();
		
		SendkudosPage skp = new SendkudosPage(driver);
		skp.getWriteAppreciationMsg().click();
		skp.getComment().sendKeys("Great");
		skp.getSendButton().click();
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
}
