package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Then;
import resources.APISpec;

public class PostResourceSteps extends APISpec {
	
	@Then("Build posts payload with userid")
	public void build_posts_payload_with_userid() throws IOException {
	    
		request=given().spec(requestSpecification().queryParam("userId", userId));
	   
	}

	@Then("Extract the postIds")
	public void extract_the_post_ids() {
	    
		getPostIds(userId, response);
		assertTrue(postIds.size()!=0);
		
	}

}
