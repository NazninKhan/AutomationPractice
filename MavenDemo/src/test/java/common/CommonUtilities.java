package common;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class CommonUtilities {
	public String currDirectory = new File(System.getProperty("user.dir")).getAbsolutePath();//getting the path of current directory
	//which is project path. Here user.dir is a keyword from Selenium which means a directory under the project. getAbsolutePath is 
	//a method in our File class and it will get the path for our current directory.
	//C:\Users\sak37\eclipse-workspace\MavenDemo//this is my path for current directory
	public String screenShotsPath = currDirectory+File.separator+"screenshots"+File.separator;//Want to save the path some where. 
	//Here I am saving this under current directory,"File.separator" means "/" and "screenshots" is a folder name where I want to 
	//save my screen shots, "screenshots" is a folder name not file name because file name has an extension in it like .png/.doc
	//C:\Users\sak37\eclipse-workspace\MavenDemo\screenshots\--here I am adding a folder named screenshots in my current directory
	/**
	 * Capturing Screen shot and saving it in the project path
	 * @param driver
	 * @param screenshotFileName
	 * @throws IOException
	 */
	public void captureScreenShot(WebDriver driver, String screenshotFileName) throws IOException {//when we will call this method
		//we only need to put the screenshotFileName parameter value, we don't need to give driver value
		TakesScreenshot ss = (TakesScreenshot)driver;//TypeCasting 
		File screenShotFile = ss.getScreenshotAs(OutputType.FILE);//getting SS as File type and saving it in a memory location
		FileHandler.copy(screenShotFile, new File(screenShotsPath+screenshotFileName+".png"));//using FileHandler class to copy the SS
		//from source to target. screenShotFile is our source where we are getting the SS and we are saving it under current directory
		// and giving that path "screenShotsPath", created a variable called screenshotFileName, so when ever I will call this method
		//to take and save a screen shot I will give the screenshotFileName as a parameter and ".png" is the file type 
		//C:\Users\sak37\eclipse-workspace\MavenDemo\screenshots\screenshotFileName.png--here I am saving it with a file name and 
		//file type under screenshots folder under my current directory.
	}
	/**
	 * Method to bring element into view
	 * @param driver
	 * @param element
	 */
 public void getElementScrollIntoView (WebDriver driver, WebElement element) {//created Parameter for driver and one for webelement
	 //when we call this method will put the parameter element value since every time it could be different element we are looking for
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView;", element);
 }
  /**
   * Method to kill all Browsers and drivers
   * @throws Exception
   */
 public void killBrowsers() throws Exception {
		
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe *32");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe  *32");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe *32");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe  *32");
	}

}
