package com.aniket.base;

import com.aniket.asserts.AssertActions;
import com.aniket.endpoints.APIConstants;
import com.aniket.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // Common to all test-Cases
    // BAse URL, Content type--JSON--common

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public ValidatableResponse validatableResponse;
    public Response response;

    @BeforeTest
    public void setUp() {
        //Base URL , Content type JSON

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        // requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).contentType(ContentType.JSON).log().all();
// above was the one way and below is the other way ---- both of them we can use
        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL).addHeader("Content-Type", "application/json").build().log().all();


    }

    public String get_token() {
        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).basePath(APIConstants.AUTH_URL);

//Setting the payload
        String payload = payloadManager.SetAuthPayload();


//Get the Token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
        String token = payloadManager.getToken(response.asString());
        return token;

    }
}
