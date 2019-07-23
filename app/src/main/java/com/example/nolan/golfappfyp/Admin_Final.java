package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import static java.text.DateFormat.getDateInstance;

public class Admin_Final extends AppCompatActivity {
    Button b1, b2, b3, btnLogOut;
    EditText txt1, txtPrice;
    TextView txtDate, txtCourseName;
    DatabaseReference reference;
    String compName, golfClub, date, both, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_final);

        b1 = (Button) findViewById(R.id.btnCreate);
        b2 = (Button) findViewById(R.id.btnReturn);
        b3 = (Button) findViewById(R.id.btncreateCourse);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
        txt1 = (EditText) findViewById(R.id.txtCompName);
        txtPrice = (EditText) findViewById(R.id.txtPrice);
        txtCourseName = (TextView) findViewById(R.id.txtCourseName);
        txtDate = (TextView) findViewById(R.id.txtDate);
        compName = txt1.getText().toString().trim();
        reference = FirebaseDatabase.getInstance().getReference();

        Query lastQuery = reference.child("Admin").orderByKey().limitToLast(1);

        lastQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String gClub = ds.child("Golf Club").getValue().toString();
                    txtCourseName.setText(gClub);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Handle possible errors.
            }
        });

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(calendar.getTime());
        txtDate.setText(currentDate);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference = FirebaseDatabase.getInstance().getReference("Competitions");
                compName = txt1.getText().toString().trim();
                price = txtPrice.getText().toString().trim();
                golfClub = txtCourseName.getText().toString().trim();
                date = txtDate.getText().toString().trim();
                both = golfClub + "_" + date;





                HashMap<String, String> compCreation = new HashMap<String, String>();
                compCreation.put("Golfclub_Date", both);
                compCreation.put("CompName", compName);
                compCreation.put("Price", price);

                reference.push().setValue(compCreation);

                txt1.setText("");
                txtPrice.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Admin_Final.this, Results.class);
                startActivity(myIntent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                golfClub = txtCourseName.getText().toString();

                Intent myIntent = new Intent(Admin_Final.this, createcourse_hole1.class);
                myIntent.putExtra ( "courseName", golfClub);
                startActivity(myIntent);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Admin_Final.this, Launch.class);
                startActivity(myIntent);
            }
        });
    }
}
