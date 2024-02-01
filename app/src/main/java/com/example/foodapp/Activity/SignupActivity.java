package com.example.foodapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends BaseActivity {
ActivitySignupBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }
        private void setVariable() {
        binding.signupBtn.setOnClickListener(v -> {
            String email=binding.userEdt.getText().toString();
            String password=binding.passEdt.getText().toString();

            if(password.length()<8){
                Toast.makeText(SignupActivity.this,"you password must be 8 character",Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignupActivity.this, task -> {
                if(task.isSuccessful()){
                    Log.i(TAG,"onComplete: ");
                    startActivities(new Intent[]{new Intent(SignupActivity.this, MainActivity.class)});
                }else {
                    Log.i(TAG,"No chance: ",task.getException());
                    Toast.makeText(SignupActivity.this,"Authentication failed",Toast.LENGTH_SHORT).show();
                }
            });

        });
            binding.accountt.setOnClickListener(v -> {
                FirebaseAuth.getInstance().signOut();
                startActivities(new Intent[]{new Intent(SignupActivity.this, LoginActivity.class)});
            });

        }
    }
