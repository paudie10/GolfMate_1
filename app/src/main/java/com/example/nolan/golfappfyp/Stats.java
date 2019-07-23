package com.example.nolan.golfappfyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stats extends AppCompatActivity {
    ListView lvGIR, lvFH, lvPutts;
    TextView txtAverage, txtBest, txtWorst;
    DatabaseReference reference;
    ArrayList<String> list;
    ArrayList<String> list_1;
    ArrayList<String> list_2;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter_1;
    ArrayAdapter<String> adapter_2;
    listGIR lvgir;
    listFH lvfh;
    listPutts lvputts;

    double avg, avgFront9, avgBack9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        lvGIR = (ListView) findViewById(R.id.lvGIR);
        lvPutts = (ListView) findViewById(R.id.lvPutts);
        txtAverage = (TextView) findViewById(R.id.txtAverage);
        txtBest = (TextView) findViewById(R.id.txtBest);
        txtWorst = (TextView) findViewById(R.id.txtWorst);
        lvFH = (ListView) findViewById(R.id.lvFH);
        reference = FirebaseDatabase.getInstance().getReference();
        //https://www.youtube.com/watch?v=MP3tialkL2Y

        Query girQuery = reference.child("Stats/Paudie Nolan/GIR");
        lvgir = new listGIR();
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.results_info, list);
        girQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    lvgir = ds.getValue(listGIR.class);
                    list.add(lvgir.getCompName() + "  " + lvgir.getGIR() + "/18");

                }
                lvGIR.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query fhQuery = reference.child("Stats/Paudie Nolan/FH");
        lvfh = new listFH();
        list_1 = new ArrayList<>();
        adapter_1 = new ArrayAdapter<String>(getApplicationContext(), R.layout.results_info, list_1);
        fhQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    lvfh = ds.getValue(listFH.class);
                    list_1.add(lvfh.getCompName() + "  " + lvfh.getFH() + "/18");

                }
                lvFH.setAdapter(adapter_1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query puttsQuery = reference.child("Stats/Paudie Nolan/Putts");
        lvputts = new listPutts();
        list_2 = new ArrayList<>();
        adapter_2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.results_info, list_2);
        puttsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    lvputts = ds.getValue(listPutts.class);
                    list_2.add(lvputts.getCompName() + "  " + lvputts.getPutts() + " putts");

                }
                lvPutts.setAdapter(adapter_2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query avgQuery = reference.child("Stats/Paudie Nolan/Scores/Overall");
        avgQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int total = 0, count = 0;
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    int score = ds.child("Score").getValue(Integer.class);
                    total = total + score;
                    count = count + 1;
                }
                avg = total/count;
                //https://stackoverflow.com/questions/20596848/setting-the-text-field-using-settext-method-with-a-double-value-java-gui
                String avgString = String.valueOf(avg);
                txtAverage.setText("Your Average: " + " " + avgString);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query front9Query = reference.child("Stats/Paudie Nolan/Scores/front9");
        front9Query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int total = 0, count = 0;
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    int score = ds.child("Score").getValue(Integer.class);
                    total = total + score;
                    count = count + 1;
                }
                avgFront9 = total/count;
                //https://stackoverflow.com/questions/20596848/setting-the-text-field-using-settext-method-with-a-double-value-java-gui
                String avgFront9String = String.valueOf(avgFront9);
                txtBest.setText("Your Average Front 9: " + " " + avgFront9String);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Query back9Query = reference.child("Stats/Paudie Nolan/Scores/back");
        back9Query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int total = 0, count = 0;
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    int score = ds.child("Score").getValue(Integer.class);
                    total = total + score;
                    count = count + 1;
                }
                avgBack9 = total/count;
                //https://stackoverflow.com/questions/20596848/setting-the-text-field-using-settext-method-with-a-double-value-java-gui
                String avgBack9String = String.valueOf(avgBack9);
                txtWorst.setText("Your Average Back 9: " + " " + avgBack9String);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
