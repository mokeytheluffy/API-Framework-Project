package com.aniket.modules;

import com.aniket.Pojos.*;
import com.google.gson.Gson;

public class PayloadManager {
    // Converting the Java object to the String
    Gson gson;
    public String CreatPayloadBookingAsString() {

        booking booking1 = new booking();
        booking1.setFirstname("Sakshi");
        booking1.setLastname("Jadhav");
        booking1.setTotalprice(111);
        booking1.setDepositpaid(true);

        bookingdates bookingdate1 = new bookingdates();
        bookingdate1.setCheckin("2018-01-01");
        bookingdate1.setCheckout("2019-01-01");

        booking1.setbookingdates(bookingdate1);
        booking1.setAdtionalneeds("Breakfast");

        System.out.println(booking1);
        gson = new Gson();
        String json = gson.toJson(booking1);
        System.out.println(json);
        return json;






    }
    // Converting the String to the Java Object

    public booking getResponseFromJSON(String getResponse){
        Gson gson =  new Gson();
        booking booking =gson.fromJson(getResponse,booking.class);
        return booking;
    }


    // Converting the Java Object to String

    public booking_response bookingResponseJava( String responsestring){
        gson = new Gson();
        booking_response bookingResponse= gson.fromJson(responsestring, booking_response.class);
        return bookingResponse;
    }

    //Java to JSON

    public String SetAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("Admin");
        auth.setPassword("password123");
        // Convert to string
        Gson gson = new Gson();
        String json = gson.toJson(auth);
        System.out.println("Payload set to be" + json);
        return json;
    }

// JSON to JAVA
    public String getToken( String responsetoken){
        gson = new Gson();
        TokenResponse token_reponse =  gson.fromJson(responsetoken, TokenResponse.class);
        return token_reponse.getToken(); // get token will generate the token
    }




    //Update
    public String fullBodyPayloadAsString(){
        booking booking1 = new booking();
        booking1.setFirstname("Aniket");
        booking1.setLastname("Jadhav");
        booking1.setTotalprice(111);
        booking1.setDepositpaid(true);

        bookingdates bookingdate1 = new bookingdates();
        bookingdate1.setCheckin("2018-01-01");
        bookingdate1.setCheckout("2019-01-01");

        booking1.setbookingdates(bookingdate1);
        booking1.setAdtionalneeds("Breakfast");
        return gson.toJson(booking1);
    }



}

