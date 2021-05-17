package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Then;
import resources.APISpec;

public class CommentsResourceSteps extends APISpec {
	
	@Then("Build comments payload with postId")
	public void build_comments_payload_with_postid() throws IOException {
	    
		request=given().spec(requestSpecification().queryParam("postId", postIds));
	   
	}

	@Then("Validate the email IDs in the comments")
	public void validate_the_email_ids_in_the_comments() {
		
		getEmailfromComments(response);
		assertTrue(emailIdsInComments.size()!=0);
		isValidEmailAddress(emailIdsInComments);
		
	}



}
