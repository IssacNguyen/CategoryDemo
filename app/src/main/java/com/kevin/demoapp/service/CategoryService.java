package com.kevin.demoapp.service;

import com.kevin.demoapp.model.CategoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {

    @GET("categories.php")
    Call<CategoryResponse> getAllCategories();

}
