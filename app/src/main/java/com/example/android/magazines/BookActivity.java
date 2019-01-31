package com.example.android.magazines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class BookActivity extends AppCompatActivity {

    private CardView mShortStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mShortStories = (CardView) findViewById(R.id.shortStories);
        mShortStories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, ShortSotriesActivity.class);
                startActivity(intent);

            }
        });
    }
}
