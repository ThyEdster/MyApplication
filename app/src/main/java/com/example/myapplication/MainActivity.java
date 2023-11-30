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
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        userTypeRadioGroup = findViewById(R.id.userTypeRadioGroup);
        doctorRadioButton = findViewById(R.id.doctorRadioButton);
        patientRadioButton = findViewById(R.id.patientRadioButton);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which radio button was selected
                int selectedId = userTypeRadioGroup.getCheckedRadioButtonId();

                if (selectedId == doctorRadioButton.getId()) {
                    // Start the DoctorDashboardActivity
                    Intent intent = new Intent(MainActivity.this, DoctorDashBoardActivity.class);
                    startActivity(intent);
                } else if (selectedId == patientRadioButton.getId()) {
                    // Start the PatientDashboardActivity
                    Intent intent = new Intent(MainActivity.this, PatientDashBoardActivity.class);
                    startActivity(intent);
                } else {
                    // No selection made
                    Toast.makeText(MainActivity.this, "Please select a user type", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
