package apiAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;//typing it here to bring the static method RestAssured.

public class reqres_Automation {
	@Test//imported Test annotations
	
	public void base () {
	//int statusCode=RestAssured.given().get("https://reqres.in/api/users/2").getStatusCode();//given is a method for request specification and get is the 
	//response and we are asking to get the status code and putting this into an INT variable. Using endpoint to retrieve list user
	int statusCode=given().get("https://reqres.in/api/users?page=2").getStatusCode();//removed RestAssured since we created a static method
	System.out.println("The status code: "+statusCode);
	}
	
	@Test
	public void info () {
	Response myInfo=given().log().all().get("https://reqres.in/api/users?page=2");//Response data type we will use when we
	//will get any info as a return. need to import Response from rest assured. Once we created rest assured we don't need to use
	//the syntax RestAssured here. Importing static method for RestAssured on the top. Any method we put in Static we don't need to 
	//write or use this syntax. So we will not use RestAssured here, will start with given.
	myInfo.prettyPrint();//for response data type we use pretty print as print statement 
		
		}

}
