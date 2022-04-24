package com.example.juhayna.Ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juhayna.R;
import com.example.juhayna.databinding.FragmentProductionBinding;

public class ProductionFragment extends Fragment implements View.OnClickListener {


    public ProductionFragment() {
        // Required empty public constructor
    }


    public static ProductionFragment newInstance() {
        return new ProductionFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentProductionBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductionBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonsToListener();
    }

    private void attachButtonsToListener() {
        binding.createProductionOrder.setOnClickListener(this);
        binding.receiveProductionOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.create_production_order:
                Navigation.findNavController(v).navigate(R.id.action_productionFragment_to_createProductionOrderFragment);
                break;
            case R.id.receive_production_order:
                Navigation.findNavController(v).navigate(R.id.action_productionFragment_to_SAPWorkOrderFragment2);
                break;
        }
    }
}