package com.example.mid_2201757093.DrinkSection;

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

public class DrinkList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DrinkListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Context context;

    private GridLayoutManager gridLayoutManager;
    private ArrayList<DrinkListExample> drinkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        drinkList = new ArrayList<>();
        addProductList();
        initialisation();
    }

    private void addProductList() {
        drinkList.add(new DrinkListExample("Cha Siet", "5000"));
        drinkList.add(new DrinkListExample("Air Mineral", "5000"));
        drinkList.add(new DrinkListExample("Jus Apel", "15000"));
        drinkList.add(new DrinkListExample("Jus Jeruk", "15000"));
        drinkList.add(new DrinkListExample("Jus Alpukat", "23000"));
        drinkList.add(new DrinkListExample("Jus Mangga", "17000"));
        drinkList.add(new DrinkListExample("Boba Milk", "25000"));
        drinkList.add(new DrinkListExample("Boba Choco", "27000"));
        drinkList.add(new DrinkListExample("Boba Matcha", "30000"));
        drinkList.add(new DrinkListExample("Boba Taro", "28000"));
        drinkList.add(new DrinkListExample("Boba Vegan", "29000"));
        drinkList.add(new DrinkListExample("Theu FuSui", "5000"));
        drinkList.add(new DrinkListExample("Son Kit", "6000"));
        drinkList.add(new DrinkListExample("FIJI Water", "45000"));
        drinkList.add(new DrinkListExample("Vegan Water", "20000"));
    }

    public void changeItem(int position, String text){
        drinkList.get(position).changeText(text);
        mAdapter.notifyItemChanged(position);
    }

    private void initialisation() {
        gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new DrinkListAdapter(drinkList, this);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }
}
