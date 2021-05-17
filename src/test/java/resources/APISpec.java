package resources;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APISpec extends Utils{

	public static Response response;
	public static RequestSpecification request;
	public static ResponseSpecification resspec;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(request==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		request = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		
		 return request;
		}
		return request;
		
	}
	
	public ResponseSpecification responseSpecification() {
		
		resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		return resspec;
		
	}
	
	
	
}
