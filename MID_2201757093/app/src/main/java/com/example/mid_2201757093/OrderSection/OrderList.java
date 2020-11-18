package com.example.mid_2201757093.OrderSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mid_2201757093.MainActivity;
import com.example.mid_2201757093.R;

import java.util.ArrayList;

public class OrderList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private OrderListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView emptyRecycler;
    private ArrayList<OrderListExample> orderList;
//    private Cart myCart = new Cart().getInstance(orderList);

    public OrderCart myCart;

    private String DrinkPrice = "0";
    private String DrinkName;
    private String DrinkQuantity ="0";

    int basePrice;
    int quantity;
    int totalPrice;

    TextView EmptyText1;
    TextView EmptyText2;
    Button EmptyButton;
    TextView txtTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        myCart = new OrderCart().getInstance();
        txtTotalPrice = findViewById(R.id.OrderTotalPrice);
        initialisation();
        txtTotalPrice.setText(myCart.totalPrice());
        checkOrder();
    }

    public void checkOrder(){
        if(myCart.cartSize() == 0){
            EmptyText1 = findViewById(R.id.EmptyText1);
            EmptyText2 = findViewById(R.id.EmptyText2);
            EmptyButton = (Button) findViewById(R.id.btnEmptyPost);
            emptyRecycler = findViewById(R.id.recyclerViewOrder);
            setButtonVisibility();
        }
    }

    public void setButtonVisibility(){
        EmptyText1.setVisibility(View.VISIBLE);
        EmptyText2.setVisibility(View.VISIBLE);
        EmptyButton.setVisibility(View.VISIBLE);
        emptyRecycler.setVisibility(View.INVISIBLE);
    }

//    private void addNewOrder(String DrinkName, String DrinkQuantity, String DrinkPrice, String PriceTotal) {
//        orderList.add(new OrderListExample(DrinkName,DrinkQuantity, DrinkPrice, PriceTotal));
//    }

//    private void getData(){
//        if (getIntent().hasExtra("DrinkPrice") && getIntent().hasExtra("DrinkName") && getIntent().hasExtra("DrinkQuantity")){
//            DrinkPrice = getIntent().getStringExtra("DrinkPrice");
//            DrinkName = getIntent().getStringExtra("DrinkName");
//            DrinkQuantity = getIntent().getStringExtra("DrinkQuantity");
//        }
//    }

    public int calculateTotal(){
        basePrice = Integer.parseInt(DrinkPrice);
        quantity = Integer.parseInt(DrinkQuantity);
        totalPrice = basePrice * quantity;
        return totalPrice;
    }

    public void removeOrder(int Position){
        myCart.getmMyCart().remove(Position);
        mAdapter.notifyItemRemoved(Position);
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        startActivity(intent);
//        recreate();
    }

    public void initialisation(){
        mRecyclerView = findViewById(R.id.recyclerViewOrder);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new OrderListAdapter(myCart.getmMyCart(), this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OrderListAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int Position) {
                removeOrder(Position);
            }
        });
    }

    public void PayNow(View view) {
        if(myCart.cartSize() == 0){
            Toast.makeText(this, "Keranjangnya masih Kosong!", Toast.LENGTH_LONG).show();
        }
        else{
            Intent payNow = new Intent(this, OrderResult.class);
            startActivity(payNow);
        }
    }

    public void Return(View view){
        Intent returnNow = new Intent(this, MainActivity.class);
        startActivity(returnNow);
    }
}