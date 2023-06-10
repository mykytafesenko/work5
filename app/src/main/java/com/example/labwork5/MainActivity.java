package com.example.labwork5;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator rotationAnimation;
    private boolean isAnimationRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);

        Keyframe kf0 = Keyframe.ofFloat(0, 0);
        Keyframe kf1 = Keyframe.ofFloat(1, 360);
        Keyframe kf2 = Keyframe.ofFloat(2, 0);
        PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
        rotationAnimation = ObjectAnimator.ofPropertyValuesHolder(button, pvhRotation);
        rotationAnimation.setDuration(5000);
        rotationAnimation.setRepeatCount(ValueAnimator.INFINITE);
        rotationAnimation.setRepeatMode(ValueAnimator.RESTART);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnimationRunning) {
                    rotationAnimation.cancel();
                    isAnimationRunning = false;
                } else {
                    rotationAnimation.start();
                    isAnimationRunning = true;
                }
            }
        });
    }
}