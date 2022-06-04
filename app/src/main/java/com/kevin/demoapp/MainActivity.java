package com.kevin.demoapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.kevin.demoapp.databinding.ActivityMainBinding;
import com.kevin.demoapp.viewmodel.CategoryViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViewModel();
    }

    private void initViewModel() {
        CategoryViewModel viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        viewModel.makeApiCall();
        viewModel.getData().observe(this, categoryResponse -> {
            if (categoryResponse != null) {
                binding.text.setText(categoryResponse.toString());
            }
        });
    }
}