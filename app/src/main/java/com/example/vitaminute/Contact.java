package com.example.vitaminute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Contact extends AppCompatActivity {

    private TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        header = (TextView) findViewById(R.id.header_text);
        header.setText("We are always open to personal questions or everything you want to share with us. You can communicate with us by submiting the form below.");

    }
}
