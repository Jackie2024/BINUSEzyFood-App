package com.example.mid_2201757093.FoodSection;

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

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>{
    private ArrayList<FoodListExample> mFoodList;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int Position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder{

        public Button mButton;
        public TextView mHarga;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btnFoodList);
            mHarga = itemView.findViewById(R.id.txtFoodList);
        }
    }

    public FoodListAdapter(ArrayList<FoodListExample> foodList, Context context){
        mFoodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_food_example, parent, false);
        FoodViewHolder fvh = new FoodViewHolder(v);
        return fvh;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        FoodListExample currentItem = mFoodList.get(position);
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
        return mFoodList.size();
    }
}
