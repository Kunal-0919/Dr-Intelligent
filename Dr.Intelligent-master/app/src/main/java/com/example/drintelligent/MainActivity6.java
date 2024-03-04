package com.example.drintelligent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity6 extends AppCompatActivity {
    private ProgressBar bar;
    Handler handler = new Handler();
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        bar = (ProgressBar) findViewById(R.id.progressBar);

        new Thread(new Runnable() {

            int i = 0;
            int progressStatus = 0;

            public void run() {
                while (progressStatus < 100) {
                    progressStatus += doWork();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        public void run() {
                            bar.setProgress(progressStatus);
                            i++;
                        }
                    });
                }
            }
            private int doWork() {

                return i * 3;
            }

        }).start();

        mHandler.postDelayed(new Runnable() {
            public void run() {
                doStuff();
            }
        }, 5000);
    }

    private void doStuff() {
        Intent intent = new Intent(this, MainActivity7.class);

        startActivity(intent);
    }


}