package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class front9score extends AppCompatActivity {
    TextView txtStableford;
    Button btnNextHole;
    int stableford;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front9score);

        txtStableford = (TextView) findViewById(R.id.txtStableford_front9);
        btnNextHole = (Button) findViewById(R.id.btnNextHole_front9);

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText(Integer.toString(stableford));

        btnNextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(front9score.this, stableford_hole10.class);
                Bundle extras = new Bundle();
                extras.putString("number", stableford + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });

    }
}
