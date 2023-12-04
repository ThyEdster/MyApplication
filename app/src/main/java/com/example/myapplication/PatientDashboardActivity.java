package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.room.Room;

import com.example.myapplication.DB.AppDatabase;
import com.example.myapplication.DB.Patient;
import com.example.myapplication.DB.PatientDAO;

public class PatientDashboardActivity extends AppCompatActivity {
    private RadioGroup signInRegisterRadioGroup;
    private LinearLayout loginSection, registrationSection;
    private Button loginButton, registerButton;

    // Added EditText fields for login and registration
    private EditText patientIdEditText, patientSsnEditText; // Login UI Elements
    private EditText patientRegistrationNameEditText, patientRegistrationIdEditText, patientRegistrationSsnEditText; // Registration UI Elements

    // Room Database Instance
    private AppDatabase db;
    private PatientDAO patientDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dash_board);

        // Initialize views
        initializeViews();

        // Initialize Room Database and DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "my_database").allowMainThreadQueries().build();
        patientDao = db.patientDao();

        // Set up the RadioGroup listener to toggle between login and registration
        setupRadioGroupListener();

        // Setup button listeners
        setupButtonListeners();
    }

    private void initializeViews() {
        signInRegisterRadioGroup = findViewById(R.id.signInRegisterRadioGroup);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginSection = findViewById(R.id.loginSection);
        registrationSection = findViewById(R.id.registrationSection);

        // Initialize EditText views for login
        patientIdEditText = findViewById(R.id.patientIdEditText);
        patientSsnEditText = findViewById(R.id.patientSsnEditText);

        // Initialize EditText views for registration
        patientRegistrationNameEditText = findViewById(R.id.patientNameEditText);
        patientRegistrationIdEditText = findViewById(R.id.patientNewIdEditText);
        patientRegistrationSsnEditText = findViewById(R.id.patientNewSsnEditText);

        // Initialize the registerButton
        registerButton = findViewById(R.id.registerButton);
    }


    private void setupRadioGroupListener() {
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

    private void setupButtonListeners() {
        // Listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPatient();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPatient();
            }
        });

        // Listener for the register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerPatient();
            }
        });
    }

    private void loginPatient() {
        String patientId = patientIdEditText.getText().toString();
        String patientSsn = patientSsnEditText.getText().toString();

        // Authentication logic
        new Thread(new Runnable() {
            @Override
            public void run() {
                Patient patient = patientDao.findByIdAndSsn(patientId, patientSsn);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (patient != null) {
                            // Login successful
                            Intent intent = new Intent(PatientDashboardActivity.this, PatientLandingPageActivity.class);
                            intent.putExtra("PATIENT_ID", patientId);
                            startActivity(intent);
                        } else {
                            // Login failed
                            Toast.makeText(PatientDashboardActivity.this, "Invalid ID or SSN", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    private void registerPatient() {
        // Create a new patient instance
        final Patient newPatient = new Patient();
        newPatient.patientId = patientRegistrationIdEditText.getText().toString();
        newPatient.name = patientRegistrationNameEditText.getText().toString();
        newPatient.ssn = patientRegistrationSsnEditText.getText().toString();

        // Insert the patient in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    patientDao.insert(newPatient);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PatientDashboardActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PatientDashboardActivity.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }




}