package com.olajideosho.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.olajideosho.cityguide.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewViewHolder> {
    ArrayList<FeaturedHelperClass> mostViewedLocations;

    public MostViewedAdapter(ArrayList<FeaturedHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public MostViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design, parent, false);
        MostViewViewHolder mostViewViewHolder = new MostViewViewHolder(view);
        return mostViewViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewViewHolder holder, int position) {
        FeaturedHelperClass mostViewed = mostViewedLocations.get(position);

        holder.image.setImageResource(mostViewed.getImage());
        holder.title.setText(mostViewed.getTitle());
        holder.desc.setText(mostViewed.getDescription());
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class MostViewViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, desc;

        public MostViewViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);
        }
    }
}
