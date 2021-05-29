package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AppInit extends DriverBase{//extended with DriverBase since launchBrowser is in this class
 @BeforeClass
 public void initBeforeClass() throws InterruptedException {//launching browser before the test class
	 /* Invoke Launch Browser */
		launchBrowser("Chrome", "http://automationpractice.com/index.php"); 
        }
 @AfterMethod
 public void initAfterMethod(ITestResult result) {//getting Screen shots whenever it fails after running the Test class
	 //Capture screen shot on failure
	 captureScreenshotsOnFailure(result);
      }
 @AfterClass
 public void initAfterClass() throws Exception {//will run after method and will kill drivers and browsers
	//Kill all the browsers and drivers
	 killBrowsers();
   }
}
