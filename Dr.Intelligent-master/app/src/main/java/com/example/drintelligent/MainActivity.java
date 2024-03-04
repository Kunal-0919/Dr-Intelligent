package com.example.drintelligent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(getApplicationContext(),"Application Started",Toast.LENGTH_SHORT).show();
        Button btn = findViewById(R.id.button_join);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

    }

    private void openActivity2() {
        Toast.makeText(getApplicationContext(),"Joined",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}