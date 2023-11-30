package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;

public class DoctorDashBoardActivity extends AppCompatActivity {

    private RadioGroup signInRegisterRadioGroup;
    private EditText doctorIdEditText, doctorSsnEditText; // Login UI Elements
    private EditText doctorRegistrationNameEditText, doctorRegistrationSpecialtyEditText; // Registration UI Elements
    private Button loginButton, registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dash_board);

        // Initialize views
        signInRegisterRadioGroup = findViewById(R.id.signInRegisterRadioGroup);
        doctorIdEditText = findViewById(R.id.doctorIdEditText);
        doctorSsnEditText = findViewById(R.id.doctorSsnEditText);
        doctorRegistrationNameEditText = findViewById(R.id.doctorRegistrationNameEditText); // Updated ID
        doctorRegistrationSpecialtyEditText = findViewById(R.id.doctorRegistrationSpecialtyEditText); // Updated ID
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        // Set up the RadioGroup listener
        signInRegisterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.signInRadioButton) {
                    // Show login UI elements, hide registration UI elements
                    doctorIdEditText.setVisibility(View.VISIBLE);
                    doctorSsnEditText.setVisibility(View.VISIBLE);
                    loginButton.setVisibility(View.VISIBLE);

                    doctorRegistrationNameEditText.setVisibility(View.GONE);
                    doctorRegistrationSpecialtyEditText.setVisibility(View.GONE);
                    registerButton.setVisibility(View.GONE);
                } else if (checkedId == R.id.registerRadioButton) {
                    // Show registration UI elements, hide login UI elements
                    doctorIdEditText.setVisibility(View.GONE);
                    doctorSsnEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);

                    doctorRegistrationNameEditText.setVisibility(View.VISIBLE);
                    doctorRegistrationSpecialtyEditText.setVisibility(View.VISIBLE);
                    registerButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
