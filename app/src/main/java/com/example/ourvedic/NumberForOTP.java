package com.example.ourvedic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NumberForOTP extends AppCompatActivity {

    private EditText pnumber;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_for_o_t_p);

        init();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateotp();
            }
        });
    }

    private void generateotp() {
        String phoneNumber ="+91"+pnumber.getText().toString().trim();
        Log.e("errorres",phoneNumber);
        if (TextUtils.isEmpty(phoneNumber)){
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
        } else {
            SharedPreferences sharedPreferences = getSharedPreferences("number", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("number",pnumber.getText().toString());
            editor.commit();
            Intent intent = new Intent(NumberForOTP.this, OTPVerify.class);
            intent.putExtra("number",phoneNumber);
            startActivity(intent);
            finish();
        }
    }

    private void init() {
        pnumber = findViewById(R.id.p3e1);
        submit = findViewById(R.id.p3b1);
    }
}