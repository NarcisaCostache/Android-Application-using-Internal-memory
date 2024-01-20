package com.example.sportfieldsproj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edTxtUsername, edTxtPassword;
    Button btn;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edTxtUsername=findViewById(R.id.editTextEmail);
        edTxtPassword=findViewById(R.id.editTextPassword);
        btn=findViewById(R.id.btnSignIn);
        txtView=findViewById(R.id.textViewSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username=edTxtUsername.getText().toString();
                String Password=edTxtPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"SportFields", null, 1);

                if(Username.length()==0 || Password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all details", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(db.login(Username,Password)==1){
                        Toast.makeText(getApplicationContext(),"Login succedded", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                    } else{
                        Toast.makeText(getApplicationContext(),"Invalid Email and Password", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use an explicit intent
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

            }
        });




    }
}