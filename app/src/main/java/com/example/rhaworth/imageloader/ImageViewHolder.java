package com.example.rhaworth.imageloader;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by RHaworth on 5/12/17.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    public TextView imageLabel;
    public ImageView thumbnailImageView;

    public ImageViewHolder(View itemView) {
        super(itemView);
        imageLabel = (TextView)itemView.findViewById(R.id.imageTitle);
        thumbnailImageView = (ImageView)itemView.findViewById(R.id.thumbnailImageView);
    }
}
