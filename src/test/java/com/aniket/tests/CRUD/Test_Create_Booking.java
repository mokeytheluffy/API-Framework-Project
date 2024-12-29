package com.aniket.tests.CRUD;

import com.aniket.Pojos.booking_response;
import com.aniket.base.BaseTest;
import com.aniket.endpoints.APIConstants;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_Create_Booking extends BaseTest {

    @Owner("Aniket")
    @TmsLink("")
    @Link()
    @Issue("")
    @Description("Verify that POST request is working fine")
    @Test
    public void testVerifyCreatBookingPOST01(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.CreatPayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        booking_response bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Aniket");
    }

}
