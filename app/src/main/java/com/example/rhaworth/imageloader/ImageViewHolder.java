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
//    public String imageURL;


    public ImageViewHolder(View itemView) {
        super(itemView);
        imageLabel = (TextView)itemView.findViewById(R.id.imageTitle);
        thumbnailImageView = (ImageView)itemView.findViewById(R.id.thumbnailImageView);
    }

//    @Override
//    public void onClick(View view) {
//        Log.d("ImageViewHolder", "clicked card for" + imageLabel.getText());
//        MainActivity activity = (MainActivity)view.getContext();
//        activity.showDetailActivity(imageURL);
////        Intent newIntent = new Intent((Activity)view.getContext(), ImageActivity.class);
//////        newIntent.putExtra()
//    }
}
