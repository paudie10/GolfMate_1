package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class Profile extends AppCompatActivity {
    TextView txtProfile, txtName;
    Button btnScorecard;
    Bundle bundle;
    String value;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtProfile = (TextView) findViewById(R.id.txtProfile);
        txtName = (TextView) findViewById(R.id.txtName);
        btnScorecard = (Button) findViewById(R.id.btnCompetition);
        reference = FirebaseDatabase.getInstance().getReference();
        Query lastQuery = reference.child("Players").orderByKey().limitToLast(1);
        bundle = new Bundle();

        lastQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String email = ds.child("Email").getValue(String.class);
                    String name = ds.child("Name").getValue(String.class);
                    String gClub = ds.child("Golf Club").getValue(String.class);
                    String hCap = ds.child("Handicap").getValue(String.class);
                    txtName.setText(name);
                    txtProfile.setText("Email: " + email + "\n" + "Handicap: " + hCap + "\n" + "Golf Club: " + gClub);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });

        btnScorecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value = txtName.getText().toString();



                Intent myIntent = new Intent(Profile.this, Scorecard.class);
                myIntent.putExtra ( "text", value);
                startActivity(myIntent);

            }
        });

    }
}
