package com.example.juhayna.Ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.juhayna.MyMethods.MyMethods;
import com.example.juhayna.R;
import com.example.juhayna.databinding.FragmentSplashBinding;


public class SplashFragment extends Fragment {


    public SplashFragment() {
        // Required empty public constructor
    }

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    FragmentSplashBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Animation logoAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_in);
        binding.logo.startAnimation(logoAnimation);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                binding.poweredBy.setVisibility(View.VISIBLE);
                binding.gbsLogo.setVisibility(View.VISIBLE);
            }
        }, 1100);
        final Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Navigation.findNavController(getView()).navigate(R.id.action_splashFragment_to_signInFragment);
            }
        }, 2000);
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMethods.hideToolBar((MainActivity) getActivity());
    }
}