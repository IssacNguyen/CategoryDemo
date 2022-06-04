package com.kevin.demoapp.repository;

import com.kevin.demoapp.model.CategoryResponse;
import com.kevin.demoapp.service.CategoryService;

import javax.inject.Inject;

import retrofit2.Call;

public class CategoryRepository {

    private final CategoryService service;

    @Inject
    public CategoryRepository(CategoryService service) {
        this.service = service;
    }

    public Call<CategoryResponse> getAllCategories() {
        return service.getAllCategories();
    }

}
