package common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class DriverBase extends CommonUtilities{//extended with CommonUtilities
	public String externalFilePath = currDirectory+File.separator+"External"+File.separator;//getting the file path for external folder
	
	public WebDriver driver;//declared some public variables so that we can use in different classes and packages 
	public String url;
	public String browser;
	
	/**
	 * 
	 * @param browser
	 * @param url
	 * @throws InterruptedException
	 */
	
	public synchronized void launchBrowser (String browser,String url) throws InterruptedException {//used synchronized here since we have global properties 
		//Setting driver exe path
		System.setProperty("WebDriver.gecko.driver", externalFilePath+"geckodriver.exe");
		System.setProperty("WebDriver.chrome.driver", externalFilePath+"chromedriver.exe");
		
		//choosing the browsers
		
	if (browser.equalsIgnoreCase("FF") || browser.equalsIgnoreCase("firefox")) {//If browser = FF or firefox
		System.out.println("Instantiating Firefox driver");
		driver = new FirefoxDriver();	
	}else if (browser.equalsIgnoreCase("chrome")){
		System.out.println("Instantiating Chrome driver");
		driver = new ChromeDriver();
	}else {
		System.out.println("Invalid Browser. Please Set Global property as Firefox or Chrome.");
	    }
	 Thread.sleep(2000);
	 System.out.println("Maximizing window");
	 driver.manage().window().maximize();
	 Thread.sleep(2000);
	 System.out.println("Setting temeout Settings..");
	 driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 driver.get(url);	
	 Thread.sleep(2000);
	 }
	
	/**
	 * Method to capture screen shot on failure
	 * @param result
	 */
	public synchronized void captureScreenshotsOnFailure (ITestResult result) {//ITestResult is a TestNG class and need to import
	//Check the result status
	if (ITestResult.FAILURE==result.getStatus()) {//ITestResult is a listener class and it has so many methods
		try {
	//create reference of TakesScreenShot
		TakesScreenshot ts = (TakesScreenshot)driver;
	//call method to capture screen shot
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileHandler.copy(source, new File(screenShotsPath+result.getMethod().getMethodName()+".png"));//getting the failed method's name with .png
	 }catch (Exception e) {//Taking SS from the failed page
		 e.printStackTrace();//printing it
	 }
	}
 }
}
