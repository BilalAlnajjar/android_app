package com.example.bmi;

import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int counter = 8000;
        CountDownTimer countDownTimer;
        countDownTimer = new CountDownTimer(counter,1000) {
            public void onTick(long millisUntilFinished){}
            public  void onFinish(){ }
        }.start();
        Intent intent = new Intent(MainActivity.this,MainActivity6.class);
        finish();
        startActivity(intent);

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivityLogin.class);
                finish();
                startActivity(intent);
            }
        });
    }
}