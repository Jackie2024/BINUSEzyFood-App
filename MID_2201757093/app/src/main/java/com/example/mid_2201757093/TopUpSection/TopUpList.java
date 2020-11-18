package com.example.mid_2201757093.TopUpSection;

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

public class TopUpList extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private TopUpAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Context context;

    private GridLayoutManager gridLayoutManager;
    private ArrayList<TopUpExample> topUpList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        topUpList = new ArrayList<>();
        addProductList();
        initialisation();
    }

    private void addProductList() {
        topUpList.add(new TopUpExample("Telkomsel1", "5000"));
        topUpList.add(new TopUpExample("Telkomsel2", "10000"));
        topUpList.add(new TopUpExample("Telkomsel3", "20000"));
        topUpList.add(new TopUpExample("Telkomsel4", "50000"));
        topUpList.add(new TopUpExample("XL1", "5000"));
        topUpList.add(new TopUpExample("XL2", "10000"));
        topUpList.add(new TopUpExample("XL3", "20000"));
        topUpList.add(new TopUpExample("XL4", "50000"));
        topUpList.add(new TopUpExample("Token1", "10000"));
        topUpList.add(new TopUpExample("Token2", "20000"));
        topUpList.add(new TopUpExample("Token3", "30000"));
        topUpList.add(new TopUpExample("Token4", "50000"));
        topUpList.add(new TopUpExample("Token5", "100000"));
        topUpList.add(new TopUpExample("Token6", "200000"));
        topUpList.add(new TopUpExample("Token7", "300000"));
    }

    public void changeItem(int position, String text){
        topUpList.get(position).changeText(text);
        mAdapter.notifyItemChanged(position);
    }

    private void initialisation() {
        gridLayoutManager = new GridLayoutManager(this, 2);

        mRecyclerView = findViewById(R.id.topUpRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new TopUpAdapter(topUpList, this);

        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }
}
