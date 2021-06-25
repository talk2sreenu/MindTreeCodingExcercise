package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredAPITest {
	
	@Test
	public void validateGetEmployeeData() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employee";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("ContentType", "application/json");
		Response res = httpRequest.get("/2");
		
		String employeeId = res.body().jsonPath().get("data.id").toString();
		String employeeName = res.body().jsonPath().get("data.employee_name").toString();
		String employeeSalary = res.body().jsonPath().get("data.employee_salary").toString();
		String employeeAge = res.body().jsonPath().get("data.employee_age").toString();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertNotNull(employeeId, "Employeed Id not fetched using Get method");	
		Assert.assertNotNull(employeeName, "Employeed Name not fetched using Get method");
		Assert.assertNotNull(employeeSalary, "Employeed Salary not fetched using Get method");
		Assert.assertNotNull(employeeAge, "Employeed Age not fetched using Get method");
	}
	
	@Test
	public void validateDeleteEmployeeData() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("ContentType", "application/json");
		Response res = httpRequest.delete("/delete/2");
		
		String delSuccessMessage = res.body().jsonPath().get("message").toString();
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(delSuccessMessage, "Successfully! Record has been deleted");			
	}
}
