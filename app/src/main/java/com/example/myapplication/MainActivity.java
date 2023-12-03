package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declare the UI components
    private RadioGroup userTypeRadioGroup;
    private RadioButton doctorRadioButton;
    private RadioButton patientRadioButton;
    private RadioButton adminRadioButton;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
        doctorRadioButton = findViewById(R.id.doctorRadioButton);
        patientRadioButton = findViewById(R.id.patientRadioButton);
        adminRadioButton = findViewById(R.id.adminRadioButton);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = userTypeRadioGroup.getCheckedRadioButtonId();

                if (selectedId == doctorRadioButton.getId()) {
                    Intent intent = new Intent(MainActivity.this, DoctorDashboardActivity.class);
                    startActivity(intent);
                } else if (selectedId == patientRadioButton.getId()) {
                    Intent intent = new Intent(MainActivity.this, PatientDashboardActivity.class);
                    startActivity(intent);
                } else if (selectedId == adminRadioButton.getId()) {
                    Intent intent = new Intent(MainActivity.this, AdministratorDashboardActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please select a user type", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
