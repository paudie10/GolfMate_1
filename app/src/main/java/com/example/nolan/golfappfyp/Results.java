package com.example.nolan.golfappfyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.layout.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Results extends AppCompatActivity {
    EditText  txtGolfClub, txtCompName;
    ListView lstResults;
    FirebaseDatabase database;
    DatabaseReference reference;
    Button btnSearch;
    String duo;
    int i;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    listResults listRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        txtGolfClub = (EditText) findViewById(R.id.txtGolfClub);
        txtCompName = (EditText) findViewById(R.id.txtCompName);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        lstResults = (ListView) findViewById(R.id.lstResults);
        reference = FirebaseDatabase.getInstance().getReference();


        String golfClub = txtGolfClub.getText().toString();
        String compName = txtCompName.getText().toString();
        duo = golfClub + "_" + compName;



            btnSearch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (txtCompName.getText().toString().equals("") || txtGolfClub.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter Competition Details", Toast.LENGTH_SHORT).show();
                    } else {
                        String golfClub = txtGolfClub.getText().toString();
                        String compName = txtCompName.getText().toString();
                        duo = golfClub + "_" + compName;
                        Query lastQuery = reference.child("Results" + "/" + duo).orderByChild("Score").limitToFirst(50);
                        listRes = new listResults();
                        list = new ArrayList<>();
                        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.results_info, list);
                        lastQuery.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                    listRes = ds.getValue(listResults.class);
                                    list.add(listRes.getName() + ":   " + listRes.getScore() + " points");

                                }
                                Collections.reverse(list);
                                lstResults.setAdapter(adapter);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            });

    }
}
