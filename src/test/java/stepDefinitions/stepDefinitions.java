package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class stepDefinitions {
	
	String URL = "http://localhost:3030/services";
	RequestSpecification request;
	Response response;

	@Given("Create service payload")
	public void create_service_payload() {
		
		request = given();
		request.header("content-type", "application/json");
		request.body("{\"name\": \"asian food court\"}");

	}

	@When("User calls API with POST request")
	public void user_calls_api_with_post_request() {

		response = request.post(URL);

	}

	@Then("API call is successful with status code {int}")
	public void api_call_is_successful_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 201);
		System.out.println((response.getStatusCode()));

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
		JsonPath js = new JsonPath(response.asString());
		assertEquals(js.getString("name"), "asian food court");
		js.prettyPrint();

	}

}
