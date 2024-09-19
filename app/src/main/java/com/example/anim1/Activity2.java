package com.example.anim1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    ImageView imageView;
    Animation fadeInAnimation, rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        imageView = findViewById(R.id.imageView);

        // Анимация появления элементов
        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        imageView.startAnimation(fadeInAnimation);

        // Tween animation (rotate)
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView.startAnimation(rotateAnimation);

        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(Activity2.this, MainActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_up); // Переход с анимацией
        });
    }
}
