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
import com.example.juhayna.ViewModel.PutAwayViewModel;
import com.example.juhayna.R;
import com.example.juhayna.databinding.PutAwayFragmentBinding;

public class PutAwayFragment extends Fragment {

    private PutAwayViewModel viewModel;

    public static PutAwayFragment newInstance() {
        return new PutAwayFragment();
    }
    PutAwayFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = PutAwayFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PutAwayViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.palletCode.barcodeInputLayout.setHint(getString(R.string.pallet_code));
//        binding.qtyData.pallet.barcodeInputLayout.setHint(getString(R.string.pallets));
//        binding.qtyData.units.barcodeInputLayout.setHint(getString(R.string.units));
//        binding.qtyData.cartons.barcodeInputLayout.setHint(getString(R.string.cartons));
        binding.pinCode.barcodeInputLayout.setHint(getString(R.string.location_code));
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("Put-away",(MainActivity) getActivity());
    }
}