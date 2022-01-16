package com.example.bmi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmi.Classes.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import java.util.regex.Pattern;

public class MainActivityRegister extends AppCompatActivity{
    private DatabaseReference mDatabase,dbuser;
    private FirebaseAuth mAuth;
    private static final String TAG = "EmailPassword";
    EditText userNameEditText,emailEditText,passwordEditText,passwordConfirmationEditText;
     long maxId = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        //userName
         userNameEditText = findViewById(R.id.editTextTextPersonName);
        //email
         emailEditText = findViewById(R.id.editTextTextEmailAddress);
        //password
         passwordEditText = findViewById(R.id.editTextTextPassword);
        //passwordConfirmation
         passwordConfirmationEditText = findViewById(R.id.editTextrePassword2);
        String passwordConfirmation = passwordConfirmationEditText.getText().toString();
        //Button
        Button registerButton = findViewById(R.id.btn_register);
        registerButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            registerUser();
          }
          });

//        dbuser = FirebaseDatabase.getInstance().getReference().child("User");
//
//        dbuser.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    maxId = (snapshot.getChildrenCount());
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

    }

    private void registerUser(){

        String userName = userNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (userName.isEmpty()){
            userNameEditText.setError("Full name is required");
            userNameEditText.requestFocus();
            return;
        }
        if (email.isEmpty()){
            emailEditText.setError("Full email is required");
            emailEditText.requestFocus();
            return;
        }
        if (password.isEmpty()){
            passwordEditText.setError("Full password is required");
            passwordEditText.requestFocus();
            return;
        }
        if(password.length() < 6){
            passwordEditText.setError("Min password length should 6 characters");
            passwordEditText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide valid email");
            emailEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User();
                            user.setName(userName);
                            user.setEmail(email);
                            user.setPassword(password);

                            FirebaseDatabase.getInstance().getReference("users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivityRegister.this, "user has been registered successflly", Toast.LENGTH_LONG).show();

                                    } else {
                                        Toast.makeText(MainActivityRegister.this, "Faild to register try again !", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(MainActivityRegister.this, "Faild to register try again !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
//
}