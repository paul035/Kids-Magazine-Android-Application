package com.example.android.magazines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DrawingBookActivity extends AppCompatActivity {

    private CanvasView canvasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_book);

        canvasView = (CanvasView) findViewById(R.id.canvas);
    }

    public void clearCanvas(View view){
        canvasView.clearCanvas();
    }
}
