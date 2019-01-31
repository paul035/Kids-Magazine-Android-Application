package com.example.android.magazines;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button homeBtn;
    private CardView bookCard, musicsCard, videosCard,  drawingbookCard, gamesCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeBtn = (Button) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });

        bookCard = (CardView) findViewById(R.id.books_card);
        bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookActivity();
            }
        });

        musicsCard = (CardView) findViewById(R.id.musics_card);
        musicsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMusicsActivity();
            }
        });

        videosCard = (CardView) findViewById(R.id.videos_card);
        videosCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVideosActivity();
            }
        });

        drawingbookCard = (CardView) findViewById(R.id.drawingbook_card);
        drawingbookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawingBookActivity();
            }
        });

        gamesCard = (CardView) findViewById(R.id.game_card);
        gamesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameActivity();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private void openHomeActivity() {
        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(intent);

    }

    private void openBookActivity() {
        Intent intent = new Intent(MainActivity.this, BookActivity.class);
        startActivity(intent);
    }

    private void startMusicsActivity() {
        Intent intent = new Intent(MainActivity.this, MusicActivity.class);
        startActivity(intent);
    }

    private void openVideosActivity() {
        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
        startActivity(intent);
    }

    private void openDrawingBookActivity() {
        Intent intent = new Intent(MainActivity.this, DrawingBookActivity.class);
        startActivity(intent);
    }

    private void openGameActivity() {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }

}
