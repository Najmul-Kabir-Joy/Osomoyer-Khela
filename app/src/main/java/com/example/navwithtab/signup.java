package com.example.navwithtab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    EditText musername,memail,mphone,mpassword;
    Button signin,signup;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        musername = findViewById(R.id.username);
        memail = findViewById(R.id.email);
        mphone = findViewById(R.id.phone);
        mpassword = findViewById(R.id.pass);

        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);

        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);

        btn_signin = findViewById(R.id.btn_signin);

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            finish();
        }





        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    memail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mpassword.setError("Password is Required");
                    return;
                }
                if (password.length() < 6){
                    mpassword.setError("Password Must be more than 5 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //regoster user in firebase

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signup.this, "Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }else {
                            Toast.makeText(signup.this, "Error!!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);

                        }

                    }
                });

            }
        });

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),login.class));
            }
        });

    }
}