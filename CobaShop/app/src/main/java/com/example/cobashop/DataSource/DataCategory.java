package com.example.cobashop.DataSource;

import com.example.cobashop.Model.Category;
import com.example.cobashop.R;

import java.util.ArrayList;

public class DataCategory {
    public static ArrayList<Category> categories = generateDummyCategory();

    private static ArrayList<Category> generateDummyCategory() {
        ArrayList<Category> categories1 = new ArrayList<>();
        categories1.add(new Category("beauty", R.drawable.beauty));
        categories1.add(new Category("fragrances", R.drawable.fregrance));
        categories1.add(new Category("furniture", R.drawable.furniture));
        categories1.add(new Category("groceries", R.drawable.grocery));
        return categories1;
    }
}
