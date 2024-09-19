package com.example.anim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    View view;
    Animation fadeInAnimation, rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        view = findViewById(R.id.view);

        // Анимация появления элементов
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        view.startAnimation(fadeInAnimation);

        // Tween animation (rotate)
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        view.startAnimation(rotateAnimation);

        view.setOnClickListener(view -> {
            Intent intent = new Intent(String.valueOf(MainActivity.class));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_up); // Переход с анимацией
        });
    }
}
