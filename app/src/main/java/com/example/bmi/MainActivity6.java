package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bmi.Classes.Record;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.example.bmi.Classes.User;

import java.io.Console;

public class MainActivity6 extends AppCompatActivity {

    private EditText record_weight,record_length,record_date;
    private RadioGroup user_gender;
    private Button btn_saveRecord;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
     long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mAuth = FirebaseAuth.getInstance();

        btn_saveRecord = findViewById(R.id.btn_saveRecord);
        btn_saveRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeRecordData();
            }
        });

    }

    private void storeRecordData(){
        record_weight = findViewById(R.id.record_weight);
        record_length = findViewById(R.id.record_length);
        record_date = findViewById(R.id.record_date);

        reference = FirebaseDatabase.getInstance().getReference().child("Records");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    maxid = (snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mAuth = FirebaseAuth.getInstance();
        Record record = new Record();
        Double weight = Double.parseDouble((record_weight.getText().toString().trim()));
        Double length = Double.parseDouble((record_length.getText().toString().trim()));
        String date = record_date.getText().toString().trim();

        record.setDate(date);
        record.setLength(length);
        record.setWeight(weight);

        reference.child(String.valueOf(maxid+1)).setValue(record);
        Toast.makeText(MainActivity6.this, "Save data record successfly", Toast.LENGTH_SHORT).show();




    }
}