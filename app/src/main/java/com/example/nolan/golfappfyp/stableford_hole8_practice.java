package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class stableford_hole8_practice extends AppCompatActivity {
    TextView txtGrossScore, txtStableford, txtHole, txtYards, txtName, txtDate, txtCompName, txtIndex, txtPar;
    Button btnNextHole;
    Bundle bundle;
    TableLayout tb;
    DatabaseReference reference;
    EditText txtYourScore;
    Spinner txtNoofPutts;
    RadioButton rbGIR, rbFH;
    int par, handicap, holeIndex, score, stableford, yards;
    String golfClub, hole, both;
    int gir = 0;
    int fh = 0;
    int putts = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stableford_hole8);

        txtIndex = (TextView) findViewById(R.id.txtIndex);
        txtPar = (TextView) findViewById(R.id.txtPar);
        txtHole = (TextView) findViewById(R.id.txtHole);
        txtName = (TextView) findViewById(R.id.txtName);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        txtYards = (TextView) findViewById(R.id.txtYards);
        txtStableford = (TextView) findViewById(R.id.txtStableford);
        txtNoofPutts = (Spinner) findViewById(R.id.txtNoofPutts);
        rbGIR = (RadioButton) findViewById(R.id.rbGIR);
        rbFH = (RadioButton) findViewById(R.id.rbFH);
        btnNextHole = (Button) findViewById(R.id.btnNextHole);
        txtYourScore = (EditText) findViewById(R.id.txtYourScore);
        reference = FirebaseDatabase.getInstance().getReference();

        //https://www.youtube.com/watch?v=urQp7KsQhW8
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner,
                getResources().getStringArray(R.array.numbers));

        txtNoofPutts.setAdapter(myAdapter);
        bundle = new Bundle();
        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        txtCompName.setText(i.getStringExtra("compName"));

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText(Integer.toString(stableford) + " " + "points");
        String puttsNum = extras.getString(("putts"));
        putts = Integer.parseInt(puttsNum);
        String girNum = extras.getString(("gir"));
        gir = Integer.parseInt(girNum);
        String fhNum = extras.getString(("fh"));
        fh = Integer.parseInt(fhNum);
        String hCap = extras.getString(("hCap"));
        handicap = Integer.parseInt(hCap);



        golfClub = i.getStringExtra("courseName");
        hole = txtHole.getText().toString();
        both = golfClub + "_" + hole;

        Query findHole = reference.child("Courses").orderByChild("Course_Hole").equalTo(both);
        findHole.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    holeIndex = ds.child("Index").getValue(int.class);
                    par = ds.child("Par").getValue(int.class);
                    yards = ds.child("Yards").getValue(int.class);

                    txtIndex.setText("Index: " + Integer.toString(holeIndex));
                    txtPar.setText("Par: " + Integer.toString(par));
                    txtYards.setText("Yards: " + Integer.toString(yards));

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });


        btnNextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = Integer.parseInt(txtYourScore.getText().toString());
                //par 3 without shot
                if (handicap == 8 && holeIndex > 8 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 8 && holeIndex <= 8 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 8 && holeIndex > 8 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 8 && holeIndex <= 8 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 8 && holeIndex > 8 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex > 8 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex > 8 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 8 && holeIndex <= 8 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 8 && holeIndex <= 8 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                //handicap 1
                if (handicap == 1 && holeIndex > 1 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 1 && holeIndex > 1 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 1 && holeIndex > 1 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex > 1 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 1 && holeIndex <= 1 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 1 && holeIndex <= 1 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                // 2 handicap

                if (handicap == 2 && holeIndex > 2 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 2 && holeIndex > 2 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 2 && holeIndex > 2 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex > 2 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 2 && holeIndex <= 2 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 2 && holeIndex <= 2 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));


                // handicap 3
                if (handicap == 3 && holeIndex > 3 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 3 && holeIndex > 3 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 3 && holeIndex > 3 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex > 3 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 3 && holeIndex <= 3 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 3 && holeIndex <= 3 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                // handicap 4
                if (handicap == 4 && holeIndex > 4 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex > 4 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 4 && holeIndex > 4 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex > 4 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 4 && holeIndex > 4 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4&& holeIndex > 4 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex > 4 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 4 && holeIndex <= 4 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 4 && holeIndex <= 4 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                // handicap 5
                if (handicap == 5 && holeIndex > 5 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 5 && holeIndex > 5 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 5 && holeIndex > 5 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex > 5 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 5 && holeIndex <= 5 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 5 && holeIndex <= 5 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                // handicap 6
                if (handicap == 6 && holeIndex > 6 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 6 && holeIndex > 6 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 6 && holeIndex > 6 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex > 6 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 6 && holeIndex <= 6 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 6 && holeIndex <= 6 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                // handicap 7
                if (handicap == 7 && holeIndex > 7 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 7 && holeIndex > 7 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 7 && holeIndex > 7 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex > 7 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 7 && holeIndex <= 7 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 7 && holeIndex <= 7 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                // handicap 9
                if (handicap == 9 && holeIndex > 9 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 9 && holeIndex > 9 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 9 && holeIndex > 9 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex > 9 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 9 && holeIndex <= 9 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 9 && holeIndex <= 9 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                //handicap 10
                if (handicap == 10 && holeIndex > 10 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 10 && holeIndex > 10 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 10 && holeIndex > 10 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex > 10 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 10 && holeIndex <= 10 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 10 && holeIndex <= 10 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                //handicap 11

                if (handicap == 11 && holeIndex > 11 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 11 && holeIndex > 11 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 11 && holeIndex > 11 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex > 11 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 11 && holeIndex <= 11 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 11 && holeIndex <= 11 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));

                //handicap 12
                if (handicap == 12 && holeIndex > 12 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 12 && holeIndex > 12 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 12 && holeIndex > 12 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex > 12 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 12 && holeIndex <= 12 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 12 && holeIndex <= 12 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                //handicap 13
                if (handicap == 13 && holeIndex > 13 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 13 && holeIndex <= 13 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 13 && holeIndex > 13 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 13 && holeIndex <= 13 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 13 && holeIndex > 13 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex > 13 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex > 13 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 13 && holeIndex <= 13 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 13 && holeIndex <= 13 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                //handicap 14
                if (handicap == 14 && holeIndex > 14 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 14 && holeIndex <= 14 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 14 && holeIndex > 14 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 14 && holeIndex <= 14 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 14 && holeIndex > 14 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex > 14 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex > 14 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 14 && holeIndex <= 14 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 14 && holeIndex <= 14 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                //handicap 15
                if (handicap == 15 && holeIndex > 15 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 15 && holeIndex <= 15 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 15 && holeIndex > 15 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 15 && holeIndex <= 15 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 15 && holeIndex > 15 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex > 15 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex > 15 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 15 && holeIndex <= 15 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 15 && holeIndex <= 15 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else txtStableford.setText(Integer.toString(0));
                //handicap 16
                if (handicap == 16 && holeIndex > 16 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 16 && holeIndex <= 16 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 16 && holeIndex > 16 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 16 && holeIndex <= 16 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 16 && holeIndex > 16 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex > 16 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex > 16 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 16 && holeIndex <= 16 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 16 && holeIndex <= 16 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                    //handicap 17
                }else if (handicap == 17 && holeIndex > 17 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 17 && holeIndex <= 17 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 17 && holeIndex > 17 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 17 && holeIndex <= 17 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 17 && holeIndex > 17 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex > 17 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex > 17 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 17 && holeIndex <= 17 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 17 && holeIndex <= 17 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                    //handicap 18
                } else if (handicap == 18 && holeIndex > 18 && par == 3 && score == 1) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 3 && score == 2) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 3 && score == 3) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 3 && score == 4) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 3 with shot
                }else if (handicap == 18 && holeIndex <= 18 && par == 3 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 3 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 3 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 3 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 3 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 without shot
                }else if (handicap == 18 && holeIndex > 18 && par == 4 && score == 1) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 4 && score == 2) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 4 && score == 3) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 4 && score == 4) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 4 && score == 5) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 4 with shot
                }else if (handicap == 18 && holeIndex <= 18 && par == 4 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 4 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 4 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 4 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 4 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 4 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    //par 5 without shot
                }else if (handicap == 18 && holeIndex > 18 && par == 5 && score == 1) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 5 && score == 2) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex > 18 && par == 5 && score == 3) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 5 && score == 4) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 5 && score == 5) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex > 18 && par == 5 && score == 6) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                    // par 5 with shot
                }else if (handicap == 18 && holeIndex <= 18 && par == 5 && score == 1) {
                    stableford = stableford + 7;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 2) {
                    stableford = stableford + 6;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                } else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 3) {
                    stableford = stableford + 5;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 4) {
                    stableford = stableford + 4;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 5) {
                    stableford = stableford + 3;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 6) {
                    stableford = stableford + 2;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));

                }else if(handicap == 18 && holeIndex <= 18 && par == 5 && score == 7) {
                    stableford = stableford + 1;
                    txtStableford.setText("Your Stableford Score" + " " + Integer.toString(stableford));


                } else txtStableford.setText(Integer.toString(0));

                if (rbGIR.isChecked()) {
                    gir = gir + 1;
                    Integer.toString(gir);
                }
                if (rbFH.isChecked()) {
                    fh = fh + 1;
                    Integer.toString(fh);
                }

                putts = putts + Integer.parseInt(txtNoofPutts.getSelectedItem().toString());
                Integer.toString(putts);


                String name = txtName.getText().toString();
                String compName = txtCompName.getText().toString();

                Intent myIntent = new Intent(stableford_hole8_practice.this, stableford_hole9_practice.class);
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "compName", compName);

                Bundle extras = new Bundle();
                extras.putString("number", stableford + "");
                extras.putString("gir", gir + "");
                extras.putString("fh", fh + "");
                extras.putString("putts", putts + "");
                extras.putString("hCap", handicap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }


        });

    }
}


