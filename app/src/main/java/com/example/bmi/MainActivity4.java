package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bmi.Classes.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {
    private EditText user_weight,user_length,user_birth;
    private RadioGroup user_gender;
    private Button btn_saveDataUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user_gender = findViewById(R.id.radio_gender);
        user_weight = findViewById(R.id.user_weight);
        user_length = findViewById(R.id.user_length);
        user_birth = findViewById(R.id.user_birth);

        mAuth = FirebaseAuth.getInstance();

        btn_saveDataUser = findViewById(R.id.btn_saveDataUser);
        btn_saveDataUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeUserData();
            }
        });

    }

    private void storeUserData(){
        Double weight = Double.parseDouble((user_weight.getText().toString().trim()));
        Double length = Double.parseDouble((user_length.getText().toString().trim()));
        String birth = user_birth.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        reference.child(mAuth.getCurrentUser().getUid()).child("weight").setValue(weight);
        reference.child(mAuth.getCurrentUser().getUid()).child("length").setValue(length);
        reference.child(mAuth.getCurrentUser().getUid()).child("birth").setValue(birth);

            Toast.makeText(MainActivity4.this, "Save data successfly", Toast.LENGTH_SHORT).show();




    }
}