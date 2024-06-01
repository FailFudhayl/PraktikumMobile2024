package com.example.cobashop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cobashop.Activity.CategoryActivity;
import com.example.cobashop.Model.Category;
import com.example.cobashop.R;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<Category> categories;
    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Category category = categories.get(position);
        holder.IV_categoryImg.setImageResource(category.getCategory_img());
        holder.TV_categoryTitle.setText(category.getCategory());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.context, CategoryActivity.class);
            intent.putExtra("categoryName", category.getCategory());
            holder.context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView IV_categoryImg;
        TextView TV_categoryTitle;
        Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            IV_categoryImg = itemView.findViewById(R.id.IV_CategoryImage);
            TV_categoryTitle = itemView.findViewById(R.id.TV_CategoryName);
            context = itemView.getContext();
        }
    }

}
