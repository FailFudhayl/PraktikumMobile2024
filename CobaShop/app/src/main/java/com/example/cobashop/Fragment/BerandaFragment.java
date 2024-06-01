package com.example.cobashop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobashop.Adapter.CategoryAdapter;
import com.example.cobashop.Adapter.NewsAdapter;
import com.example.cobashop.DataSource.DataCategory;
import com.example.cobashop.DataSource.DataNews;
import com.example.cobashop.R;

public class BerandaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvNews = view.findViewById(R.id.recyclerView_current_news);
        rvNews.setHasFixedSize(true);
        NewsAdapter newsAdapter = new NewsAdapter(DataNews.newss);
        rvNews.setAdapter(newsAdapter);

        RecyclerView rvCategory = view.findViewById(R.id.recyclerView_categories);
        rvCategory.setHasFixedSize(true);
        CategoryAdapter categoryAdapter = new CategoryAdapter(DataCategory.categories);
        rvCategory.setAdapter(categoryAdapter);
    }
}