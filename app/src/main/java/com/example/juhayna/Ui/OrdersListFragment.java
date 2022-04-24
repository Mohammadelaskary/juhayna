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
import com.example.juhayna.Model.Order;
import com.example.juhayna.Adapter.OrdersAdapter;
import com.example.juhayna.ViewModel.OrdersListViewModel;
import com.example.juhayna.databinding.OrdersListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class OrdersListFragment extends Fragment {

    private OrdersListViewModel viewModel;

    public static OrdersListFragment newInstance() {
        return new OrdersListFragment();
    }
    OrdersListFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = OrdersListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(OrdersListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDummyData();
        setUpRecyclerView();
    }

    private void addDummyData() {
        Order order = new Order("plant1", "sku1", 20, "13/3/2022", "type1");
        Order order2 = new Order("plant2", "sku2", 50, "15/3/2022", "type2");
        if (orders.isEmpty()){
            orders.add(order);
            orders.add(order2);
        }
    }

    List<Order> orders = new ArrayList<>();
    OrdersAdapter adapter;
    private void setUpRecyclerView() {
        adapter = new OrdersAdapter(orders);
        binding.ordersList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("Orders List",(MainActivity) getActivity());
    }
}