package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Admin extends AppCompatActivity {
    Button b1, b2;
    EditText txt1;
    DatabaseReference reference;
    String compName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        b1 = (Button) findViewById(R.id.btnCreate);
        b2 = (Button) findViewById(R.id.btnReturn);
        txt1 = (EditText) findViewById(R.id.txtCompName);
        compName = txt1.getText().toString().trim();




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compName = txt1.getText().toString().trim();
                reference = FirebaseDatabase.getInstance().getReference(compName);
                String name = "test name";
                String Score = "test score";




                HashMap<String, String> compCreation = new HashMap<String, String>();
                compCreation.put("Name", name);
                compCreation.put("Score", Score);

                reference.push().setValue(compCreation);

                txt1.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Admin.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
}
