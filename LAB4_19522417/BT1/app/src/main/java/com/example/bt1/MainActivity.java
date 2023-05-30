package com.example.bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.edt_read);
        final Button button = (Button) findViewById(R.id.btn_read);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data;
                InputStream in = getResources().openRawResource(R.raw.myfile);
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                BufferedReader bufferedInputStream = new BufferedReader(inputStreamReader);
                StringBuilder stringBuilder = new StringBuilder();
                if (in!=null)
                {
                    try {
                        while ((data = bufferedInputStream.readLine())!= null){
                            stringBuilder.append(data);
                            stringBuilder.append("\n");
                        }
                        in.close();
                        editText.setText(stringBuilder.toString());
                    }
                    catch (IOException exception){
                        Log.e("Error", exception.getMessage());
                    }
                }

            }
        });
    }
}