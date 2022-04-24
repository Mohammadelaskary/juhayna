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
import com.example.juhayna.ViewModel.StartPickingViewModel;
import com.example.juhayna.databinding.StartPickingFragmentBinding;

public class StartPickingFragment extends Fragment {

    private StartPickingViewModel viewModel;

    public static StartPickingFragment newInstance() {
        return new StartPickingFragment();
    }
    StartPickingFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = StartPickingFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(StartPickingViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.pickingList.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_startPickingFragment_to_pickingListFragment);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.changeTitle(getActivity().getString(R.string.start_picking),(MainActivity) getActivity());
    }
}