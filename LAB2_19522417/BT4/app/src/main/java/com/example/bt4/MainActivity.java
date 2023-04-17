package com.example.bt4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText edt1,edt2,edt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGet = new Intent(getApplicationContext(), ViewContactActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name1", edt1.getText().toString());
                bundle.putString("email1", edt2.getText().toString());

                bundle.putString("project1", edt3.getText().toString());
                iGet.putExtras(bundle);

                startActivity(iGet);

            }
        });
    }
}