package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class adminSignUp extends AppCompatActivity {
    EditText txtUsername, txtGolfClub, txtPassword;
    Button btnSave, btnReturn;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtGolfClub = (EditText) findViewById(R.id.txtGolfClub);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        reference = FirebaseDatabase.getInstance().getReference("Admin");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtUsername.getText().toString().equals("") || txtGolfClub.getText().toString().equals("") ||
                        txtPassword.getText().toString().equals("") || txtPassword.getText().toString().length() < 8) {
                    Toast.makeText(getApplicationContext(), "Details Incomplete, Password must be greater than 8 characters", Toast.LENGTH_SHORT).show();
                } else {
                    String Username = txtUsername.getText().toString().trim();
                    String GolfClub = txtGolfClub.getText().toString().trim();
                    String pass = txtPassword.getText().toString().trim();


                    HashMap<String, String> playerMap = new HashMap<String, String>();
                    playerMap.put("Username", Username);
                    playerMap.put("Golf Club", GolfClub);
                    playerMap.put("Password", pass);


                    reference.push().setValue(playerMap);


                    Intent myIntent = new Intent(getBaseContext(), Admin.class);
                    startActivity(myIntent);

                }
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), Launch.class);
                startActivity(myIntent);
            }
        });
    }

}
