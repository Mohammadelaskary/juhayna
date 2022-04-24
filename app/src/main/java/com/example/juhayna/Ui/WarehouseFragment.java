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

import com.example.juhayna.R;
import com.example.juhayna.ViewModel.WarehouseViewModel;
import com.example.juhayna.databinding.WarehouseFragmentBinding;

public class WarehouseFragment extends Fragment implements View.OnClickListener {

    private WarehouseViewModel viewModel;

    public static WarehouseFragment newInstance() {
        return new WarehouseFragment();
    }
    private WarehouseFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = WarehouseFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WarehouseViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonsToListener();
    }

    private void attachButtonsToListener() {
        binding.receiving.setOnClickListener(this);
        binding.putAway.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.receiving:
                Navigation.findNavController(v).navigate(R.id.action_warehouseFragment_to_warehouseReceivingFragment);
                break;
            case R.id.put_away:
                Navigation.findNavController(v).navigate(R.id.action_warehouseFragment_to_putAwayFragment);
                break;
        }
    }
}