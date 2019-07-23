package com.example.nolan.golfappfyp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nolan.golfappfyp.Config.Config;
import com.google.firebase.database.ValueEventListener;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class paypal extends AppCompatActivity {

    public static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
    .clientId(Config.PAYPAL_CLIENT_ID);//sandbox because of test

    Button btnPayNow;
    EditText editAmount;
    TextView txtName, txtCompName;
    String Amount = "", golfClub, name, compName;
    int hCap;


    protected void OnDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paypal);


        //Start Payment Activity
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intent);


        btnPayNow = (Button) findViewById(R.id.btnPayNow);
        editAmount = (EditText) findViewById(R.id.editAmount);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompName = (TextView) findViewById(R.id.txtCompName);

        Intent i = getIntent();
        txtName.setText(i.getStringExtra("name"));
        golfClub = i.getStringExtra("courseName");
        txtCompName.setText(i.getStringExtra("compName"));
        editAmount.setText(i.getStringExtra("price"));
        Bundle extras = getIntent().getExtras();
        String handicap = extras.getString(("hCap"));
        hCap = Integer.parseInt(handicap);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();


            }


        });


    }
    private void processPayment() {
            Amount = editAmount.getText().toString();
            name = txtName.getText().toString();
            compName = txtCompName.getText().toString();
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(Amount)), "EUR",
                "Pay For Today's Competition", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PAYPAL_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation != null)
                {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, PaymentDetails.class)
                                                .putExtra("PaymentDetails",paymentDetails)
                                                .putExtra("PaymentAmount", Amount)
                                                .putExtra("name", name)
                                                .putExtra ( "courseName", golfClub)
                                                .putExtra ( "compName", compName)
                                                .putExtra ( "hCap", hCap + ""));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        }
    }
}
