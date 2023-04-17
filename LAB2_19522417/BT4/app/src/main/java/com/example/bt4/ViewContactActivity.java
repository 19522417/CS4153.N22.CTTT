package com.example.bt4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ViewContactActivity extends MainActivity {
    TextView txt_name, txt_email, txt_project;

    Button btn_ct;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactinfo);

        txt_name =findViewById(R.id.txt_name);
        txt_email =findViewById(R.id.txt_email);
        txt_project =findViewById(R.id.txt_project);
        btn_ct = findViewById(R.id.btn_ct);
        btn_ct.setOnClickListener(mClickFinish);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name1");
        String email = bundle.getString("email1");
        String project = bundle.getString("project1");

        txt_name.setText(name);
        txt_email.setText(email);
        txt_project.setText(project);
    }
    private View.OnClickListener mClickFinish = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
