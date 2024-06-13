package com.example.cobashop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobashop.Adapter.TokoAdapter;
import com.example.cobashop.DataSource.DataNews;
import com.example.cobashop.R;


public class toko_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toko, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvToko = view.findViewById(R.id.rv_toko);
        rvToko.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rvToko.setLayoutManager(linearLayoutManager);
        TokoAdapter tokoAdapter = new TokoAdapter(DataNews.newss);
        rvToko.setAdapter(tokoAdapter);
    }
}