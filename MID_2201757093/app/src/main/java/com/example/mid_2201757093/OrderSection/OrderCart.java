package com.example.mid_2201757093.OrderSection;

import java.util.ArrayList;

public class OrderCart {
    private static OrderCart order;
    public ArrayList<OrderListExample> mMyCart = new ArrayList<>();

    private int totalPrice = 0;
    private int basePrice = 0;
    private int baseQuantity = 0;
    private int totalSinglePrice = 0;

    public OrderCart(){};

    public static OrderCart getInstance(){
        if(order == null){
            order = new OrderCart();
        }
        return order;
    }

    public ArrayList<OrderListExample> getmMyCart() {
        return mMyCart;
    }

    public void setmMyCart(ArrayList<OrderListExample> mMyCart) {
        this.mMyCart = mMyCart;
    }

    public void addNewOrder(String DrinkName, String DrinkQuantity, String DrinkPrice, String PriceTotal){
        mMyCart.add(new OrderListExample(DrinkName, DrinkQuantity, DrinkPrice, PriceTotal));
    }

    public int cartSize(){
        return mMyCart.size();
    }

    public String totalPrice(){
        resetPrice();
        if(cartSize() == 0) return "0";
        else{
            for (int a = 0 ; a < cartSize() ; a++){
                totalPrice += calculateTotalPrice(a);
            }
            return String.valueOf(totalPrice);
        }
    }

    private void resetPrice(){
        totalPrice = 0;
        basePrice = 0;
        baseQuantity = 0;
        totalSinglePrice = 0;
    }

    private int calculateTotalPrice(int a){
        resetPrice();
        basePrice = Integer.parseInt(mMyCart.get(a).getmBasePrice());
        baseQuantity = Integer.parseInt(mMyCart.get(a).getmQuantity());
        totalSinglePrice = basePrice * baseQuantity;
        return totalSinglePrice;
    }

    public void checkNewOrder(String DrinkName, String DrinkQuantity, String DrinkPrice, String PriceTotal){
        boolean flag = true;
        if(cartSize() == 0) addNewOrder(DrinkName, DrinkQuantity, DrinkPrice, PriceTotal);
        else{
            for (int a = 0; a < cartSize() ; a++){
                if (flag == false) break;
                if(mMyCart.get(a).getmOrderList().equals(DrinkName)){
                    int quantity = Integer.parseInt(mMyCart.get(a).getmQuantity()) + Integer.parseInt(DrinkQuantity);
                    String txtQuantity = String.valueOf(quantity);
                    mMyCart.get(a).setmQuantity(txtQuantity);
                    mMyCart.get(a).setmTotalPrice(String.valueOf(calculateTotalPrice(a)));
                    flag = false;
                }
            }
            if(flag == true) addNewOrder(DrinkName, DrinkQuantity, DrinkPrice, PriceTotal);
        }
    }

    public void EmptyCart(){
        mMyCart.clear();
    }
}
