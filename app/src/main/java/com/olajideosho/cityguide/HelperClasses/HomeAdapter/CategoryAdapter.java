package com.olajideosho.cityguide.HelperClasses.HomeAdapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.olajideosho.cityguide.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    ArrayList<FeaturedHelperClass> categoryList;

    public CategoryAdapter(ArrayList<FeaturedHelperClass> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(view);
        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        FeaturedHelperClass category = categoryList.get(position);

        holder.title.setText(category.getTitle());
        holder.image.setImageResource(category.getImage());
        holder.layout.setBackgroundColor(Color.parseColor(category.getColor()));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout layout;
        ImageView image;
        TextView title;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.categoryBackgroundLayout);
            image = itemView.findViewById(R.id.categoryImage);
            title = itemView.findViewById(R.id.categoryTitle);
        }
    }
}
