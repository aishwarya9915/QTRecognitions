package Vefication;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Resources.base;

public class ActivityTest extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
	}
	@Test
public void ActivityPage(){
		
		driver.get(prop.getProperty("url"));
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys("aishwarya.patil@qualitestgroup.com");
		lp.getPassword().sendKeys("P@ssw0rd");
		lp.clickLogin().click();
		
		System.out.println(driver.findElement(By.xpath("(//h5[@class='header-font-size'])[1]")).isDisplayed());
		
		String s= driver.findElement(By.xpath("//img [@src='img\\\\avatar.svg']")).getAttribute("alt");
		System.out.println(s);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();	//to close the current page
	}
}
