package com.example.nolan.golfappfyp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class finalScore extends AppCompatActivity {
    TextView txtStableford;
    Button btnNextHole;
    int stableford;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_score);

        txtStableford = (TextView) findViewById(R.id.txtStableford_finalScore);
        btnNextHole = (Button) findViewById(R.id.btnNextHole_finalScore);

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText(Integer.toString(stableford));



    }
}
