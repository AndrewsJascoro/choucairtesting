package com.choucairtesting;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchChoucairtesting{
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void testChoucairtestingPage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Pruebas de software centradas en su negocio");
		
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		assertEquals("Pruebas de software centradas en su negocio - Google Search", driver.getTitle());
	}
	
	@After
	public void tearDonw() {
		driver.quit();
	}
}
