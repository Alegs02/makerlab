package com.example.makerlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.example.makerlab.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)     {
        super.onViewCreated(view, savedInstanceState);

        JavClient J;
        J = new JavClient();
        J.initConBuffer();
        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.veryHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendHappy();
            }
        });

        binding.ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendOK();
            }
        });

        binding.alone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendAlone();
            }
        });

        binding.sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendSad();
            }
        });

        binding.book2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendBook();
            }
        });

        binding.fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendFitness();
            }
        });

        binding.emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                J.sendEmergency();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}