package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class adminLogin extends AppCompatActivity {
    TextView txtUsername, txtPassword;
    Button btnConfirm, btnLink;
    DatabaseReference reference;
    String uName, username, pass, name, gClub, email;
    int hCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnLink = (Button) findViewById(R.id.btnLinkToRegisterScreen);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtUsername = (TextView) findViewById(R.id.txtUsername);
        reference = FirebaseDatabase.getInstance().getReference();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtUsername.getText().toString().equals("") ||
                        txtPassword.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Details Incomplete, Password must be greater than 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    uName = txtUsername.getText().toString();
                    Query partnerSearch = reference.child("Admin").orderByChild("Username").equalTo(uName);
                    partnerSearch.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                username = ds.child("Username").getValue(String.class);
                                pass = ds.child("Password").getValue(String.class);
                                gClub = ds.child("Golf Club").getValue(String.class);

                            }
                            if (txtPassword.getText().toString().equals(pass) && txtUsername.getText().toString().equals(username)) {
                                Toast.makeText(getApplicationContext(), ("Welcome" + " " + uName), Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getBaseContext(), Admin.class);
                                myIntent.putExtra("courseName", gClub);

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
            }
        });
        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), adminSignUp.class);
                startActivity(myIntent);
            }
        });

    }
}
