package com.example.juhayna.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.juhayna.Model.Order;
import com.example.juhayna.databinding.OrderItemBinding;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {
    private List<Order> orders;

    public OrdersAdapter(List<Order> orders) {
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemBinding binding = OrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new OrdersViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {
        Order order = orders.get(position);
        holder.binding.plant.setText(order.getPlant());
        holder.binding.orderType.setText(order.getOrderType());
    }

    @Override
    public int getItemCount() {
        return orders==null?0: orders.size();
    }

    static class OrdersViewHolder extends RecyclerView.ViewHolder {
        private OrderItemBinding binding;
        public OrdersViewHolder(@NonNull OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
