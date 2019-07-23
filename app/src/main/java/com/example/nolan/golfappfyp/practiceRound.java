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

public class practiceRound extends AppCompatActivity {
    TextView txtStableford, txtClubName, txtName, txtDate, txtCompName, txtHcap;
    String golfClub, date, both, compName, name, currentDate, price;
    int hCap;
    Bundle bundle;
    Button btnSignIn;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        txtClubName = (TextView) findViewById(R.id.txtClubName);
        txtName = (TextView) findViewById(R.id.txtName);
        txtHcap = (TextView) findViewById(R.id.txtHandicap);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        reference = FirebaseDatabase.getInstance().getReference();

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        txtClubName.setText(i.getStringExtra("courseName"));

        Bundle extras = getIntent().getExtras();
        String handicap = extras.getString(("hCap"));
        hCap = Integer.parseInt(handicap);

        golfClub = txtClubName.getText().toString();
        name = txtName.getText().toString();
        compName = txtCompName.getText().toString();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compName = txtCompName.getText().toString();
                Intent myIntent = new Intent(practiceRound.this, stableford_hole1_practice.class);
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "compName", compName);

                Bundle extras = new Bundle();
                extras.putString("hCap", hCap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
    }
}
