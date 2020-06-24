package com.example.vitaminute;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Bmi extends AppCompatActivity {

    // defining the radio group
    RadioGroup radioGroup;
    // defining the radio buttons (male and female)
    RadioButton male, female;
    // defining the EditText (weight and height)
    private EditText height, weight;
    // defining the calculate button
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        // linking variables with the ids
        radioGroup = (RadioGroup) findViewById(R.id.gender_radio_group);
        male = (RadioButton) findViewById(R.id.male_radio);
        female = (RadioButton) findViewById(R.id.female_radio);
        height = (EditText) findViewById(R.id.height_editText);
        weight = (EditText) findViewById(R.id.weight_editText);

        calculate = (Button) findViewById(R.id.calc_btn);

        // trigger the calculate button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking the value of the radio group
                int gen = radioGroup.getCheckedRadioButtonId();

                // case no radio button selected
                if (gen == -1)
                    // no gender selected
                    Toast.makeText(getApplicationContext(), "Please select gender", Toast.LENGTH_LONG);
                // case one of two radio buttons selected
                else
                    // call the calculate function
                    calculateBmi(gen);
            }
        });
    }

    // calculate function
    public void calculateBmi(int gen) {
        // getting height and weight values form the input fields (casted to String)
        // getting the height value from the input field and convert to string
        String heightValue = height.getText().toString();
        // getting the weight value from the input field and convert to string
        String weightValue = weight.getText().toString();
        // the BMI category
        String bmiLabel = "";

        // checking if the height input filed is empty
        if (heightValue.isEmpty()) {
            // setting an error message
            height.setError("Please provide your height");
            // creating a red border to the height input field
            height.requestFocus();
        }
        // checking if the weight input filed is empty
        else if (weightValue.isEmpty()) {
            // setting an error message
            weight.setError("Please provide your weight");
            // creating a red border to the weight input field
            weight.requestFocus();
        }

        // if all the fields are filled in
        if (heightValue != null && !"".equals(heightValue) && weightValue != null && !"".equals(weightValue)) {
            // parsing height in float
            float heightFloat = Float.parseFloat(heightValue);
            // parsing weight in float
            float weightFloat = Float.parseFloat(weightValue);

            // calculating the BMI
            float bmi = weightFloat/(heightFloat/100 * heightFloat/100);

            // case of being male or female
            switch (gen) {
                // case gender is male
                case R.id.male_radio:
                    // BMI classification
                    if (bmi < 19.5)
                        bmiLabel = "Underweight";
                    if (bmi >= 19.5 && bmi <= 24.9)
                        bmiLabel = "Normal";
                    if (bmi >= 25 && bmi <= 29.9)
                        bmiLabel = "Obese 1";
                    if (bmi >= 30 && bmi <= 40)
                        bmiLabel = "Obese 2";
                    if (bmi > 40)
                        bmiLabel = "Obese 3";
                    break;
                // case gender is female
                case R.id.female_radio:
                    // BMI classification
                    if (bmi < 18.5)
                        bmiLabel = "Underweight";
                    if (bmi >= 18.5 && bmi <= 23.5)
                        bmiLabel = "Normal";
                    if (bmi >= 23.6 && bmi <= 28.6)
                        bmiLabel = "Obese 1";
                    if (bmi >= 28.7 && bmi <= 40)
                        bmiLabel = "Obese 2";
                    if (bmi > 40)
                        bmiLabel = "Obese 3";
                    break;
            }

            // set the results alert dialog
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            // set the alert dialog title
            alert.setTitle("Results");
            //set the alert dialog message (the results)
            alert.setMessage("Your BMI is: " + bmi + "\n" + "You belong in the " + bmiLabel + " category");
            // set the ok button
            alert.setNegativeButton("Ok", null);
            // display the alert dialog
            alert.create().show();

        }
    }
}
