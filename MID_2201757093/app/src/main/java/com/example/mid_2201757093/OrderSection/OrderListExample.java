package com.example.mid_2201757093.OrderSection;


public class OrderListExample {
    public String mOrderList;
    public String mQuantity;
    public String mBasePrice;
    public String mTotalPrice;

    public OrderListExample(String mOrderList, String mQuantity, String mBasePrice, String mTotalPrice) {
        this.mOrderList = mOrderList;
        this.mQuantity = mQuantity;
        this.mBasePrice = mBasePrice;
        this.mTotalPrice = mTotalPrice;
    }

    public String getmOrderList() {
        return mOrderList;
    }

    public void setmOrderList(String mOrderList) {
        this.mOrderList = mOrderList;
    }

    public String getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(String mQuantity) {
        this.mQuantity = mQuantity;
    }

    public String getmBasePrice() {
        return mBasePrice;
    }

    public void setmBasePrice(String mBasePrice) {
        this.mBasePrice = mBasePrice;
    }

    public String getmTotalPrice() {
        return mTotalPrice;
    }

    public void setmTotalPrice(String mTotalPrice) {
        this.mTotalPrice = mTotalPrice;
    }
}
