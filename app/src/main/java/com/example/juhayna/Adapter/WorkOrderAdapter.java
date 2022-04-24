package com.example.juhayna.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.juhayna.Model.WorkOrder;
import com.example.juhayna.databinding.WorkOrderItemBinding;

import java.util.List;

public class WorkOrderAdapter extends RecyclerView.Adapter<WorkOrderAdapter.WorkOrderViewHolder> {
    private List<WorkOrder> workOrders ;
    private SetOnWorkOrderItemClicked onWorkOrderItemClicked;
    private Context context;

    public WorkOrderAdapter(List<WorkOrder> workOrders,SetOnWorkOrderItemClicked onWorkOrderItemClicked,Context context) {
        this.workOrders = workOrders;
        this.onWorkOrderItemClicked = onWorkOrderItemClicked;
        this.context = context;
    }

    @NonNull
    @Override
    public WorkOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WorkOrderItemBinding binding = WorkOrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new WorkOrderViewHolder(binding);
    }
    private int clickedPosition = -1;
    @Override
    public void onBindViewHolder(@NonNull WorkOrderViewHolder holder, int position) {
        int currentPosition = position;
        WorkOrder workOrder = workOrders.get(currentPosition);
        holder.binding.workOrderNo.setText(String.valueOf(workOrder.getWorkOrderNo()));
        holder.binding.itemDescription.setText(workOrder.getItemDescription());
        holder.binding.workOrderQty.barcodeInputLayout.getEditText().setText(String.valueOf(workOrder.getWorkOrderQty()));
        holder.binding.receivedQty.barcodeInputLayout.getEditText().setText(String.valueOf(workOrder.getReceivedQty()));
        holder.binding.productionLine.setText(String.valueOf(workOrder.getProductionLine()));
        if (currentPosition == clickedPosition)
            activateItem(holder.binding.getRoot());
        else
            deactivateItem(holder.binding.getRoot());

        holder.itemView.setOnClickListener(v->{
            clickedPosition = currentPosition;
            onWorkOrderItemClicked.OnWorkOrderItemClicked(workOrder);
            notifyDataSetChanged();
        });
    }

    private void activateItem(View itemView) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f,1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(50);//duration in millisecond
        itemView.startAnimation(alphaAnimation);
    }

    private void deactivateItem(View itemView) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f,0.5f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(50);//duration in millisecond
        itemView.startAnimation(alphaAnimation);
    }


    @Override
    public int getItemCount() {
        return workOrders==null?0:workOrders.size();
    }

    static class WorkOrderViewHolder extends RecyclerView.ViewHolder{
        private WorkOrderItemBinding binding;
        public WorkOrderViewHolder(@NonNull WorkOrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.workOrderQty.barcodeInputLayout.setHint("Work Order Qty");
            binding.receivedQty.barcodeInputLayout.setHint("Received Qty");
        }
    }

   public interface SetOnWorkOrderItemClicked{
        void OnWorkOrderItemClicked(WorkOrder workOrder);
   }
}
