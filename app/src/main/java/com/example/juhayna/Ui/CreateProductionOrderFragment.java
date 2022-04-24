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

import com.example.juhayna.ViewModel.CreateProductionOrderViewModel;
import com.example.juhayna.MyMethods.MyMethods;
import com.example.juhayna.R;
import com.example.juhayna.databinding.CreateProductionOrderFragmentBinding;

import java.util.Calendar;

public class CreateProductionOrderFragment extends Fragment implements View.OnClickListener {

    private CreateProductionOrderViewModel viewModel;

    public static CreateProductionOrderFragment newInstance() {
        return new CreateProductionOrderFragment();
    }
    CreateProductionOrderFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = CreateProductionOrderFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(CreateProductionOrderViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addTextAndHint();
        binding.date.getEditText().setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                showDatePicker();
        });
        binding.ordersList.setOnClickListener(this);
    }

    private void addTextAndHint() {
        binding.plant.barcodeInputLayout.setHint(getString(R.string.plant));
        binding.sku.menu.setHint(getString(R.string.sku));
        binding.orderType.menu.setHint(R.string.order_type);
        binding.productionLine.menu.setHint(R.string.production_line);
        binding.date.getEditText().setInputType(InputType.TYPE_NULL);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.date_edit_text:
                showDatePicker();
                break;
            case R.id.orders_list:
                Navigation.findNavController(v).navigate(R.id.action_createProductionOrderFragment_to_ordersListFragment);
                break;
        }
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), (view, year, month, dayOfMonth) -> {
            String date = dayOfMonth+"/"+(month+1)+"/"+year;
            binding.date.getEditText().setText(date);
            binding.orderType.menu.getEditText().requestFocus();
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle("Create Production Order",(MainActivity) getActivity());
    }
}