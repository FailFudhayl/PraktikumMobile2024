package com.example.cobashop.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Category implements Parcelable {
    private String category;
    private int category_img;

    protected Category(Parcel in) {
        category = in.readString();
        category_img = in.readInt();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_img() {
        return category_img;
    }

    public void setCategory_img(int category_img) {
        this.category_img = category_img;
    }

    public Category(String category, int category_img) {
        this.category = category;
        this.category_img = category_img;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(category);
        parcel.writeInt(category_img);
    }
}
