package com.example.mid_2201757093.OrderSection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mid_2201757093.R;

import java.util.ArrayList;

public class OrderResultAdapter extends RecyclerView.Adapter<OrderResultAdapter.OrderResultViewHolder> {
    private ArrayList<OrderListExample> mOrderList;
    private Context context;

    public static class OrderResultViewHolder extends RecyclerView.ViewHolder{
        public TextView mOrderList;
        public TextView mQuantity;
        public TextView mBasePrice;
        public TextView mTotalPrice;
        public ImageView mDelete;
        public OrderResultViewHolder(@NonNull View itemView) {
            super(itemView);
            mOrderList = itemView.findViewById(R.id.btnOrderList);
            mQuantity = itemView.findViewById(R.id.txtOrderQuantity);
            mBasePrice = itemView.findViewById(R.id.txtOrderDetailPrice);
            mTotalPrice = itemView.findViewById(R.id.txtTotal);
            mDelete = itemView.findViewById(R.id.btnDelete);
            mDelete.setVisibility(View.GONE);
        }
    }

    public OrderResultAdapter(ArrayList<OrderListExample> orderList, Context context){
        mOrderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_list_example, parent, false);
        OrderResultViewHolder ovh = new OrderResultViewHolder(v);
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderResultViewHolder holder, int position) {
        OrderListExample currentOrder = mOrderList.get(position);
        holder.mTotalPrice.setText(currentOrder.getmTotalPrice());
        holder.mQuantity.setText(currentOrder.getmQuantity());
        holder.mOrderList.setText(currentOrder.getmOrderList());
        holder.mBasePrice.setText(currentOrder.getmBasePrice());
    }

    @Override
    public int getItemCount() {
        return mOrderList.size();
    }
}
