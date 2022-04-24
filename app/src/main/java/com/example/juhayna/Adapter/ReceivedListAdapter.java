package com.example.juhayna.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.juhayna.Model.WorkOrder;
import com.example.juhayna.databinding.ReceivedListItemBinding;

import java.util.List;

public class ReceivedListAdapter extends RecyclerView.Adapter<ReceivedListAdapter.ReceivedListViewHolder> {
    private List<WorkOrder> workOrders ;
    private Context context;

    public ReceivedListAdapter(List<WorkOrder> workOrders) {
        this.workOrders = workOrders;
    }

    @NonNull
    @Override
    public ReceivedListAdapter.ReceivedListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReceivedListItemBinding binding = ReceivedListItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ReceivedListViewHolder(binding);
    }
    private int clickedPosition = -1;
    @Override
    public void onBindViewHolder(@NonNull ReceivedListViewHolder holder, int position) {
        int currentPosition = position;
        WorkOrder workOrder = workOrders.get(currentPosition);
        holder.binding.orderNo.setText(String.valueOf(workOrder.getWorkOrderNo()));
        holder.binding.itemDescription.setText(workOrder.getItemDescription());
        holder.binding.pallets.barcodeInputLayout.getEditText().setText(String.valueOf(workOrder.getWorkOrderQty()));
        holder.binding.cartons.barcodeInputLayout.getEditText().setText(String.valueOf(workOrder.getReceivedQty()));
    }

    @Override
    public int getItemCount() {
        return workOrders==null?0: workOrders.size();
    }

    static class ReceivedListViewHolder extends RecyclerView.ViewHolder {
        private ReceivedListItemBinding binding;
        public ReceivedListViewHolder(@NonNull ReceivedListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
