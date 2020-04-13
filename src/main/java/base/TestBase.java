package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static NgWebDriver ngWebDriver;
	public static 	JavascriptExecutor jsDriver;
	public static Properties prop;

	public static void InitProp() throws IOException {
		prop = new Properties();
		FileInputStream fi = new FileInputStream("src/main/java/config/config.properties");
		prop.load(fi);

	}
	
	public static void Initialization() throws IOException {
		InitProp();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		jsDriver = (JavascriptExecutor) driver;
		ngWebDriver = new NgWebDriver(jsDriver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ngWebDriver.waitForAngularRequestsToFinish();
			
	}
	
 	public static void ExplicitWait(WebDriver driver, int timeout, WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	public static void failedTestCase(String testMethodName) {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File ("screenshots/"+testMethodName+"_"+".jpg"));
		} catch (IOException e) {
		  e.printStackTrace();
		  e.getMessage();
		}
}
	

	public static void CloseBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}
}
