package com.example.mid_2201757093.TopUpSection;

public class TopUpExample {
    private String mHarga;
    private String mButton;

    public TopUpExample(String button, String harga){
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
