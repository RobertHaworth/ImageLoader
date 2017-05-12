package com.example.rhaworth.imageloader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by RHaworth on 5/12/17.
 */

public class ImageActivity extends Activity {


    ImageView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_view);
        Intent intent = getIntent();

        view = (ImageView) findViewById(R.id.imageView);

        String url = intent.getStringExtra("url");

        Glide.with(this).load(url).into(view);
    }
}
