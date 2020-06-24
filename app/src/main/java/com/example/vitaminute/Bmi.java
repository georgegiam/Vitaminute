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

    RadioGroup radioGroup;
    RadioButton male, female;
    private EditText height, weight;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

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
                int gen = radioGroup.getCheckedRadioButtonId();

                if (gen == -1){
                    // no gender selected
                    Toast.makeText(getApplicationContext(), "Please select gender", Toast.LENGTH_LONG);
                }
                else {
                    // call the calculate function
                    calculateBmi(gen);
                }
            }
        });
    }

    // calculate function
    public void calculateBmi(int gen) {
        // getting height and weight values form the input fields (casted to String)
        String heightValue = height.getText().toString();
        String weightValue = weight.getText().toString();
        String bmiLabel = "";
        String res = "";

        if (heightValue.isEmpty()) {
            height.setError("Please provide your height");
            height.requestFocus();
        }
        else if (weightValue.isEmpty()) {
            weight.setError("Please provide your weight");
            weight.requestFocus();
        }

        // checks if the user has field the inputs
        if (heightValue != null && !"".equals(heightValue) && weightValue != null && !"".equals(weightValue)) {
            // parsing weight and height in float
            float heightFloat = Float.parseFloat(heightValue);
            float weightFloat = Float.parseFloat(weightValue);

            // bmi formula
            float bmi = weightFloat/(heightFloat/100 * heightFloat/100);


            switch (gen) {
                // case gender is male
                case R.id.male_radio:
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

            // set the results modal
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            // set the modal title
            alert.setTitle("Results");
            //set the modal message (the results)
            alert.setMessage("Your BMI is: " + bmi + "\n" + "You belong in the " + bmiLabel + " category");
            // set the ok button
            alert.setNegativeButton("Ok", null);
            // display the modal
            alert.create().show();

        }
    }
}
