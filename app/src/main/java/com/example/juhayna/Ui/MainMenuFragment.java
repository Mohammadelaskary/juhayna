package com.example.juhayna.Ui;

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
import com.example.juhayna.databinding.FragmentMainMenuBinding;


public class MainMenuFragment extends Fragment implements View.OnClickListener {


    public MainMenuFragment() {
        // Required empty public constructor
    }


    public static MainMenuFragment newInstance() {
        return new MainMenuFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    FragmentMainMenuBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainMenuBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonsToOnClickListener();
    }

    private void attachButtonsToOnClickListener() {
        binding.productionOrder.setOnClickListener(this);
        binding.warehouse.setOnClickListener(this);
        binding.picking.setOnClickListener(this);
        binding.shipping.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.showToolBar((MainActivity) getActivity());
        MyMethods.changeTitle("Main menu",(MainActivity) getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.production_order:
                Navigation.findNavController(v).navigate(R.id.action_mainMenuFragment_to_productionFragment);
                break;
            case R.id.warehouse:
                Navigation.findNavController(v).navigate(R.id.action_mainMenuFragment_to_warehouseFragment);
                break;
            case R.id.picking:
                Navigation.findNavController(v).navigate(R.id.action_mainMenuFragment_to_pickingFragment);
                break;
            case R.id.shipping:
                Navigation.findNavController(v).navigate(R.id.action_mainMenuFragment_to_shippingFragment);
                break;
        }
    }
}