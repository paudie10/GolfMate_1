package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class practice_finalScore extends AppCompatActivity {
    TextView txtgClub, txtName, txtDate, txtCompName, txtGIR, txtFH, txtPutts , txtStableford, txtFront, txtBack;
    Button btnSubmit, btnConfirm;
    EditText txtPassword, txtPartner;
    String golfClub, compName, name, email, username;
    int stableford, putts, gir, fh, back, front9, handicap;
    Bundle bundle;
    DatabaseReference reference, reference_1, reference_2, reference_3, reference_4, reference_5;

    String pass, partner, key, cName, gClub, pName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_final_score);

        txtStableford = (TextView) findViewById(R.id.txtStableford_finalScore);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtFront = (TextView) findViewById(R.id.txtFront);
        txtName = (TextView) findViewById(R.id.txtName);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtPartner = (EditText) findViewById(R.id.txtPartner);
        txtGIR = (TextView) findViewById(R.id.txtGIR);
        txtFH = (TextView) findViewById(R.id.txtFH);
        txtPutts = (TextView) findViewById(R.id.txtPutts);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        reference = FirebaseDatabase.getInstance().getReference();

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        golfClub = i.getStringExtra("courseName");
        compName = i.getStringExtra("compName");
        txtCompName.setText(compName);

        Bundle extras = getIntent().getExtras();
        String number = extras.getString("number");
        stableford = Integer.parseInt(number);
        txtStableford.setText(Integer.toString(stableford));
        String hCap = extras.getString(("hCap"));
        handicap = Integer.parseInt(hCap);
        String front = extras.getString("front9");
        front9 = Integer.parseInt(front);
        String puttsNum = extras.getString(("putts"));
        putts = Integer.parseInt(puttsNum);
        txtPutts.setText("Putts: " + " " + Integer.toString(putts));
        String girNum = extras.getString(("gir"));
        gir = Integer.parseInt(girNum);
        txtGIR.setText("GIR: " + " " + Integer.toString(gir) + "/18");
        String fhNum = extras.getString(("fh"));
        fh = Integer.parseInt(fhNum);
        txtFH.setText("FR: " + " " + Integer.toString(fh) + "/18");

        back = stableford - front9;
        txtFront.setText("Front 9: " + Integer.toString(front9));
        txtBack.setText("Back 9: " + Integer.toString(back));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    name = txtName.getText().toString().trim();
                    int score = Integer.parseInt(txtStableford.getText().toString().trim());



                    reference_1 = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("GIR");
                    HashMap girMap = new HashMap();
                    girMap.put("CompName", compName);
                    girMap.put("GIR", gir);

                    reference_1.push().setValue(girMap);

                    reference_2 = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("FH");
                    HashMap fhMap = new HashMap();
                    fhMap.put("CompName", compName);
                    fhMap.put("FH", fh);

                    reference_2.push().setValue(fhMap);

                    reference_3 = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("Putts");
                    HashMap puttsMap = new HashMap();
                    puttsMap.put("CompName", compName);
                    puttsMap.put("Putts", putts);

                    reference_3.push().setValue(puttsMap);

                    reference_4 = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("Scores").child("Overall");
                    HashMap scoresMap = new HashMap();
                    scoresMap.put("Score", score);

                    reference_4.push().setValue(scoresMap);

                    reference_5 = FirebaseDatabase.getInstance().getReference("Stats").child(name).child("Scores").child("back");
                    HashMap backMap = new HashMap();
                    backMap.put("Score", back);

                    reference_5.push().setValue(backMap);


                    txtStableford.setText("");

                    name = txtName.getText().toString();
                    Query profileSearch = reference.child("Players").orderByChild("Name").equalTo(name);
                    profileSearch.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                name = ds.child("Name").getValue(String.class);
                                pass = ds.child("Password").getValue(String.class);
                                email = ds.child("Email").getValue(String.class);
                                username = ds.child("Username").getValue(String.class);
                                golfClub = ds.child("Golf Club").getValue(String.class);
                            }
                            Intent myIntent = new Intent(getBaseContext(), Profile_final.class);
                            myIntent.putExtra ( "name", name);
                            myIntent.putExtra ( "courseName", golfClub);
                            myIntent.putExtra ( "uName", username);
                            myIntent.putExtra ( "email", email);

                            Bundle extras = new Bundle();
                            extras.putString("hCap", handicap + "");
                            myIntent.putExtras(extras);
                            startActivity(myIntent);
                            Toast.makeText(getApplicationContext(), "Your Score has been submitted", Toast.LENGTH_SHORT).show();
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
