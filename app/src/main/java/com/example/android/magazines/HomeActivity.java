package com.example.android.magazines;

import android.accounts.Account;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private EditText mLoginNameField;
    private EditText mLoginPasswordField;
    private Button mLoginBtn, cancelBtn;
    private Button regBtn, learn_more;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

   /* private Button regBtn, loginBtn, cancelBtn;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        mLoginNameField = (EditText) findViewById(R.id.loginNameField);
        mLoginPasswordField = (EditText) findViewById(R.id.loginPasswordField);

        mLoginBtn = (Button) findViewById(R.id.loginBtn);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!= null){
                    startActivity(new Intent(HomeActivity.this, AccountActivity.class));
                }
            }
        };


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Log in...", Toast.LENGTH_SHORT).show();
                startSignIn();
            }
        });


        regBtn = (Button) findViewById(R.id.regBtn);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegistrationActivity();
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startSignIn() {
        String email = mLoginNameField.getText().toString().trim();
        String password = mLoginPasswordField.getText().toString().trim();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            Toast.makeText(HomeActivity.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(HomeActivity.this, "Sign in problem", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }

    private void startRegistrationActivity() {
        Intent intent = new Intent(HomeActivity.this, RegActivity.class);
        startActivity(intent);
    }

    private void cancelActivity() {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
