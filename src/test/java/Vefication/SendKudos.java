package Vefication;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import PageObjects.SendkudosPage;
import PageObjects.ActivityPage;
import Resources.base;

public class SendKudos extends base{
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
		
		ActivityPage aP = new ActivityPage(driver);
		aP.clickSendkudos().click();
		SendkudosPage kudos = new SendkudosPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		kudos.getEmailInKudosSearch().sendKeys("Amulya V Pujar (amulya.pujar@qualitestgroup.com)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ARROW_DOWN,Keys.RETURN);
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(Keys.ENTER,Keys.RETURN);
		
		kudos.getEmailInKudosSearch().click();
		kudos.getComment().sendKeys("Great");
		kudos.getSendButton().click();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	
	}
	
}
