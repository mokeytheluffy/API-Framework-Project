package com.aniket.Pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class booking_response {


        @SerializedName("bookingid")
        @Expose
        private Integer bookingid;
        @SerializedName("booking")
        @Expose
        private booking booking;

        @SerializedName("bookingid")
        public Integer getBookingid() {
            return bookingid;
        }

        @SerializedName("bookingid")
        public void setBookingid(Integer bookingid) {
            this.bookingid = bookingid;
        }

        @SerializedName("booking")
        public booking getBooking() {
            return booking;
        }

        @SerializedName("booking")
        public void setBooking(booking booking) {
            this.booking = booking;
        }


}
