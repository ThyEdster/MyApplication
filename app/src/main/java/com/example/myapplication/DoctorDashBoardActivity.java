package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Button;

public class DoctorDashBoardActivity extends AppCompatActivity {

    private RadioGroup signInRegisterRadioGroup;
    private LinearLayout loginSection, registrationSection; // Added LinearLayout for sections
    private EditText doctorIdEditText, doctorSsnEditText; // Login UI Elements
    private EditText doctorRegistrationNameEditText, doctorRegistrationSpecialtyEditText;
    private EditText doctorRegistrationIdEditText, doctorRegistrationSsnEditText; // Registration UI Elements
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dash_board);

        // Initialize views for RadioGroup and Buttons
        signInRegisterRadioGroup = findViewById(R.id.signInRegisterRadioGroup);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        // Initialize LinearLayout sections
        loginSection = findViewById(R.id.loginSection);
        registrationSection = findViewById(R.id.registrationSection);

        // Initialize EditText views for login
        doctorIdEditText = findViewById(R.id.doctorIdEditText);
        doctorSsnEditText = findViewById(R.id.doctorSsnEditText);

        // Initialize EditText views for registration
        doctorRegistrationNameEditText = findViewById(R.id.doctorRegistrationNameEditText);
        doctorRegistrationSpecialtyEditText = findViewById(R.id.doctorRegistrationSpecialtyEditText);
        doctorRegistrationIdEditText = findViewById(R.id.doctorRegistrationIdEditText);
        doctorRegistrationSsnEditText = findViewById(R.id.doctorRegistrationSsnEditText);

        // Set up the RadioGroup listener
        signInRegisterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.signInRadioButton) {
                    loginSection.setVisibility(View.VISIBLE);
                    registrationSection.setVisibility(View.GONE);
                } else if (checkedId == R.id.registerRadioButton) {
                    registrationSection.setVisibility(View.VISIBLE);
                    loginSection.setVisibility(View.GONE);
                }
            }
        });
    }
}
