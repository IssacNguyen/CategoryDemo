package com.kevin.demoapp.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kevin.demoapp.model.CategoryResponse;
import com.kevin.demoapp.repository.CategoryRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class CategoryViewModel extends ViewModel {

    MutableLiveData<CategoryResponse> data = new MutableLiveData<>();

    private final CategoryRepository repository;

    @Inject
    public CategoryViewModel(CategoryRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<CategoryResponse> getData() {
        return data;
    }

    public void makeApiCall() {
        Call<CategoryResponse> call = repository.getAllCategories();
        call.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful()) {
                    data.postValue(response.body());
                    Log.d("ISSAC", response.body().toString());
                } else {
                    data.postValue(null);
                }
            }

            @Override
            public void onFailure(@NonNull Call<CategoryResponse> call, Throwable t) {
                data.postValue(null);
            }
        });
    }
}
