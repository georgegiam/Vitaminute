package com.example.vitaminute;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import javax.crypto.spec.PSource;

public class ImageAdapter extends BaseAdapter {

    // defining the Context
    private Context context;

    // creating an array with images
    public int[] imageArray = {
        R.drawable.im1, R.drawable.im2, R.drawable.im3,
            R.drawable.im4, R.drawable.im5, R.drawable.im6
    };

    // constructor
    public ImageAdapter(Context c) {
        context = c;
    }

    // returns the length of the array
    @Override
    public int getCount() {
        return imageArray.length;
    }

    // finding a specific item (image) in the array
    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }

    // getting a specific item's (image) id
    @Override
    public long getItemId(int position) {
        return 0;
    }

    // starting the full screen mode
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // creating an ImageView type object
        ImageView imageView = new ImageView(context);
        // getting image with specific id
        imageView.setImageResource(imageArray[position]);
        // placing image in center
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        // setting the full screen mode resolution
        imageView.setLayoutParams(new GridView.LayoutParams(340, 350));

        //returning the full screen image
        return imageView;
    }
}
