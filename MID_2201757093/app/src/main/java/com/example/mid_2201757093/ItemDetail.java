package com.example.mid_2201757093;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mid_2201757093.OrderSection.OrderCart;
import com.example.mid_2201757093.OrderSection.OrderList;

public class ItemDetail extends AppCompatActivity {
    TextView textView;
    TextView btnItem;
    String price;
    String item;
    int quantity;
    EditText quantityText;

    int basePrice;
    int totalPrice;
    String txtTotalPrice;

    public OrderCart cartSingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        textView = findViewById(R.id.txtPriceDetail);
        btnItem = findViewById(R.id.txtItemDetail);
        quantityText = (EditText) findViewById(R.id.txtQuantity);
        cartSingleton = new OrderCart().getInstance();
        getData();
    }

    private void getData(){
        if (getIntent().hasExtra("Price") && getIntent().hasExtra("Button")){
            price = getIntent().getStringExtra("Price");
            item = getIntent().getStringExtra("Button");
        }
        setData();
    }

    private void setData(){
        textView.setText(price);
        btnItem.setText(item);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }

    public void OrderNow(View view){
//        Intent order = new Intent(this, OrderList.class);
//        Toast.makeText(this, textView.getText(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, btnItem.getText(), Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, quantityText.getText(), Toast.LENGTH_SHORT).show();
//        order.putExtra("DrinkPrice", textView.getText().toString());
//        order.putExtra("DrinkName", btnItem.getText().toString());
//        order.putExtra("DrinkQuantity", quantityText.getText().toString());
//        startActivity(order);

        txtTotalPrice = String.valueOf(calculateTotal());
//        cartSingleton.mSingletonList.add(new OrderListExample(btnItem.getText().toString(),
//                quantityText.getText().toString(), textView.getText().toString(), txtTotalPrice));
//        cartSingleton.mSingletonList.add(new OrderListExample("","","",""));
//        cartSingleton.addNewOrder(btnItem.getText().toString(),
//                quantityText.getText().toString(), textView.getText().toString(), txtTotalPrice);

        cartSingleton.checkNewOrder(btnItem.getText().toString(),
                quantityText.getText().toString(), textView.getText().toString(), txtTotalPrice);
    }

    public int calculateTotal(){
        basePrice = Integer.parseInt(textView.getText().toString());
        quantity = Integer.parseInt(quantityText.getText().toString());
        totalPrice = basePrice * quantity;
        return totalPrice;
    }

    public void Return(View view){
        Intent returnNow = new Intent(this, MainActivity.class);
        startActivity(returnNow);
    }
}
