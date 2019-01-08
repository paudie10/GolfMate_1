package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button b1, b2;
    DatabaseReference reference;
    EditText txt1, txt2, txt3, txt4, txt5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.btnSave);
        b2 = (Button) findViewById(R.id.btnCancel);
        txt1 = (EditText) findViewById(R.id.txtName);
        txt2 = (EditText) findViewById(R.id.txtEmail);
        txt3 = (EditText) findViewById(R.id.txtPassword);
        txt4 = (EditText) findViewById(R.id.txtHandicap);
        txt5 = (EditText) findViewById(R.id.txtGolfClub);

        reference = FirebaseDatabase.getInstance().getReference("Players");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txt1.getText().toString().trim();
                String email = txt2.getText().toString().trim();
                String pass = txt3.getText().toString().trim();
                String hCap = txt4.getText().toString().trim();
                String gClub = txt5.getText().toString().trim();


                HashMap<String, String> playerMap = new HashMap<String, String>();
                playerMap.put("Name", name);
                playerMap.put("Email", email);
                playerMap.put("Password", pass);
                playerMap.put("Handicap", hCap);
                playerMap.put("Golf Club", gClub);

                reference.push().setValue(playerMap);



                Intent myIntent = new Intent(getBaseContext(), Profile.class);
                startActivity(myIntent);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), stableford_hole1.class);
                startActivity(myIntent);
            }
        });


    }
}
