package com.example.nolan.golfappfyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentDetails extends AppCompatActivity {
    TextView txtID, txtAmount, txtStatus, txtName, txtHcap;
    Button btnContinue;
    String golfClub, compName, name;
    int hCap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtID = (TextView) findViewById(R.id.txtID);
        txtAmount = (TextView) findViewById(R.id.txtAmount);
        txtStatus = (TextView) findViewById(R.id.txtStatus);
        txtName = (TextView) findViewById(R.id.txtName);
        btnContinue = (Button) findViewById(R.id.btnContinue);

        Intent intent = getIntent();


        txtName.setText(intent.getStringExtra("name"));
        golfClub = intent.getStringExtra("courseName");
        compName = intent.getStringExtra("compName");
        String handicap = intent.getStringExtra("hCap");
        hCap = Integer.parseInt(handicap);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtName.getText().toString();

                Intent myIntent = new Intent(PaymentDetails.this, stableford_hole1.class);
                myIntent.putExtra ( "name", name);
                myIntent.putExtra ( "courseName", golfClub);
                myIntent.putExtra ( "compName", compName);

                Bundle extras = new Bundle();
                extras.putString("hCap", hCap + "");
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });




        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showDetails(JSONObject response, String paymentAmount) {
        try {
            txtID.setText(response.getString("id"));
            txtStatus.setText(response.getString("state"));
            txtAmount.setText("€" + paymentAmount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
