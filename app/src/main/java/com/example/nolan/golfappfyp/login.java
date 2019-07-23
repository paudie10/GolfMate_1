package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {
    TextView txtUsername, txtPassword;
    Button btnConfirm;
    DatabaseReference reference;
    String uName, username, pass, name, gClub;
    int hCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        reference = FirebaseDatabase.getInstance().getReference();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uName = txtUsername.getText().toString();
                Query partnerSearch = reference.child("Players").orderByChild("Username").equalTo(uName);
                partnerSearch.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot ds : dataSnapshot.getChildren()) {
                            username = ds.child("Username").getValue(String.class);
                            pass = ds.child("Password").getValue(String.class);
                            name = ds.child("Name").getValue(String.class);
                            gClub = ds.child("Golf Club").getValue(String.class);
                            hCap = ds.child("Handicap").getValue(int.class);
                        }
                        if (txtPassword.getText().toString().equals(pass) && txtUsername.getText().toString().equals(username)) {
                            Toast.makeText(getApplicationContext(), ("Welcome" + " " + name), Toast.LENGTH_SHORT).show();
                            Intent myIntent = new Intent(getBaseContext(), Profile_login.class);
                            myIntent.putExtra ( "name", name);
                            myIntent.putExtra ( "courseName", gClub);
                            myIntent.putExtra ( "uName", username);

                            Bundle extras = new Bundle();
                            extras.putString("hCap", hCap + "");
                            myIntent.putExtras(extras);
                            startActivity(myIntent);
                        } else {
                            Toast.makeText(getApplicationContext(), ("Incorrect Details, Try Again"), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //Handle possible errors.
                    }

                });

            }
        });

    }
}
