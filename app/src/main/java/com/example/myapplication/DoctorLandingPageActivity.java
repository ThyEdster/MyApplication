package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoctorLandingPageActivity extends AppCompatActivity {

    private Button checkAppointmentsButton;
    private Button writePrescriptionButton;
    private Button checkPrescriptionStatusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_landing_page);

        // Initialize buttons
        checkAppointmentsButton = findViewById(R.id.checkAppointmentsButton);
        writePrescriptionButton = findViewById(R.id.writePrescriptionButton);
        checkPrescriptionStatusButton = findViewById(R.id.checkPrescriptionStatusButton);

        // Setup listeners for the buttons
        checkAppointmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo Implement functionality to check appointments
            }
        });

        writePrescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo Implement functionality to write prescriptions
            }
        });

        checkPrescriptionStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo Implement functionality to check prescription status
            }
        });
    }
}
