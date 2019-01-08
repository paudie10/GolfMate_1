package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Scorecard extends AppCompatActivity {
    Button b1;

    DatabaseReference reference;
    TextView txtName, txtCompName;
    EditText txtScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scorecard);
        b1 = (Button) findViewById(R.id.btnSubmit);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        txtScore = (EditText) findViewById(R.id.txtScore);

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("text"));


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = txtCompName.getText().toString();
                reference = FirebaseDatabase.getInstance().getReference(value);
                String name = txtName.getText().toString().trim();
                String score = txtScore.getText().toString().trim();

                HashMap<String, String> scoreMap = new HashMap<String, String>();
                scoreMap.put("Name", name);
                scoreMap.put("Score", score);

                reference.push().setValue(scoreMap);

                txtScore.setText("");

            }
        });

    }
}
