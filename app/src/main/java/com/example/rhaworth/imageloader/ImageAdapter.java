package com.example.rhaworth.imageloader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

/**
 * Created by RHaworth on 5/11/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> implements View.OnClickListener {

    private Context mContext;
    private LayoutInflater mInflater;
    private SearchResult mDataSource;

    public ImageAdapter(Context context, SearchResult result) {
        mContext = context;
        mDataSource = result;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, null);
        layoutView.setOnClickListener(this);
        return new ImageViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageSearchResult result = mDataSource.imageResults.get(position);
        holder.imageLabel.setText(result.title);
        holder.itemView.setTag(position);
        Glide.with((Activity)mContext).load(result.thumbnailURL).into(holder.thumbnailImageView);
    }

    @Override
    public int getItemCount() {
        return mDataSource.imageResults.size();
    }

    @Override
    public void onClick(View view) {
        int position = (int)view.getTag();
        Intent newIntent = new Intent(mContext, ImageActivity.class);
        newIntent.putExtra("url", mDataSource.imageResults.get(position).imageURL);
        mContext.startActivity(newIntent);
    }
}
