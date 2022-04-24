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
import com.example.juhayna.ViewModel.SignInViewModel;
import com.example.juhayna.databinding.SignInFragmentBinding;

public class SignInFragment extends Fragment implements View.OnClickListener {

    private SignInViewModel viewModel;

    public static SignInFragment newInstance() {
        return new SignInFragment();
    }
    SignInFragmentBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = SignInFragmentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        attachButtonToListener();
    }

    private void attachButtonToListener() {
        binding.signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in:
                Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_mainMenuFragment);
                break;
        }
    }
}