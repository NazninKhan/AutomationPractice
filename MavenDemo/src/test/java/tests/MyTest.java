package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import common.AppInit;
import pages.UserCreate;
//Run all the test from here
public class MyTest extends AppInit{//extended with AppInit Class and imported it since all our browser, driver info and before and after
	//methods are here
	
	UserCreate userCreateObj;//declaring a global variable userCreateObj for UserCreate class so we can use it from other methods and importing it
   //Now I need to create an object for the UserCreate class, usually we used to create object inside our main method, but in TestNG
	//we don't have any main method. So we will first create a method and then will create object there. We will use our driver constructor
	//here from our UserCreate class
   @Test
	public void createObject () {
	userCreateObj = PageFactory.initElements(driver, UserCreate.class);//PageFactory is a class and here we are using PF to initialize
	//the constructor driver which is on our UserCreate Class. So here UserCreate Class was identified by the constructor driver. Now for
	//all other page class we will create those will be identified by this driver constructor, this is called PF
  }
   //We can run and debug from here
   @Test
	public void createUser() {
		userCreateObj.signInNewUser();//calling signInNewUser method from UserCreate class using userCreateObj
		System.out.println("Laboni is silent today");
		System.out.println("This is a change from local repo ");
		System.out.println("Adding a line from Github");

	}
   
   @Test
   public void adduser() {
		  
   }

}
