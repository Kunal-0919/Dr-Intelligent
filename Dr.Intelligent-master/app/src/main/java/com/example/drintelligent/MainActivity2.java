package com.example.drintelligent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openSignIn();
            }
        });

        Button btn2 = findViewById(R.id.button4);
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                openSignUp();
            }
        });
    }
    private void openSignIn() {
        Toast.makeText(getApplicationContext(),"Sign in",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    private void openSignUp() {
        Toast.makeText(getApplicationContext(),"Sign up",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }
}