package com.example.vitaminute;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact extends AppCompatActivity {

    // defining the TextView
    TextView header;
    // defining the EditText
    EditText name, surname , email, phone;
    // defining the Button
    Button save;
    // defining the database reference
    DatabaseReference ref;
    // defining a User type object
    Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);



        // linking variables with the ids
        header = (TextView) findViewById(R.id.header_text);
        name = (EditText) findViewById(R.id.name_editText);
        surname = (EditText) findViewById(R.id.surname_editText);
        email = (EditText) findViewById(R.id.email_editText);
        phone = (EditText) findViewById(R.id.phone_editText);
        save = (Button) findViewById(R.id.save_button);

        // setting the short description
        header.setText("We are always open to personal questions or everything you want to share with " +
                "us. Leave your info below and we will reach you out as soon as possible");

        // creating a Users object
        user = new Users();
        // reference to the "Users" table in the database
        ref = FirebaseDatabase.getInstance().getReference().child("Users");

        // action when the "save" button is clicked
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting user values from the input fields
                // getting the name value from the input field and convert to string
                String nameValue = name.getText().toString();
                // getting the surname value from the input field and convert to string
                String surnameValue = surname.getText().toString();
                // getting the phone value from the input field and convert to string
                String phoneValue = phone.getText().toString();
                // getting the email value from the input field and convert to string
                String emailValue = email.getText().toString();

                // set input fields warning if the user hasn't provide all the required information
                // user hasn't provide the name
                if (nameValue.isEmpty()){
                    // setting an error message
                    name.setError("Please provide your name");
                    // creating a red border to the name input field
                    name.requestFocus();
                }
                // user hasn't provide the surname
                else if (surnameValue.isEmpty()){
                    // setting an error message
                    surname.setError("Please provide your surname");
                    // creating a red border to the surname input field
                    surname.requestFocus();
                }
                // user hasn't provide the phone
                else if (phoneValue.isEmpty()){
                    // setting an error message
                    phone.setError("Please provide your phone");
                    // creating a red border to the phone input field
                    phone.requestFocus();
                }
                // user hasn't provide the email
                else if (emailValue.isEmpty()){
                    // setting an error message
                    email.setError("Please provide your email");
                    // creating a red border to the email input field
                    email.requestFocus();
                }
                // user has provide all the required information
                else {
                    // setting user object variables
                    // setting the name variable
                    user.setName(nameValue);
                    // setting the surname variable
                    user.setSurname(surnameValue);
                    // setting the phone variable
                    user.setPhone(phoneValue);
                    // setting the email variable
                    user.setEmail(emailValue);

                    // push data to the database
                    ref.push().setValue(user);

                    // display a success message
                    Toast.makeText(Contact.this, "Your data saved successfully.", Toast.LENGTH_LONG).show();

                    // clear input fields
                    name.setText("");
                    surname.setText("");
                    phone.setText("");
                    email.setText("");
                }
            }
        });
    }
}
