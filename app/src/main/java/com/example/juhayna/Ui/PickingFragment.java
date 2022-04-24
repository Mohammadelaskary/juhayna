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
import com.example.juhayna.ViewModel.PickingViewModel;
import com.example.juhayna.R;
import com.example.juhayna.databinding.PickingFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class PickingFragment extends Fragment implements View.OnClickListener {

    private PickingViewModel viewModel;

    public static PickingFragment newInstance() {
        return new PickingFragment();
    }
    PickingFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = PickingFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PickingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addTextAndHint();
        attachButtonsToListener();
        addDummyData();
        setUpRecyclerView();
    }

    private void addDummyData() {
        Picking picking = new Picking("زبادي فواكه",100,20,3);
        Picking picking1 = new Picking("لبن رايب ",150,10,23);
        if (pickingList.isEmpty()) {
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

    }

    private void addTextAndHint() {
        binding.branch.menu.setHint(getString(R.string.branch));
        binding.startPicking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_picking:
                Navigation.findNavController(v).navigate(R.id.action_pickingFragment_to_startPickingFragment);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle(getString(R.string.picking),(MainActivity) getActivity());
    }
}