package com.example.fanregulator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnrclock;
    private Button btnrantick;
    private Button btnspeedup;
    private Button btnspeeddown;
    private Button btnStop;
    private ImageView img;
    private float fromDegrees;
    private float toDegrees;
    private int duration=1000;
    private TextView txtView;
    private RotateAnimation rotate = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnrclock = (Button)findViewById(R.id.btnRClk);
        btnrantick = (Button)findViewById(R.id.btnRAClk);
        btnspeedup = (Button) findViewById(R.id.btnUpSpeed);
        btnspeeddown = (Button) findViewById(R.id.btnDownSpeed);
        btnStop = (Button) findViewById(R.id.btnStop);
        txtView = (TextView) findViewById(R.id.txtView);
        img = (ImageView)findViewById(R.id.imgvw);

        btnspeedup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duration = duration - 200;
                if(duration == 0){
                    duration = 200;
                    txtView.setText("Speed is maximum!!!");
                    txtView.setVisibility(View.VISIBLE);
                    txtView.postDelayed(new Runnable() {
                        public void run() {
                            txtView.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }
                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotate);
            }
        });

        btnspeeddown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duration = duration + 200;
                if(duration == 2000){
                    duration = 1800;
                    txtView.setText("Speed is minimum!!!");
                    txtView.setVisibility(View.VISIBLE);
                    txtView.postDelayed(new Runnable() {
                        public void run() {
                            txtView.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }
                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotate);
            }
        });

        btnrclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDegrees = 0;
                toDegrees = 360;
                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotate);
            }
        });

        btnrantick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDegrees = 360;
                toDegrees = 0;
                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotate);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromDegrees=0;
                toDegrees=0;
                rotate = new RotateAnimation(fromDegrees, toDegrees, Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(duration);
                rotate.setInterpolator(new LinearInterpolator());
                rotate.setRepeatCount(Animation.INFINITE);
                img.startAnimation(rotate);
            }
        });
    }
}