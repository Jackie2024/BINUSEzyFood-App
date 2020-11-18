package com.example.mid_2201757093.DrinkSection;


public class DrinkListExample {
    private String mHarga;
    private String mButton;

    public DrinkListExample(String button, String harga){
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
