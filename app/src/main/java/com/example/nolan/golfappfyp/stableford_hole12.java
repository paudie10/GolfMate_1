package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class stableford_hole12 extends AppCompatActivity {
    TextView txtGrossScore, txtStableford;
    Button btnNextHole;
    Bundle bundle;
    EditText txtYourScore,txtIndex, txtPar, txthCap;
    int par, handicap, holeIndex, score, GrossScore, stableford;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stableford_hole12);

        txtIndex = (EditText) findViewById(R.id.txtIndex_hole12);
        txtPar = (EditText) findViewById(R.id.txtPar_hole12);
        txthCap = (EditText) findViewById(R.id.txthCap_hole12);
        txtGrossScore = (TextView) findViewById(R.id.txtGrossScore_hole12);
        txtStableford = (TextView) findViewById(R.id.txtStableford_hole12);
        btnNextHole = (Button) findViewById(R.id.btnNextHole_hole12);
        txtYourScore = (EditText) findViewById(R.id.txtYourScore_hole12);
        bundle = new Bundle();

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText(Integer.toString(stableford));



        btnNextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handicap = Integer.parseInt(txthCap.getText().toString());
                par = Integer.parseInt(txtPar.getText().toString());
                holeIndex = Integer.parseInt(txtIndex.getText().toString());
                score = Integer.parseInt(txtYourScore.getText().toString());
                GrossScore = Integer.parseInt(txtYourScore.getText().toString());
                stableford = Integer.parseInt(txtStableford.getText().toString());
                //par 3 without shot
                if (handicap == 8 && holeIndex > 8 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                } else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                } else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                    //handicap 1
                }else if (handicap == 1 && holeIndex > 1 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 1 && holeIndex > 1 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 1 && holeIndex > 1 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // 2 handicap

                }else if (handicap == 2 && holeIndex > 2 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 2 && holeIndex > 2 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 2 && holeIndex > 2 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));


                    // handicap 3
                }else if (handicap == 3 && holeIndex > 3 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 3 && holeIndex > 3 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 3 && holeIndex > 3 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // handicap 4
                }else if (handicap == 4 && holeIndex > 4 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 4 && holeIndex > 4 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 4 && holeIndex > 4 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4&& holeIndex > 4 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));


                    // handicap 5
                }else if (handicap == 5 && holeIndex > 5 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 5 && holeIndex > 5 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 5 && holeIndex > 5 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // handicap 6
                }else if (handicap == 6 && holeIndex > 6 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 6 && holeIndex > 6 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 6 && holeIndex > 6 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // handicap 7
                }else if (handicap == 7 && holeIndex > 7 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 7 && holeIndex > 7 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 7 && holeIndex > 7 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // handicap 9
                }else if (handicap == 9 && holeIndex > 9 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 9 && holeIndex > 9 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 9 && holeIndex > 9 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                    //handicap 10
                }else if (handicap == 10 && holeIndex > 10 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 10 && holeIndex > 10 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 10 && holeIndex > 10 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //handicap 11

                }else if (handicap == 11 && holeIndex > 11 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 11 && holeIndex > 11 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 11 && holeIndex > 11 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //handicap 12
                } else if (handicap == 12 && holeIndex > 12 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 3 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 without shot
                }else if (handicap == 12 && holeIndex > 12 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 4 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    //par 5 without shot
                }else if (handicap == 12 && holeIndex > 12 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));

                    // par 5 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText(Integer.toString(stableford));
                    txtGrossScore.setText(Integer.toString(GrossScore));
                } else txtStableford.setText(Integer.toString(0));



                Intent myIntent = new Intent(stableford_hole12.this, stableford_hole13.class);
                Bundle extras = new Bundle();
                extras.putString("number", stableford + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
    }
}