package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class createcourse_hole7 extends AppCompatActivity {

    EditText txtYards, txtPar, txtIndex;
    TextView txtGolfClub, txtHole;
    Button btnNextHole;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createcourse_hole7);

        txtYards = (EditText) findViewById(R.id.txtYards);
        txtPar = (EditText) findViewById(R.id.txtPar);
        txtIndex = (EditText) findViewById(R.id.txtIndex);
        txtGolfClub = (TextView) findViewById(R.id.txtGolfClub);
        txtHole = (TextView) findViewById(R.id.txtHole);
        btnNextHole = (Button) findViewById(R.id.btnNextHole);
        reference = FirebaseDatabase.getInstance().getReference();

        Intent i = getIntent();
        txtGolfClub.setText(i.getStringExtra("courseName"));

        btnNextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gClub = txtGolfClub.getText().toString();
                String hole = txtHole.getText().toString();
                String both = gClub + "_" + hole;
                int index = Integer.parseInt(txtIndex.getText().toString());
                int par = Integer.parseInt(txtPar.getText().toString());
                int yards = Integer.parseInt(txtYards.getText().toString());
                reference = FirebaseDatabase.getInstance().getReference("Courses");


                HashMap courseMap = new HashMap();
                courseMap.put("Index", index);
                courseMap.put("Par", par);
                courseMap.put("Yards", yards);
                courseMap.put("Course_Hole", both);

                reference.push().setValue(courseMap);
                gClub = txtGolfClub.getText().toString();

                Intent myIntent = new Intent(createcourse_hole7.this, createcourse_hole8.class);
                myIntent.putExtra ( "courseName", gClub);
                startActivity(myIntent);



            }
        });
    }
}
