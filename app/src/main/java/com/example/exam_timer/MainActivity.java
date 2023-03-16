package com.example.exam_timer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView duration = findViewById(R.id.textView3);
        final TextView done = findViewById(R.id.textView4);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.done);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                duration.setText("Time "+String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                mediaPlayer.start();
                done.setText("Done");

            }
        }.start();





    }
}