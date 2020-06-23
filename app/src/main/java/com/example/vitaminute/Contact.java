package com.example.vitaminute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact extends AppCompatActivity {

    private TextView header;
    EditText name, surname , email, phone;
    Button save;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        header = (TextView) findViewById(R.id.header_text);
        header.setText("We are always open to personal questions or everything you want to share with us. You can communicate with us by submitting the form below.");

        name = (EditText) findViewById(R.id.name_editText);
        surname = (EditText) findViewById(R.id.surname_editText);
        email = (EditText) findViewById(R.id.email_editText);
        phone = (EditText) findViewById(R.id.phone_editText);
        save = (Button) findViewById(R.id.save_button);
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });
    }

    public void addUser () {
        String nameValue = name.getText().toString();
        String surnameValue = surname.getText().toString();
        String emailValue = email.getText().toString();
        String phoneValue = phone.getText().toString();

        if (!TextUtils.isEmpty(nameValue) && !TextUtils.isEmpty(surnameValue) &&!TextUtils.isEmpty(emailValue) &&!TextUtils.isEmpty(phoneValue)) {

            Users users = new Users(nameValue, surnameValue, emailValue ,phoneValue);
            databaseReference.push().setValue(users);
            name.setText("");
            surname.setText("");
            email.setText("");
            phone.setText("");
        }

    }
}
