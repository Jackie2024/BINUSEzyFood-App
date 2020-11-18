package com.example.mid_2201757093.FoodSection;

public class FoodListExample {
    private String mHarga;
    private String mButton;

    public FoodListExample(String button, String harga){
        mButton = button;
        mHarga = harga;
    }

    public void changeText(String text){
        mHarga = text;
    }

    public String getHarga(){
        return mHarga;
    }

    public String getButton(){
        return mButton;
    }
}
