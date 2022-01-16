package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity8 extends AppCompatActivity {

    private EditText edit_name_food, edit_category, edit_calory;
    private RadioGroup user_gender;
    private Button btn_edit_food, btn_edit_photo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main6);

            edit_name_food = findViewById(R.id.edit_name_food);
            edit_category = findViewById(R.id.edit_category);
            edit_calory = findViewById(R.id.edit_calory);

            mAuth = FirebaseAuth.getInstance();

            btn_edit_food = findViewById(R.id.btn_edit_food);
            btn_edit_food.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    storeFoodData();
                }
            });

        }
    }
    private void storeFoodData() {
        String name = edit_name_food.getText().toString().trim();
        String category = edit_category.getText().toString().trim();
        String calory = edit_calory.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Food");
        reference.child(mAuth.getCurrentUser().getUid()).child("name").setValue(name);
        reference.child(mAuth.getCurrentUser().getUid()).child("category").setValue(category);
        reference.child(mAuth.getCurrentUser().getUid()).child("calory").setValue(calory);

        Toast.makeText(MainActivity8.this, "Save data successfly", Toast.LENGTH_SHORT).show();
    }
}