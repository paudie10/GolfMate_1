package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class Competitions extends AppCompatActivity {
    TextView txtStableford, txtClubName, txtName, txtDate, txtCompName, txtHcap;
    String golfClub, date, both, compName, name, currentDate, price;
    int hCap;
    Bundle bundle;
    Button btnSignIn;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);

        txtClubName = (TextView) findViewById(R.id.txtClubName);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtName = (TextView) findViewById(R.id.txtName);
        txtHcap = (TextView) findViewById(R.id.txtHandicap);
        txtCompName = (TextView) findViewById(R.id.txtCompName);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        reference = FirebaseDatabase.getInstance().getReference();

        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        txtClubName.setText(i.getStringExtra("courseName"));

        Bundle extras = getIntent().getExtras();
        String handicap = extras.getString(("hCap"));
        hCap = Integer.parseInt(handicap);

        golfClub = txtClubName.getText().toString();
        both = golfClub + "_" + currentDate;

        Query todaysComp = reference.child("Competitions").orderByChild("Golfclub_Date").equalTo(both);
        todaysComp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    compName = ds.child("CompName").getValue(String.class);
                    price = ds.child("Price").getValue(String.class);
                    txtCompName.setText("Today's Competition:" + " " + compName);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });
        txtCompName.setText(compName);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gClub = txtClubName.getText().toString();
                String cName = txtCompName.getText().toString();
                String key = gClub + "_" + cName;
                reference = FirebaseDatabase.getInstance().getReference("Sign-Ins").child(key);
                String name = txtName.getText().toString().trim();


                HashMap<String, String> scoreMap = new HashMap<String, String>();
                scoreMap.put("Name", name);

                reference.push().setValue(scoreMap);

                name = txtName.getText().toString();
                golfClub = txtClubName.getText().toString();

                Intent myIntent = new Intent(Competitions.this, paypal.class);
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "compName", compName);
                myIntent.putExtra ( "price", price);

                Bundle extras = new Bundle();
                extras.putString("hCap", hCap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);

            }
        });
    }
}
