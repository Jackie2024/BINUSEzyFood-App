package com.example.mid_2201757093.DrinkSection;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mid_2201757093.ItemDetail;
import com.example.mid_2201757093.R;

import java.util.ArrayList;

public class DrinkListAdapter extends RecyclerView.Adapter<DrinkListAdapter.DrinkViewHolder> {
    private ArrayList<DrinkListExample> mDrinkList;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int Position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class DrinkViewHolder extends RecyclerView.ViewHolder{

        public Button mButton;
        public TextView mHarga;
        public DrinkViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btnDrinkList);
            mHarga = itemView.findViewById(R.id.txtDrinkList);
        }
    }

    public DrinkListAdapter(ArrayList<DrinkListExample> drinkList, Context context){
        mDrinkList = drinkList;
        this.context = context;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_drink_example, parent, false);
        DrinkViewHolder dvh = new DrinkViewHolder(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        DrinkListExample currentItem = mDrinkList.get(position);
        holder.mButton.setText(currentItem.getButton());
        holder.mHarga.setText(currentItem.getHarga());

        holder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ordering " + currentItem.getButton(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ItemDetail.class);
                intent.putExtra("Price", currentItem.getHarga());
                intent.putExtra("Button", currentItem.getButton());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDrinkList.size();
    }
}
