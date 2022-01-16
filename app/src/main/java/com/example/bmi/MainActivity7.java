package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bmi.Classes.Food;
import com.example.bmi.Classes.Record;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity7 extends AppCompatActivity {

    private EditText name_food,category,calory;
    private RadioGroup user_gender;
    private Button btn_saveFood,update_photo_food;
    private FirebaseAuth mAuth;
    private DatabaseReference reference;
    long maxid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mAuth = FirebaseAuth.getInstance();

        btn_saveFood = findViewById(R.id.btn_saveRecord);
        btn_saveFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeRecordData();
            }
        });

    }

    private void storeRecordData(){
        name_food = findViewById(R.id.name_food);
        category = findViewById(R.id.category);
        calory = findViewById(R.id.calory);

        reference = FirebaseDatabase.getInstance().getReference().child("Foods");
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
        Food food = new Food();
        String name = name_food.getText().toString().trim();
        String cate = category.getText().toString().trim();
        String calo = calory.getText().toString().trim();

        food.setName_food(name);
        food.setCalory(cate);
        food.setCalory(calo);

        reference.child(String.valueOf(maxid+1)).setValue(food);
        Toast.makeText(MainActivity7.this, "Save data Food successfly", Toast.LENGTH_SHORT).show();




    }
}