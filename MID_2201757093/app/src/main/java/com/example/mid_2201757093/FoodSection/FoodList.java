package com.example.mid_2201757093.FoodSection;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mid_2201757093.OrderSection.OrderList;
import com.example.mid_2201757093.R;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FoodListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Context context;

    private GridLayoutManager gridLayoutManager;
    private ArrayList<FoodListExample> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        foodList = new ArrayList<>();
        addProductList();
        initialisation();
    }

    private void addProductList() {
        foodList.add(new FoodListExample("Nasgor", "15000"));
        foodList.add(new FoodListExample("Kai Fon", "25000"));
        foodList.add(new FoodListExample("Nasi Kuning", "10000"));
        foodList.add(new FoodListExample("Cap Cay", "25000"));
        foodList.add(new FoodListExample("Sop Bakso", "17000"));
        foodList.add(new FoodListExample("Soto Ayam", "18000"));
        foodList.add(new FoodListExample("Soto Daging", "20000"));
    }

    public void changeItem(int position, String text){
        foodList.get(position).changeText(text);
        mAdapter.notifyItemChanged(position);
    }

    private void initialisation() {
        gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView = findViewById(R.id.foodRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FoodListAdapter(foodList, this);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }
}
