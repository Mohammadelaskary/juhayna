package com.example.juhayna.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.juhayna.Model.Picking;
import com.example.juhayna.databinding.ItemDescriptionLayoutBinding;

import java.util.List;

public class PickingShippingAdapter extends RecyclerView.Adapter<PickingShippingAdapter.PickingViewHolder> {
    List<Picking> pickingList;

    public PickingShippingAdapter(List<Picking> pickingList) {
        this.pickingList = pickingList;
    }

    @NonNull
    @Override
    public PickingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDescriptionLayoutBinding binding = ItemDescriptionLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new PickingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PickingViewHolder holder, int position) {
        Picking picking = pickingList.get(position);
        holder.binding.itemDescription.setText(picking.getItemDesc());
        holder.binding.units.barcodeInputLayout.getEditText().setText(String.valueOf(picking.getUnits()));
        holder.binding.cartons.barcodeInputLayout.getEditText().setText(String.valueOf(picking.getCartons()));
        holder.binding.pallet.barcodeInputLayout.getEditText().setText(String.valueOf(picking.getPallets()));
    }

    @Override
    public int getItemCount() {
        return pickingList==null?0: pickingList.size();
    }

    static class PickingViewHolder extends RecyclerView.ViewHolder {
        private ItemDescriptionLayoutBinding binding;
        public PickingViewHolder(@NonNull ItemDescriptionLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
