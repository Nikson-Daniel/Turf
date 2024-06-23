package com.theadvent.turf_dev.Data;

public class TransactionData {

    public String sNo, transactionId, turfName, price, status, date, time, timing;

    public TransactionData(String sNo, String transactionId, String turfName, String price, String status, String date, String time, String timing) {
        this.sNo = sNo;
        this.transactionId = transactionId;
        this.turfName = turfName;
        this.price = price;
        this.status = status;
        this.date = date;
        this.time = time;
        this.timing = timing;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTurfName() {
        return turfName;
    }

    public void setTurfName(String turfName) {
        this.turfName = turfName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }
}
