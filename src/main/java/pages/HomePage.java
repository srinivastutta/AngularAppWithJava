package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.paulhammant.ngwebdriver.ByAngular;
import base.TestBase;

public class HomePage extends TestBase{
	
	//Login Page Elements
    By login_Image = By.cssSelector("a.navbar-brand>img[src='/cms-de/wp-content/uploads/2019/11/logo_white.png']");
    By profile_Button = By.cssSelector("ul#menu-header-menu>li:nth-of-type(8)>a");
    By search_Element = By.cssSelector("li#menu-item-10>a[data-text='Suchseite']");
    By promptMessage = By.cssSelector("button#matomo-reject");

    
    
    //Login Dialog Box Elements
    By close_Button = By.cssSelector("span.iframe-dialog-close, icon, icon-CO_close");
    By email_Input = By.cssSelector("input#mat-input-0");
    By password_Input = By.cssSelector("input#mat-input-1");
    By  remember_Password = By.cssSelector("span.link, margin-top-15");
    By  registration_Button = By.cssSelector("body > app-root > div > div > main > app-login > div > div.row.justify-content-center.mx-auto.w-100.xs-content-area > div > div > div.col-11.col-md-8.col-lg-6.col-xl-7 > div.row.d-none.d-md-flex > div:nth-child(1) > button");
    By  login_Button = ByAngular.buttonText("Einloggen");
    By login_Message = By.cssSelector("div.col-12>app-error-message.ng-star-inserted>div>div>p");
    By back_Button = By.cssSelector("div[class='row justify-content-center mx-auto ng-star-inserted']>div>a");
   
     //User Profile Elements
    By user_name = By.xpath("//*[@id='header-container']/div[1]/span");
    By user_Icon = By.cssSelector("div[class='profile-picture-container ng-star-inserted']>app-avatar>div>img[alt='avatar-picture']");
    By myProfile_DropDown = By.cssSelector("ul[class='menu-desktop d-lg-block d-md-none d-sm-none']>li:nth-of-type(7)>a>div");
    By myProfile_Element = By.cssSelector("div.dropdown-container>a[routerlink='my-profile']>div>span:nth-of-type(2)");
    By logout_Element = By.cssSelector("body > app-root > div.app-container.ng-star-inserted.show-security-banner > app-header > div > div.header-wrapper > div > div.float-right > ul > li.menu-item.fullOpacity.menu-dropdown-item.ng-tns-c1-0.ng-star-inserted.open.show > div > div > a:nth-child(2) > div > span.menu-text");
	
	public HomePage() {
		PageFactory.initElements(driver, this);

	}
	
 	public String getPageTitle() {
 		return driver.getTitle();
 		
 	}
 	
 	public boolean ImageValidation() {
 		return driver.findElement(login_Image).isDisplayed();
 		
 	}
	

 	public void Login() throws InterruptedException {
 		driver.findElement(promptMessage).click();
 		driver.findElement(profile_Button).click();
 		ExplicitWait(driver, 30, driver.findElement(By.id("iframeDialog")));
 		WebElement iframe = driver.findElement(By.id("iframeDialog"));
 		
 		driver.switchTo().frame(iframe);
  		ngWebDriver.waitForAngularRequestsToFinish();
 		driver.findElement(email_Input).sendKeys("dirk.nonn@cgm.com#1111");
 		driver.findElement(password_Input).sendKeys("recruitingTest1!");
 		ngWebDriver.waitForAngularRequestsToFinish();
 		driver.findElement(login_Button).click();
 		
 		ngWebDriver.waitForAngularRequestsToFinish();
 		
 		String win1 = driver.getWindowHandle();
 		driver.switchTo().window(win1);
 		
 		WebElement uName = driver.findElement(By.xpath("//*[@id='header-container']/div[1]/span"));
 		ExplicitWait(driver, 30, uName);
 		
 		
 	}
 	
 	public void userNameValidation(String EnterUserName) {
 		String UserName= driver.findElement(user_name).getText();
 		Assert.assertEquals(UserName, EnterUserName);
 		
 		
 	}
 	
 	public void dialogBoxElementValidation() {
 		
 		driver.findElement(promptMessage).click();
 		driver.findElement(profile_Button).click();
 		ExplicitWait(driver, 30, driver.findElement(By.id("iframeDialog")));
 		WebElement iframe = driver.findElement(By.id("iframeDialog"));
 		
 		driver.switchTo().frame(iframe);
  		ngWebDriver.waitForAngularRequestsToFinish();
  		boolean emailInput = driver.findElement(email_Input).isDisplayed();
  		Assert.assertTrue(emailInput);
  		boolean passwordInput = driver.findElement(password_Input).isDisplayed();
  		Assert.assertTrue(passwordInput);
  		boolean rememberPassword = driver.findElement(remember_Password).isDisplayed();
  		Assert.assertTrue(rememberPassword);
  		boolean registrationButton = driver.findElement(registration_Button).isDisplayed();
  		Assert.assertTrue(registrationButton);
  		
 		
 		
 	}
 	
}
