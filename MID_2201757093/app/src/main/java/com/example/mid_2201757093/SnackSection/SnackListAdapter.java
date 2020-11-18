package com.example.mid_2201757093.SnackSection;

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

public class SnackListAdapter extends RecyclerView.Adapter<SnackListAdapter.SnackViewHolder>{
    private ArrayList<SnackListExample> mSnackList;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onItemClick(int Position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class SnackViewHolder extends RecyclerView.ViewHolder{

        public Button mButton;
        public TextView mHarga;
        public SnackViewHolder(@NonNull View itemView) {
            super(itemView);
            mButton = itemView.findViewById(R.id.btnSnackList);
            mHarga = itemView.findViewById(R.id.txtSnackList);
        }
    }

    public SnackListAdapter(ArrayList<SnackListExample> snackList, Context context){
        mSnackList = snackList;
        this.context = context;
    }

    @NonNull
    @Override
    public SnackListAdapter.SnackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_snack_example, parent, false);
        SnackViewHolder svh = new SnackViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SnackViewHolder holder, int position) {
        SnackListExample currentItem = mSnackList.get(position);
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
        return mSnackList.size();
    }
}
