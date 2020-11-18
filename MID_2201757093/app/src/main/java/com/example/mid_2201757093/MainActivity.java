package com.example.mid_2201757093;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mid_2201757093.DrinkSection.DrinkList;
import com.example.mid_2201757093.FoodSection.FoodList;
import com.example.mid_2201757093.OrderSection.OrderList;
import com.example.mid_2201757093.SnackSection.SnackList;
import com.example.mid_2201757093.TopUpSection.TopUpList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FoodSection(View view) {
        Intent intent = new Intent(this, FoodList.class);
        startActivity(intent);
    }

    public void OrderItem(View view) {
        Intent intent = new Intent(this, OrderList.class);
        startActivity(intent);
    }

    public void DrinkSection(View view) {
        Intent intent = new Intent(this, DrinkList.class);
        startActivity(intent);
    }

    public void SnackSection(View view) {
        Intent intent = new Intent(this, SnackList.class);
        startActivity(intent);
    }

    public void TopUpSection(View view) {
        Intent intent = new Intent(this, TopUpList.class);
        startActivity(intent);
    }
}