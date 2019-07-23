package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class practice_front9score extends AppCompatActivity {
    TextView txtgClub, txtName, txtDate, txtCompName, txtStableford;
    Button btnNextHole;
    int stableford, putts, gir, fh, handicap;
    Bundle bundle;
    String golfClub;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front9score);

        txtStableford = (TextView) findViewById(R.id.txtStableford_front9);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        btnNextHole = (Button) findViewById(R.id.btnNextHole_front9);

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        golfClub = i.getStringExtra("courseName");
        txtCompName.setText(i.getStringExtra("compName"));

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText("Front 9: " + Integer.toString(stableford) + " " + "points");
        String puttsNum = extras.getString(("putts"));
        putts = Integer.parseInt(puttsNum);
        String girNum = extras.getString(("gir"));
        gir = Integer.parseInt(girNum);
        String fhNum = extras.getString(("fh"));
        fh = Integer.parseInt(fhNum);
        String hCap = extras.getString(("hCap"));
        handicap = Integer.parseInt(hCap);


        btnNextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String compName = txtCompName.getText().toString();



                reference = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("Scores").child("front9");
                HashMap scoresMap = new HashMap();
                scoresMap.put("Score", stableford);

                reference.push().setValue(scoresMap);

                Intent myIntent = new Intent(practice_front9score.this, stableford_hole10_practice.class);
                Bundle extras = new Bundle();
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "compName", compName);
                extras.putString("number", stableford + "");
                extras.putString("front9", stableford + "");
                extras.putString("gir", gir + "");
                extras.putString("fh", fh + "");
                extras.putString("putts", putts + "");
                extras.putString("hCap", handicap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });

    }
}
