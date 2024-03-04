package com.example.drintelligent;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity5 extends AppCompatActivity {

    private static final int REQUEST_PICK_FILE = 1;
    private String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Button btn = findViewById(R.id.select_file);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openfilechooser(view);
            }
        });
        Button btn1 = findViewById(R.id.upload);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                newWindow();
            }
        });
    }



    int requestcode = 1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_PICK_FILE && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            String address = uri.getPath();
        }
    }
    public void openfilechooser(View view){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        startActivityForResult(intent, REQUEST_PICK_FILE);
    }
    private void newWindow() {
        Toast.makeText(this, "Uploading", Toast.LENGTH_SHORT).show();
        OkHttpClient client = new OkHttpClient();
        // replace `pdfFile` with the actual File object representing your PDF file
        File pdfFile = new File(address);
        //System.out.println(address);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("pdf", pdfFile.getName(),
                        RequestBody.create(MediaType.parse("application/pdf"), pdfFile))
                .build();

        // replace `url` with the URL of the server where you want to upload the file
        Request request = new Request.Builder()
                .url("http://your-server-url.com/upload")
                .post(requestBody)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            // process the server's response if needed
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent intent  = new Intent(getApplicationContext(), MainActivity6.class);
        startActivity(intent);
    }

}
