package com.example.cobashop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobashop.Model.News;
import com.example.cobashop.Activity.NewsActivity;
import com.example.cobashop.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<News> newss;
    public NewsAdapter(ArrayList<News> newss) {
        this.newss = newss;
    }
    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher, parent, false);
        return new NewsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = newss.get(position);
        holder.IV_newsImg.setImageResource(news.getNews_img());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.context, NewsActivity.class);
            intent.putExtra("newss",news);
            holder.context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return newss.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView IV_newsImg;
        Context context;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_newsImg = itemView.findViewById(R.id.IV_newsItems);
            context = itemView.getContext();
        }
    }
}
