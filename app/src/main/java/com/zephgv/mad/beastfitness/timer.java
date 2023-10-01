package com.zephgv.mad.beastfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;




import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class timer extends AppCompatActivity {

        private ImageView imageView;
        private Button startButton;
        private Button stopButton;
        private TextView timerTextView;
        private CountDownTimer countDownTimer;
        private String content;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_timer);



            imageView = (ImageView) findViewById(R.id.imageView);
            startButton = (Button) findViewById(R.id.startButton);
            stopButton = (Button) findViewById(R.id.stopButton);
            timerTextView = (TextView) findViewById(R.id.timerTextView);



            content = getIntent().getStringExtra("content");



            startButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countDownTimer = new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            timerTextView.setText(String.format("%02d:%02d:%02d", millisUntilFinished / 3600000, (millisUntilFinished / 60000) % 60, (millisUntilFinished / 1000) % 60));
                        }



                        @Override
                        public void onFinish() {
                            timerTextView.setText("00:00:00");
                        }
                    };
                    countDownTimer.start();



//                    if (content.equals("image1.png")) {
//                        imageView.setImageResource(R.drawable.image1);
//                    } else if (content.equals("image2.png")) {
//                        imageView.setImageResource(R.drawable.image2);
//                    }
                }
            });



            stopButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    countDownTimer.cancel();
                }
            });
        }
    }