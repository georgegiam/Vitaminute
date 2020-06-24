package com.example.vitaminute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class FullScreenActivity extends AppCompatActivity {

    // defining the ImageView
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        // creating an Intent type object
        Intent i = getIntent();

        // defining the position of the image (the position inside the array)
        int position = i.getExtras().getInt("id");
        // creating an ImageArray type object
        ImageAdapter imageAdapter = new ImageAdapter(this);
        // linking image with the id
        imageView = (ImageView) findViewById(R.id.image_view);
        // setting the image's position in the array
        imageView.setImageResource(imageAdapter.imageArray[position]);
    }
}
