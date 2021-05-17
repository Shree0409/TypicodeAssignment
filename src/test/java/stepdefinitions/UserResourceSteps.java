package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import resources.APISpec;

public class UserResourceSteps extends APISpec {

	@Given("Build userList Payload")
	public void build_user_list_payload() throws IOException {
	   
		request=given().spec(requestSpecification());
	}
	
	@When("Get userid for the user {string} if present")
	public void the_user_is_present(String userName) {
		
		assertTrue(checkIfUserExists(userName, response));
		userId = getUserID(userName, response);
		
	}
	
}
