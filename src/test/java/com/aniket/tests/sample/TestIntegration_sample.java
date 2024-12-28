package com.aniket.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegration_sample {

    //Create a booking, Create a token
    // Get Booking
    //Update the booking
    //Delete the booking
    @Test(groups = "QA", priority = 1)
    @Owner("Aniket")
    @Description("Step1 ---- Verify that the booking is been created")

    public void test_create_booking(){
        Assert.assertTrue(true);
    }

    @Test (groups = "QA", priority = 2)
    @Owner("Aniket")
    @Description("Step2 ---- Verify that the booking by ID")

    public void test_verify_bookingId(){
        Assert.assertTrue(true);
    }

    @Test (groups = "QA", priority = 3)
    @Owner("Aniket")
    @Description("Step3 ---- Verify Updating the booking by ID")

    public void test_verify_Updating_bookingId(){
        Assert.assertTrue(true);
    }


    @Test (groups = "QA", priority = 4)
    @Owner("Aniket")
    @Description("Step4 ---- Verify Deleting the booking by ID")

    public void test_verify_Deleting_bookingId(){
        Assert.assertTrue(true);
    }





}
