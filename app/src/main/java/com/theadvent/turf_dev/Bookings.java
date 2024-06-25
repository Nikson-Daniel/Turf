package com.theadvent.turf_dev;

import com.google.gson.annotations.SerializedName;

public class Bookings {
    @SerializedName("booking_id")
    private String bookingId;
    @SerializedName("turf_id")
    private String turfId;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("amount")
    private String amount;
    @SerializedName("status")
    private String status;
    @SerializedName("timing")
    private String timing;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("turf_name")
    private String turfName;

    // Getters and Setters


    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getTurfId() {
        return turfId;
    }

    public void setTurfId(String turfId) {
        this.turfId = turfId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTurfName() {
        return turfName;
    }

    public void setTurfName(String turfName) {
        this.turfName = turfName;
    }
}
