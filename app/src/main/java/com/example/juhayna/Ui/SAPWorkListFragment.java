package com.example.juhayna.Ui;

import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.juhayna.MyMethods.MyMethods;
import com.example.juhayna.R;
import com.example.juhayna.ViewModel.SAPWorkListViewModel;
import com.example.juhayna.databinding.SAPWorkListFragmentBinding;

import java.util.Calendar;

public class SAPWorkListFragment extends Fragment implements View.OnClickListener {

    private SAPWorkListViewModel viewModel;
    private SAPWorkListFragmentBinding binding;
    public static SAPWorkListFragment newInstance() {
        return new SAPWorkListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SAPWorkListFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SAPWorkListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTextAndHint();
        attachButtonToListeners();
    }

    private void attachButtonToListeners() {
        binding.receivedList.setOnClickListener(this);
    }

    private void setTextAndHint() {
        binding.palletCode.barcodeInputLayout.setHint("Pallet Code");
//        binding.skuCode.barcodeInputLayout.setHint("Sku Code");
//        binding.pallet.barcodeInputLayout.setHint("Pallet");
//        binding.units.barcodeInputLayout.setHint("Units");
//        binding.date.getEditText().setInputType(InputType.TYPE_NULL);
//        binding.date.getEditText().setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("SAP Work List",(MainActivity) getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.received_list:
                Navigation.findNavController(v).navigate(R.id.action_SAPWorkListFragment_to_receivedListFragment);
                break;
            case R.id.date:
                showDatePickerDialog();
                break;
        }
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth+"/"+(month+1)+"/"+year;
//            binding.date.getEditText().setText(date);
//            binding.skuCode.barcodeInputLayout.getEditText().requestFocus();
        },calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.MONTH),calendar.get(Calendar.YEAR));
        datePickerDialog.show();
    }
}