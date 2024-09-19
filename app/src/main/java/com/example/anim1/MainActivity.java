package com.example.anim1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    Animation fadeInAnimation;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button_frame_animation);
        button2 = findViewById(R.id.button_tween_animation);

        fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        button1.startAnimation(fadeInAnimation);
        button2.startAnimation(fadeInAnimation);

        button1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left); // Переход с анимацией
        });

        button2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity3.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down); // Переход с анимацией
        });
    }
}
