package com.aniket.modules;

import com.aniket.Pojos.booking_response;
import com.aniket.Pojos.bookingdates;
import com.google.gson.Gson;
import com.aniket.Pojos.booking;
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

        // Converting the String to the Java Object

        public booking_response bookingResponseJava(String responsestring){
            gson = new Gson();
            booking_response bookingResponse= gson.fromJson(responsestring, booking_response.class);
            return bookingResponse.toString();
        }



    }
}

