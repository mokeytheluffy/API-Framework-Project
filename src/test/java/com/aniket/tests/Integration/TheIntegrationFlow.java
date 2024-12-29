package com.aniket.tests.Integration;

import com.aniket.Pojos.booking;
import com.aniket.Pojos.booking_response;
import com.aniket.base.BaseTest;
import com.aniket.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class TheIntegrationFlow extends BaseTest {

    //The Integration Scenarios 1

    //1. Create a Booking ----- BookingId
    //2. Need to get the token
    //3. Verify that the creat booking is working fine-- Get request for booking Id
    //4. Update the booking (bookingId,Token) --- Need to get the token, booking Id from above Request
    //5. Delete booking ID --- Need to get the token, booking Id from above request token

    @Test(groups = {"integration", "P0"}, priority = 1)
    @Owner("Aniket")
    @Description(" Step1- Verify that the booking can be created")
    public void testCreateBooking(ITestContext iTestContext) { // interface
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.CreatPayloadBookingAsString()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        booking_response bookingResponse = payloadManager.bookingResponseJava(response.asString());
        //assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Aniket");
        System.out.println(bookingResponse.getBookingid());
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }

//----------------------------------------------------------------------//


    @Test(groups = "QA", priority = 2)
    @Owner("Aniket")
    @Description("Step2 ---- Verify that the booking by ID")

    public void test_verify_bookingId(ITestContext iTestContext) {
        System.out.println(iTestContext.getAttribute("bookingid"));

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        //Get Request -- to verify that the first name after creation is Jeams
        String basePathGET = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathGET);

        requestSpecification.basePath(basePathGET);
        response = RestAssured.given(requestSpecification).when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Assert.assertTrue(true);
        booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotEmpty().isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("James");
    }


//------------------------------------------------------------//


    @Test(groups = "QA", priority = 3)
    @Owner("Aniket")
    @Description("Step3 ---- Verify Updating the booking by ID")

    public void test_verify_Updating_bookingId(ITestContext iTestContext) {
        System.out.println(iTestContext.getAttribute("bookingid"));
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = get_token();
        iTestContext.setAttribute("token", token);

        String basePathPUTandPATCH = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathPUTandPATCH);
        requestSpecification.basePath(basePathPUTandPATCH);
        response = RestAssured.given(requestSpecification).cookies("token", token).when().body(payloadManager.fullBodyPayloadAsString()).put();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isEqualTo("Aniket");
        assertThat(booking.getLastname()).isEqualTo("Jadhav");
        assertThat(booking.getFirstname()).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertTrue(true);
    }


//-----------------------------------------------------//


    @Test(groups = "QA", priority = 4)
    @Owner("Aniket")
    @Description("Step4 ---- Verify Deleting the booking by ID")

    public void test_verify_Deleting_bookingId(ITestContext iTestContext) {
        System.out.println(iTestContext.getAttribute("bookingid"));
        System.out.println(iTestContext.getAttribute("token"));

        String token = (String) iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePathDELETE = APIConstants.CREATE_UPDATE_BOOKING_URL + "/" + bookingid;
        System.out.println(basePathDELETE);

        requestSpecification.basePath(basePathDELETE);
        response = RestAssured.given(requestSpecification).when().delete();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);
        Assert.assertTrue(true);

    }

}
