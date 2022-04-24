package com.example.juhayna.Ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juhayna.MyMethods.MyMethods;
import com.example.juhayna.R;
import com.example.juhayna.Adapter.ReceivedListAdapter;
import com.example.juhayna.ViewModel.ReceivedListViewModel;
import com.example.juhayna.Model.WorkOrder;
import com.example.juhayna.databinding.ReceivedListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class ReceivedListFragment extends Fragment {

    private ReceivedListViewModel viewModel;

    public static ReceivedListFragment newInstance() {
        return new ReceivedListFragment();
    }
    ReceivedListFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ReceivedListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ReceivedListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        editTextAndHint();
        addDummyData();
        setUpRecyclerView();

    }
    ReceivedListAdapter adapter;
    private void setUpRecyclerView() {
        adapter = new ReceivedListAdapter(workOrders);
        binding.list.setAdapter(adapter);
    }

    List<WorkOrder> workOrders = new ArrayList<>();
    private void addDummyData() {
        WorkOrder workOrder = new WorkOrder(1,"زبادو 250 جم", 500 , 300 , "زبادو1");
        WorkOrder workOrder1 = new WorkOrder(2,"زبادي فواكه 100 جم", 300 , 250 , "زبادي2");
        if (workOrders.isEmpty()) {
            workOrders.add(workOrder);
            workOrders.add(workOrder1);
        }
    }

//    private void editTextAndHint() {
//        binding.palletCode.barcodeInputLayout.setHint("Code");
//    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle(getActivity().getString(R.string.received_list),(MainActivity) getActivity());
    }
}