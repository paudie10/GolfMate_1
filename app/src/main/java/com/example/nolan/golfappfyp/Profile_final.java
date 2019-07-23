package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;


public class Profile_final extends AppCompatActivity {
    TextView txtProfile, txtName, txtCurrentComp, txtDate, txtCourseName, txtHandicap, txtUsername;
    Button btnSignIn, btnResults, btnStats, btnScorecard, btnLogOut;
    Bundle bundle;
    String value, golfClub, date, both, gClub, compName, currentDate, name;
    int hCap;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_final);


        txtName = (TextView) findViewById(R.id.txtName);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        txtCourseName = (TextView) findViewById(R.id.txtCourseName);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnResults = (Button) findViewById(R.id.btnResults);
        btnStats = (Button) findViewById(R.id.btnStats);
        btnScorecard = (Button) findViewById(R.id.btnScorecard);
        reference = FirebaseDatabase.getInstance().getReference();

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

        Intent i = getIntent();
        name = i.getStringExtra("name");
        txtName.setText(name);
        golfClub = i.getStringExtra("courseName");
        txtCourseName.setText(golfClub);
        txtUsername.setText(i.getStringExtra("uName"));
        Bundle extras = getIntent().getExtras();
        String handicap = extras.getString(("hCap"));
        hCap = Integer.parseInt(handicap);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golfClub = txtCourseName.getText().toString();
                value = txtName.getText().toString();



                Intent myIntent = new Intent(Profile_final.this, Competitions.class);
                myIntent.putExtra ( "name", value);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "date", currentDate);

                Bundle extras = new Bundle();
                extras.putString("hCap", hCap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });

        btnResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Profile_final.this, Results.class);
                startActivity(myIntent);
            }
        });
        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Profile_final.this, Stats.class);
                startActivity(myIntent);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Profile_final.this, Launch.class);
                startActivity(myIntent);
            }
        });
        btnScorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Profile_final.this, practiceRound.class);
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "date", currentDate);

                Bundle extras = new Bundle();
                extras.putString("hCap", hCap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
    }
}
