package com.example.android.magazines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountBookActivity extends AppCompatActivity {

    private EditText mTextBook, mTitle;
    private Button mDismiss, mSubmit;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_book);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User");

        mTextBook = (EditText) findViewById(R.id.mTextBook);
        mTitle = (EditText) findViewById(R.id.mTitle);

        mDismiss = (Button) findViewById(R.id.mDismiss);
        mDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTextBook.getText().clear();
            }
        });

        mSubmit = (Button) findViewById(R.id.mSubmit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = mTextBook.getText().toString().trim();
                String title = mTitle.getText().toString().trim();
                Print(title, value);
            }
        });
    }

    private void Print(String title, String value) {
        String user_id = mAuth.getUid();
        DatabaseReference current_user_db = mDatabase.child(user_id);
       current_user_db.child(title).setValue(value);
    }
}
