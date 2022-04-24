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
import com.example.juhayna.ViewModel.StartShippingViewModel;
import com.example.juhayna.databinding.StartShippingFragmentBinding;

public class StartShippingFragment extends Fragment {

    private StartShippingViewModel viewModel;

    public static StartShippingFragment newInstance() {
        return new StartShippingFragment();
    }
    StartShippingFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = StartShippingFragmentBinding.inflate(inflater,container,false);
        return inflater.inflate(R.layout.start_shipping_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(StartShippingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.driverName.menu.setHint(R.string.driver_name);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle(getString(R.string.start_shipping),(MainActivity) getActivity());
    }
}