package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.APISpec;
import resources.Utils;

public class CommonSteps extends APISpec{
	

	@When("Hit the resource {string} with {string} Http request")
	public void hit_the_resource_with_http_request(String resource, String method) {
		
		APIResources resourceAPI=APIResources.valueOf(resource);
	
		//resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();		
		
		response =request.when().get(resourceAPI.getResource());
		
	}
	
}
