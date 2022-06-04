package com.kevin.demoapp.model;

import java.util.ArrayList;

public class CategoryResponse {
    private ArrayList<Category> categories;

    public CategoryResponse(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "categories=" + categories +
                '}';
    }
}
