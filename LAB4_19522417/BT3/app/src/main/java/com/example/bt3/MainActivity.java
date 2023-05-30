package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import android.widget.Toast;


import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_PERMISSION_CAMERA = 2;
    private static final int CONTENT_REQUEST = 3;

    private ImageView profileImage;
    private Button changeButton;
    private EditText fullNameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private RadioButton maleRadioButton;
    private RadioButton femaleRadioButton;
    private Button saveButton;
    private Button cancelButton;

    private File output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileImage = findViewById(R.id.profileImage);
        changeButton = findViewById(R.id.changeButton);
        fullNameEditText = findViewById(R.id.fullNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        maleRadioButton = findViewById(R.id.maleRadioButton);
        femaleRadioButton = findViewById(R.id.femaleRadioButton);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCameraPermission();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserData();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        loadUserData();
    }

    private void requestCameraPermission() {
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION_CAMERA);
        } else {
            openCamera();
        }
    }

    private void openCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        output = new File(dir, "CameraDemo.jpeg");
        i.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));
        startActivityForResult(i, CONTENT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CONTENT_REQUEST && resultCode == RESULT_OK) {
            Uri imageUri = Uri.fromFile(output);
            profileImage.setImageURI(imageUri);
        }
    }

    private void saveUserData() {
        String fullName = fullNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String gender = maleRadioButton.isChecked() ? "Male" : "Female";

        try {
            File userDataFile = new File(getFilesDir(), "userData.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(userDataFile));

            writer.write(fullName);
            writer.newLine();
            writer.write(email);
            writer.newLine();
            writer.write(phone);
            writer.newLine();
            writer.write(gender);

            writer.close();

            Toast.makeText(this, "Save the information successfully", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUserData() {
        File userDataFile = new File(getFilesDir(), "userData.txt");
        if (userDataFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(userDataFile));

                String fullName = reader.readLine();
                String email = reader.readLine();
                String phone = reader.readLine();
                String gender = reader.readLine();

                fullNameEditText.setText(fullName);
                emailEditText.setText(email);
                phoneEditText.setText(phone);
                if (gender.equals("Male")) {
                    maleRadioButton.setChecked(true);
                } else if (gender.equals("Female")) {
                    femaleRadioButton.setChecked(true);
                }

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}