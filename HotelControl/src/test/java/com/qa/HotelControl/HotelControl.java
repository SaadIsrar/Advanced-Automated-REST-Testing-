package com.qa.HotelControl;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Validatable;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;



public class HotelControl {
private Response response;
private RequestSpecification request;

	
	//@Before
	//public void setup() {
		//response = request.get("http://localhost:8090/example/v1/hotels?page=0&size=100");
	//}
	
	@Test
	@Ignore
	public void getdata() {
		
		RestAssured.baseURI = ("http://localhost:8090/example/v1/hotels");
		RequestSpecification request = given().contentType(ContentType.JSON);
		JSONObject addata = new JSONObject();
		
		addata.put("city","Leeds");
		addata.put("description","Abc");
		addata.put("id",2);
		addata.put("name","Fozia");
		addata.put("rating",8.5);
		
		System.out.println(addata);
		request.body(addata.toString());
		
		Response response = request.post("http://localhost:8090/example/v1/hotels/");
		System.out.println(response.getStatusCode());
		//assertEquals(201, response.getStatusCode());
		
	}
	
	@Test
	@Ignore
	public void deletedata() {	
    request = given().contentType(ContentType.JSON);
	response = request.delete("http://localhost:8090/example/v1/hotels/2");
	}
	
	@Test
	public void updatedata() {
		request = given().contentType(ContentType.JSON);
		JSONObject changedata = new JSONObject();
		
		changedata.put("city","Cardiff");
		changedata.put("description","Bike");
		changedata.put("id",8);
		changedata.put("name","Smith");
		changedata.put("rating",6.5);
		
		request.body(changedata.toString());
		response = request.put("http://localhost:8090/example/v1/hotels/8");
		response = request.get("http://localhost:8090/example/v1/hotels/8");
		
		System.out.println("response:" + response.prettyPrint());
		
		System.out.println(response.getStatusCode());
		
	}
	
}
