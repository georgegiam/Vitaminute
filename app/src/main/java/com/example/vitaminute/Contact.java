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

    private TextView header;
    EditText name, surname , email, phone;
    Button save;
    DatabaseReference ref;
    Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        header = (TextView) findViewById(R.id.header_text);
        header.setText("We are always open to personal questions or everything you want to share with us. Leave your info below and we will reach you out as soon as possible");

        name = (EditText) findViewById(R.id.name_editText);
        surname = (EditText) findViewById(R.id.surname_editText);
        email = (EditText) findViewById(R.id.email_editText);
        phone = (EditText) findViewById(R.id.phone_editText);
        save = (Button) findViewById(R.id.save_button);

        // creating a Users object
        user = new Users();
        // reference to the "Users" table in the database
        ref = FirebaseDatabase.getInstance().getReference().child("Users");

        // action when the "save" button is clicked
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // getting user values from the input fields
                String nameValue = name.getText().toString();
                String surnameValue = surname.getText().toString();
                String phoneValue = phone.getText().toString();
                String emailValue = email.getText().toString();

                // set input fields warning if the user hasn't provide all the required information
                // user hasn't provide the name
                if (nameValue.isEmpty()){
                    name.setError("Please provide your name");
                    name.requestFocus();
                }
                // user hasn't provide the surname
                else if (surnameValue.isEmpty()){
                    surname.setError("Please provide your surname");
                    surname.requestFocus();
                }
                // user hasn't provide the phone
                else if (phoneValue.isEmpty()){
                    phone.setError("Please provide your phone");
                    phone.requestFocus();
                }
                // user hasn't provide the email
                else if (emailValue.isEmpty()){
                    email.setError("Please provide your email");
                    email.requestFocus();
                }
                // user has provide all the required information
                else {
                    user.setName(nameValue);
                    user.setSurname(surnameValue);
                    user.setPhone(phoneValue);
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
