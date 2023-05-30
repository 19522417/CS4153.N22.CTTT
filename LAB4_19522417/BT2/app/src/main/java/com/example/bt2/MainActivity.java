package com.example.bt2;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private EditText editTextData;
    Button btnRead, btnWrite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRead = findViewById(R.id.btn_read);
        btnWrite = findViewById(R.id.btn_write);
        editTextData = findViewById(R.id.edt_content);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDataFromResource();
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDataFromResource();
            }
        });

    }

    private void readDataFromResource() {
        Resources res = getResources();
        InputStream inputStream = res.openRawResource(R.raw.myfile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editTextData.setText(stringBuilder.toString());
    }
    private void WriteDataFromResource() {
        Resources res = getResources();
        InputStream inputStream = res.openRawResource(R.raw.myfile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editTextData.setText(stringBuilder.toString());
    }
}