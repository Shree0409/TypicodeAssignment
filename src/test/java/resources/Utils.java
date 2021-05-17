package resources;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	
	public String globalProertiesPath = System.getProperty("user.dir")+"/src/test/java/resources/global.properties";

	public static int userId = 0;
	JSONArray responseArray;
	JSONObject responseObject;
	
	public static List<Integer> postIds = new ArrayList<Integer>();
	public static List<String> emailIdsInComments = new ArrayList<String>();
	public static List<String> invalidEmailIds = new ArrayList<String>();
	

	protected String getGlobalValue(String key) throws IOException {
		
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream(globalProertiesPath);
		prop.load(fis);
		return prop.getProperty(key);
		
	}
	
	private JSONArray getJsonArray(Response response) {

		String responseString = response.asString();
		responseArray = new JSONArray(responseString);
		return responseArray;

	}
	
	public boolean checkIfUserExists(String userName, Response response) {
		
		boolean userExists = false;
		
		getJsonArray(response);
		for (int i=0; i < responseArray.length(); i++) {
			responseObject = responseArray.getJSONObject(i);
			String actualUserName = responseObject.get("username").toString();
			if (actualUserName.equalsIgnoreCase(userName)) {
				userExists = true;
			}
			
		}
		return userExists;
		
	}
	
	public int getUserID(String userName, Response response) {
				
		getJsonArray(response);
		
		for (int i=0; i < responseArray.length(); i++) {
			responseObject = responseArray.getJSONObject(i);
			
			String actualUserName = responseObject.get("username").toString();
		
			if (actualUserName.equalsIgnoreCase(userName)) {
				userId = responseObject.getInt("id");
				break;
			}
		}
		
		return userId;
	}
	
	public List<Integer> getPostIds(int userid, Response response) {
		int postid;
		getJsonArray(response);
		
		for (int i=0; i < responseArray.length(); i++) {
			
			responseObject = responseArray.getJSONObject(i);
			
			if (responseObject.getInt("userId")==userid) {
				postid = responseObject.getInt("id");
				
				postIds.add(postid);
		
			}
			
		}
		return postIds;
	}

	
	public List<String> getEmailfromComments(Response response) {
		String emailId;
		getJsonArray(response);
		
		for (int i=0; i < responseArray.length(); i++) {
			
			responseObject = responseArray.getJSONObject(i);
					
				emailId = responseObject.get("email").toString();
				emailIdsInComments.add(emailId);			
			
		}

		return emailIdsInComments;
	}
	
	
    public boolean isValidEmailAddress(List<String> emailIdsInComments) {
    	
    	boolean validemailId = false;
    	String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    	
    	for (int i=0; i<emailIdsInComments.size(); i++) {
    		String email = emailIdsInComments.get(i);
    		Pattern p = Pattern.compile(ePattern);
            Matcher m = p.matcher(email);
            if(!(m.matches())) {
            	invalidEmailIds.add(email);
            }
    	}
    	
    	if(invalidEmailIds.size()==0) {
    		validemailId = true;
    	}
    	
    	
    	return validemailId;    
        
        
    }

	
	
}