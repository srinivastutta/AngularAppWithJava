package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.HomePage;

public class LoginTest extends TestBase {
	HomePage homepage;
		
	@BeforeMethod
	public void launchBrowser() throws IOException {
		Initialization();
		homepage = new HomePage();
		System.out.println(homepage.getPageTitle());
		Assert.assertTrue(homepage.ImageValidation());
	}
	
	@Test (priority =1)
	public void loginTest() throws InterruptedException {
		homepage.Login();
		homepage.userNameValidation(prop.getProperty("userName"));
	}
	
	@Test (priority =2)
	public void dilogBoxValidationTest(){
		homepage.dialogBoxElementValidation();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	
	}
}
