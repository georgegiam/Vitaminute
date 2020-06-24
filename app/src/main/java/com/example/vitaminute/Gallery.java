package com.example.vitaminute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Gallery extends AppCompatActivity {

    // defining the GridView
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // linking variables with the ids
        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // calling the FullScreenActivity
                Intent intent = new Intent(getApplicationContext(), FullScreenActivity.class);
                // using the position in the array
                intent.putExtra("id", position);
                // starting the activity
                startActivity(intent);
            }
        });
    }
}
