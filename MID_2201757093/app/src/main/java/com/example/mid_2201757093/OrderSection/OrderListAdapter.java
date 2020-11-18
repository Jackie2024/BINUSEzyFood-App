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

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {
    private ArrayList<OrderListExample> mOrderList;
    private OnItemClickListener mListener;
    private Context context;

    public interface OnItemClickListener{
        void onDeleteClick(int Position);
    }

    public void setOnItemClickListener(OrderListAdapter.OnItemClickListener listener){
        mListener = listener;
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{
        public TextView mOrderList;
        public TextView mQuantity;
        public TextView mBasePrice;
        public TextView mTotalPrice;
        public ImageView mDelete;
        public OrderViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mOrderList = itemView.findViewById(R.id.btnOrderList);
            mQuantity = itemView.findViewById(R.id.txtOrderQuantity);
            mBasePrice = itemView.findViewById(R.id.txtOrderDetailPrice);
            mTotalPrice = itemView.findViewById(R.id.txtTotal);
            mDelete = itemView.findViewById(R.id.btnDelete);

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }
    }

    public OrderListAdapter(ArrayList<OrderListExample> orderList, Context context){
        mOrderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_order_list_example, parent, false);
        OrderViewHolder ovh = new OrderViewHolder(v, mListener);
        return ovh;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderListExample currentOrder = mOrderList.get(position);
//        int basePrice = Integer.parseInt(currentOrder.getmBasePrice());
//        int quantity = Integer.parseInt(currentOrder.getmQuantity());
//        int totalPrice = basePrice * quantity;
//        String txtTotalPrice = Integer.toString(totalPrice);

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
