package com.example.cobashop.API;

import com.example.cobashop.Model.Category;
import com.example.cobashop.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("products")
    Call<List<Product>> getProducts();

    @GET("categories")
    Call<List<Category>> getCategories();
}


