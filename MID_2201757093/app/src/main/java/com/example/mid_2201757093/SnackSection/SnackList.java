package com.example.mid_2201757093.SnackSection;

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

public class SnackList extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SnackListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Context context;

    private GridLayoutManager gridLayoutManager;
    private ArrayList<SnackListExample> snackList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        snackList = new ArrayList<>();
        addProductList();
        initialisation();
    }

    private void addProductList() {
        snackList.add(new SnackListExample("Kentang Goreng", "8000"));
        snackList.add(new SnackListExample("Ubi Goreng", "5000"));
        snackList.add(new SnackListExample("Jamur Goreng", "10000"));
        snackList.add(new SnackListExample("Pisang Goreng", "1500"));
        snackList.add(new SnackListExample("Sukun Goreng", "2000"));
        snackList.add(new SnackListExample("Apam Pinang", "5000"));
        snackList.add(new SnackListExample("Martabak", "25000"));
        snackList.add(new SnackListExample("Ice Cream", "5000"));
        snackList.add(new SnackListExample("Burger", "15000"));
        snackList.add(new SnackListExample("Sushi", "28000"));
        snackList.add(new SnackListExample("Ubi Rebus", "8000"));
        snackList.add(new SnackListExample("Bakso Goreng", "5000"));
        snackList.add(new SnackListExample("Sosis Goreng", "2000"));
        snackList.add(new SnackListExample("Tepung Goreng", "5000"));
    }

    public void changeItem(int position, String text){
        snackList.get(position).changeText(text);
        mAdapter.notifyItemChanged(position);
    }

    private void initialisation() {
        gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView = findViewById(R.id.snackRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SnackListAdapter(snackList, this);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }
}
