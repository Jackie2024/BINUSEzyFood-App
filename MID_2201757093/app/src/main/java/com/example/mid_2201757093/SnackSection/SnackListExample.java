package com.example.mid_2201757093.SnackSection;

public class SnackListExample {
    private String mHarga;
    private String mButton;

    public SnackListExample(String button, String harga){
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
