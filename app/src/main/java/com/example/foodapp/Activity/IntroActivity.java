package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {
ActivityIntroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
        getWindow().setStatusBarColor(Color.parseColor("#FFE4B5"));
    }
    private void setVariable(){
        binding.loginBtn.setOnClickListener(v -> {
            if(mAuth.getCurrentUser()!=null){
                startActivities(new Intent[]{new Intent(IntroActivity.this, MainActivity.class)});
               }else{
                startActivities(new Intent[]{new Intent(IntroActivity.this, LoginActivity.class)});
           }
        });
        binding.signupBtn.setOnClickListener(v -> startActivities(new Intent[]{new Intent(IntroActivity.this, SignupActivity.class)}));
    }

}