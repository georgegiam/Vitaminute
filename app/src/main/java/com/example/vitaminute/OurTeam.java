package com.example.vitaminute;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OurTeam extends AppCompatActivity {

    private TextView team1, team2, team3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_team);

        team1 = (TextView) findViewById(R.id.team1_textView);
        team2 = (TextView) findViewById(R.id.team2_textView);
        team3 = (TextView) findViewById(R.id.team3_textView);

        team1.setText("Elizabeth opens the line of communication between clients, customers, " +
                        "and businesses to get projects done. With over 20 years in both public and " +
                        "private sectors, Elizabeth has experience in management consultation, team building," +
                        " professional development, strategic implementation, and company collaboration.");
        team2.setText("Alexis connects online brands to their target audiences for the " +
                " marketing experience. At the University of California, Alexis, learned the " +
                "importance of applying classic marketing techniques to modern brand strategies from " +
                "experts in the field, including her Communications professor, Dr. Martin Mitchell.");
        team3.setText("Jack knows that successful students become successful adults. This is " +
                "his 15th year at Edison Elementary School and her 10th year teaching fourth grade. " +
                "So far, fourth grade is his favorite grade to teach! Mrs. Carroll was the 2011 Newell " +
                "Unified School District Teacher of the Year, and received his National Board Certification " +
                "in 2013.");
    }
}
