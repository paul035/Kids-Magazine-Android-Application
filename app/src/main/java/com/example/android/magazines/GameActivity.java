package com.example.android.magazines;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView rotateBottle;
    Button spinBtn;
    Random r;
    int angle;
    boolean restart =  false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        rotateBottle = (ImageView) findViewById(R.id.rotateBottle);
        spinBtn = (Button) findViewById(R.id.spinBtn);
        r = new Random();

        spinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(restart){
                    angle = angle % 360;
                    RotateAnimation rotateAnimation = new RotateAnimation(angle, 360,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(100);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    rotateBottle.startAnimation(rotateAnimation);
                    spinBtn.setText("Go");
                    restart = false;

                }
                else{
                    angle =  r.nextInt(360) +360;
                    RotateAnimation rotateAnimation = new RotateAnimation(0, angle,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(2000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

                    rotateBottle.startAnimation(rotateAnimation);
                    restart = true;
                    spinBtn.setText("Reset");

                }

            }
        });
    }
}
