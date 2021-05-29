package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UserCreate {//we don't extend this with AppInit Class instead I will create an object for this class inside our test class
//first we need to create a constructor for WebDriver driver. Then we will be able to locate all our elements by Page Factory Constructor
//The Name of constructor will be same name as the class name.
	WebDriver driver;//declared WebDriver variable and imported it
	public UserCreate (WebDriver d) {
		driver = d;//Now assigning the value for local variable d to the global variable driver
	}
	
	//We need to find element different way here, will follow a convention since we will use our Page Factory Constructor
	//Initially we used to find element like this--//WebElement we = driver.findElement(By.xpath("//a[contains (text(), 'Sign in')]"));
	//We will use FindBy Class, here "driver.findElement" means @FindBy and then will give the xpath and then below we will declare
	//an webelement variable which will contain the above xpath automatically. Here we want to click on SignIn link, enter email address
	//and then click on Create User Account. So I got all the required webElement's xpath here.
	
	@FindBy(xpath = "//a[contains (text(), 'Sign in')]")
	WebElement  signInLink;
	
	@FindBy(xpath = "//input[@id = 'email_create']")
	WebElement inputEmail;
	
	@FindBy(xpath = "//button[@id = 'SubmitCreate']")
	WebElement createAccoutnButton;
	//Now I will create a method to perform the action. But I need to do a validation. We will say if signInLink is not enabled print a 
	//message else we will click on signInLink, then enter email address on inputEmail and lastly click on createAccoutnButton.
	
	//WebElement for Create Account Page
	@FindBy(xpath ="//h1[@class=\"page-heading\"]")//better to take the test
	WebElement createAcctHeader;
	
	@FindBy(xpath = "//input[@id=\"id_gender1\"]")
	WebElement mTitleButton;
	
	@FindBy(xpath = "//input[@id=\"id_gender2\"]")
	WebElement fTitleButton;
	
	@FindBy(xpath = "//input[@id=\"customer_firstname\"]")
	WebElement fName1Box;
	
	@FindBy(xpath = "//input[@id=\"customer_lastname\"]")
	WebElement lName1Box;
	
	@FindBy(css="input#email")
	WebElement emailBox;
	
	@FindBy(css="input#passwdl")
	WebElement passWDBox;
	
	@FindBy(css="select#days")
	WebElement ddDays;
	
	@FindBy(css="select#months")
	WebElement ddMonths;
	
	@FindBy(css="select#years")
	WebElement ddYears;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement fName2Box;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lName2Box;
	
	@FindBy(xpath = "//input[@id='company']")
	WebElement companyBox;
	
	@FindBy(xpath = "//input[@id='address1']")
	WebElement address1Box;
	
	@FindBy(xpath = "//input[@id='address2']")
	WebElement address2Box;
	
	@FindBy(xpath = "//input[@id='city']")
	WebElement cityBox;
	
	@FindBy(xpath = "//select[@id='id_state']")
	WebElement ddStates;
	
	@FindBy(xpath = "//input[@id='postcode']")
	WebElement zipCdBox;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	WebElement mobileNBox;
	
	@FindBy(xpath = "//button[@name=\"submitAccount\"]")
	WebElement RegisterLink;
	
	//declare global parameter email here
	public void signInNewUser() {//pass the global parameter inside the parenthesis
		if (!signInLink.isEnabled()) {
			System.out.println("signInLink is not enabled!");
		}else {
			signInLink.click();
			inputEmail.sendKeys("naznin1234@gmail.com");//I need to use a global parameter here like email
			createAccoutnButton.click();
		}
	}

	
	public void adduserdetails(String title,String f1Name,String l1Name,String pwd,String day,String month,String year,String f2Name,String l2Name, 
			String company,String addLn1,String addLn2,String city,String state,String zip,String cell) throws InterruptedException {
		// add user details, first adding a verification of the page 
		if (createAcctHeader.isDisplayed()) {
			System.out.println("We are on the CREATE AN ACCOUNT page and we can enter our data here");
			Thread.sleep(2000);
			if (title.equalsIgnoreCase("F")) {
			fTitleButton.click();
			}else {
				mTitleButton.click();	
			}
			Thread.sleep(2000);
			fName1Box.sendKeys(f1Name);
			Thread.sleep(2000);
			lName1Box.sendKeys(l1Name);
			Thread.sleep(2000);
			//we will inspect the email address object and need to know how to get the value and then we can compare that value 
			//with our global variable email.
			passWDBox.sendKeys(pwd);
			Thread.sleep(2000);
			Select ddDay = new Select (ddDays);
			ddDay.selectByValue(day);
			Thread.sleep(2000);
			Select ddMonth = new Select (ddMonths);
			ddMonth.selectByVisibleText(month);
			Thread.sleep(2000);
			Select ddYear = new Select (ddYears);
			ddYear.selectByVisibleText(year);
			Thread.sleep(2000);
			fName2Box.sendKeys(f2Name);
			Thread.sleep(2000);
			lName2Box.sendKeys(l2Name);
			Thread.sleep(2000);
			companyBox.sendKeys(company);
			Thread.sleep(2000);
			address1Box.sendKeys(addLn1);
			Thread.sleep(2000);
			address2Box.sendKeys(addLn2);
			Thread.sleep(2000);
			cityBox.sendKeys(city);
			Thread.sleep(2000);
			Select ddState = new Select (ddStates);
			ddState.selectByVisibleText(state);
			Thread.sleep(2000);
			zipCdBox.sendKeys(zip);
			Thread.sleep(2000);
			mobileNBox.sendKeys(cell);
			Thread.sleep(2000);
			RegisterLink.click();
		}else {
			System.out.println("We are NOT on the CREATE AN ACCOUNT page.");
		}
	}

	
}
