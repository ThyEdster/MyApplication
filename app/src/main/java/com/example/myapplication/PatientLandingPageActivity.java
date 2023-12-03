package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientLandingPageActivity extends AppCompatActivity {

    private Button createAppointmentButton;
    private Button checkAppointmentStatusButton;
    private Button checkPrescriptionStatusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_landing_page);

        // Initialize buttons
        createAppointmentButton = findViewById(R.id.createAppointmentButton);
        checkAppointmentStatusButton = findViewById(R.id.checkAppointmentStatusButton);
        checkPrescriptionStatusButton = findViewById(R.id.checkPrescriptionStatusButton);

        // Setup listeners for the buttons
        createAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement functionality to create an appointment
            }
        });

        checkAppointmentStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement functionality to check appointment status
            }
        });

        checkPrescriptionStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Implement functionality to check prescription status
            }
        });
    }
}
