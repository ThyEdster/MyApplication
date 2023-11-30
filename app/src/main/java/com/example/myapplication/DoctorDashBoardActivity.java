package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;

public class DoctorDashBoardActivity extends AppCompatActivity {

    private RadioGroup signInRegisterRadioGroup;
    private EditText doctorIdEditText, doctorSsnEditText;  // Login UI Elements
    private EditText doctorNameEditText, doctorSpecialtyEditText; // Registration UI Elements
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dash_board);

        // Find UI elements by ID
        signInRegisterRadioGroup = findViewById(R.id.signInRegisterRadioGroup);
        doctorIdEditText = findViewById(R.id.doctorIdEditText);
        doctorSsnEditText = findViewById(R.id.doctorSsnEditText);
        doctorNameEditText = findViewById(R.id.doctorNameEditText);
        doctorSpecialtyEditText = findViewById(R.id.doctorSpecialtyEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        // Set up the listener for the RadioGroup
        signInRegisterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.signInRadioButton) {
                    // Show login UI elements, hide registration UI elements
                    doctorIdEditText.setVisibility(View.VISIBLE);
                    doctorSsnEditText.setVisibility(View.VISIBLE);
                    loginButton.setVisibility(View.VISIBLE);

                    doctorNameEditText.setVisibility(View.GONE);
                    doctorSpecialtyEditText.setVisibility(View.GONE);
                    registerButton.setVisibility(View.GONE);
                } else if (checkedId == R.id.registerRadioButton) {
                    // Show registration UI elements, hide login UI elements
                    doctorIdEditText.setVisibility(View.GONE);
                    doctorSsnEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);

                    doctorNameEditText.setVisibility(View.VISIBLE);
                    doctorSpecialtyEditText.setVisibility(View.VISIBLE);
                    registerButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
