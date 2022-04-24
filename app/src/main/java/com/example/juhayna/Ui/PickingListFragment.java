package com.example.juhayna.Ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juhayna.Model.Picking;
import com.example.juhayna.ViewModel.PickingListViewModel;
import com.example.juhayna.Adapter.PickingShippingAdapter;
import com.example.juhayna.databinding.PickingListFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class PickingListFragment extends Fragment {

    private PickingListViewModel mViewModel;

    public static PickingListFragment newInstance() {
        return new PickingListFragment();
    }
    PickingListFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = PickingListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PickingListViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addDummyData();
        setUpRecyclerView();
    }

    private void addDummyData() {
        Picking picking = new Picking("زبادي فواكه",100,20,3);
        Picking picking1 = new Picking("لبن رايب ",150,10,23);
        if (pickingList.isEmpty()){
            pickingList.add(picking);
            pickingList.add(picking1);
        }
    }

    List<Picking> pickingList = new ArrayList<>();
    PickingShippingAdapter adapter;
    private void setUpRecyclerView() {
        adapter = new PickingShippingAdapter(pickingList);
        binding.pickingList.setAdapter(adapter);
    }
}