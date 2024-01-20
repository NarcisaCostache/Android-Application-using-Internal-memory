package com.example.sportfieldsproj2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText edTxtUsername, edTxtPassword, edTxtEmail, edConfPass;
    Button btn;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edTxtUsername=findViewById(R.id.editTextName);
        edTxtEmail=findViewById(R.id.editTextRegEmail);
        edTxtPassword=findViewById(R.id.editTextRegPassword);
        edConfPass=findViewById(R.id.editTextConfPassword);
        btn=findViewById(R.id.btnSignUp);
        txtView=findViewById(R.id.textViewSignIn);

        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = edTxtUsername.getText().toString();
                String Email = edTxtEmail.getText().toString();
                String ConfPass = edConfPass.getText().toString();
                String Password = edTxtPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"SportFields", null, 1);
                if (Name.length() == 0 || Email.length() == 0 || Password.length() == 0 || ConfPass.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_LONG).show();
                } else {
                    if (Password.compareTo(ConfPass) == 0) {
                        if (isValid(Password)){
                            db.register(Name, Email, Password);
                            Toast.makeText(getApplicationContext(), "Recistered successfully", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                        }else {
                            Toast.makeText(getApplicationContext(), "Passwords must have at least 8 characters, a letter, digit and special symbol", Toast.LENGTH_LONG).show();
                        }


                    } else {
                        Toast.makeText(getApplicationContext(), "Passwords didn't mach", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }
    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (passwordhere.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < passwordhere.length(); r++) {
                if (Character.isDigit(passwordhere.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < passwordhere.length(); s++) {
                char c = passwordhere.charAt(s);
                if (c>=33&&c<=46||c==64) {
                    f3 = 1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }

    }

}