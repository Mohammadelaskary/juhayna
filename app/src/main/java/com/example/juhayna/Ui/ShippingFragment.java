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
import com.example.juhayna.Model.Picking;
import com.example.juhayna.Adapter.PickingShippingAdapter;
import com.example.juhayna.R;
import com.example.juhayna.ViewModel.ShippingViewModel;
import com.example.juhayna.databinding.ShippingFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class ShippingFragment extends Fragment implements View.OnClickListener {

    private ShippingViewModel viewModel;

    public static ShippingFragment newInstance() {
        return new ShippingFragment();
    }
    ShippingFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = ShippingFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(ShippingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonsToListener();
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
        binding.recyclerView.setAdapter(adapter);
    }
    private void attachButtonsToListener() {
        binding.startShipping.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle(getString(R.string.shipping),(MainActivity) getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_shipping:
                Navigation.findNavController(v).navigate(R.id.action_shippingFragment_to_startShippingFragment);
                break;
        }
    }
}