package com.example.juhayna.Ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juhayna.MyMethods.MyMethods;
import com.example.juhayna.R;
import com.example.juhayna.ViewModel.SAPWorkOrderViewModel;
import com.example.juhayna.Model.WorkOrder;
import com.example.juhayna.Adapter.WorkOrderAdapter;
import com.example.juhayna.databinding.SAPWorkOrderFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class SAPWorkOrderFragment extends Fragment implements View.OnClickListener, WorkOrderAdapter.SetOnWorkOrderItemClicked {

    private SAPWorkOrderViewModel viewModel;

    public static SAPWorkOrderFragment newInstance() {
        return new SAPWorkOrderFragment();
    }
    SAPWorkOrderFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SAPWorkOrderFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SAPWorkOrderViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonsToListener();
        addDummyData();
        setUpRecyclerView();
    }

    private void addDummyData() {
        WorkOrder workOrder = new WorkOrder(1,"زبادو 250 جم", 500 , 300 , "زبادو1");
        WorkOrder workOrder1 = new WorkOrder(2,"زبادي فواكه 100 جم", 300 , 250 , "زبادي2");
        if (workOrders.isEmpty()) {
            workOrders.add(workOrder);
            workOrders.add(workOrder1);
        }
    }

    WorkOrderAdapter adapter;
    List<WorkOrder> workOrders = new ArrayList<>();
    private void setUpRecyclerView() {
        adapter = new WorkOrderAdapter(workOrders,this,getContext());
        binding.workOrderList.setAdapter(adapter);
    }

    private void attachButtonsToListener() {
        binding.startReceiving.setOnClickListener(this);
        binding.details.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("SAP Work order",(MainActivity) getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_receiving:
                if (selectedWorkOrder != null)
                    Navigation.findNavController(v).navigate(R.id.action_SAPWorkOrderFragment_to_SAPWorkListFragment);
                else
                    MyMethods.warningDialog(getContext(),"Please select work order!");
                break;
        }
    }
    WorkOrder selectedWorkOrder;
    @Override
    public void OnWorkOrderItemClicked(WorkOrder workOrder) {
        selectedWorkOrder = workOrder;
    }
}