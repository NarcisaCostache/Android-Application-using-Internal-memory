package com.example.sportfieldsproj2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    Button btnFb, btnBas, btnSw, btnTen, btnProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnBas=findViewById(R.id.btnBasketball);
        btnSw=findViewById(R.id.btnSwimmingPools);
        btnTen=findViewById(R.id.btnTennis);
        btnProfile=findViewById(R.id.btnProfile);
        init();


        btnBas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,BasketballActivity.class));

            }
        });
        btnSw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,SwimmingActivity.class));

            }
        });
        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,TennisActivity.class));

            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MyProfileActivity.class));

            }
        });

    }

    private void init() {
        Button btnFb=(Button) findViewById(R.id.btnFootball);

        btnFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,FootballActivity.class));

            }
        });
    }
}

