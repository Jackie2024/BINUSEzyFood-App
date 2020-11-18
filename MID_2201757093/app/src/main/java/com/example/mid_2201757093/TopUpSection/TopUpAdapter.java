package com.example.mid_2201757093.TopUpSection;

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

public class TopUpAdapter extends RecyclerView.Adapter<TopUpAdapter.TopUpViewHolder> {
    private ArrayList<TopUpExample> mTopUpList;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int Position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class TopUpViewHolder extends RecyclerView.ViewHolder{

        public Button mButton;
        public TextView mHarga;
        public TopUpViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btnTopUpList);
            mHarga = itemView.findViewById(R.id.txtTopUpList);
        }
    }

    public TopUpAdapter(ArrayList<TopUpExample> topUpList, Context context){
        mTopUpList = topUpList;
        this.context = context;
    }

    @NonNull
    @Override
    public TopUpViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_top_up_example, parent, false);
        TopUpViewHolder tuvh = new TopUpViewHolder(v);
        return tuvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TopUpViewHolder holder, int position) {
        TopUpExample currentItem = mTopUpList.get(position);
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
        return mTopUpList.size();
    }
}
