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
import com.example.juhayna.ViewModel.WarehouseReceivingViewModel;
import com.example.juhayna.databinding.WarehouseReceivingFragmentBinding;

public class WarehouseReceivingFragment extends Fragment implements View.OnClickListener {

    private WarehouseReceivingViewModel viewModel;

    public static WarehouseReceivingFragment newInstance() {
        return new WarehouseReceivingFragment();
    }
    WarehouseReceivingFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = WarehouseReceivingFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WarehouseReceivingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTextAndHint();
        attachButtonsToListeners();
    }

    private void attachButtonsToListeners() {
        binding.receivedList.setOnClickListener(this);
    }

    private void setTextAndHint() {
        binding.palletCode.barcodeInputLayout.setHint("Pallet code");
//        binding.qtyData.pallet.barcodeInputLayout.setHint("Pallet");
//        binding.qtyData.units.barcodeInputLayout.setHint("Units");
//        binding.qtyData.cartons.barcodeInputLayout.setHint("Cartons");
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("Warehouse Receiving",(MainActivity) getActivity());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.received_list:
                Navigation.findNavController(v).navigate(R.id.action_warehouseReceivingFragment_to_receivedListFragment);
                break;
        }
    }
}