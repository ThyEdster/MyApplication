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
import com.example.myapplication.DB.Doctor;
import com.example.myapplication.DB.DoctorDAO;

public class DoctorDashboardActivity extends AppCompatActivity {

    private RadioGroup signInRegisterRadioGroup;
    private LinearLayout loginSection, registrationSection;
    private EditText doctorIdEditText, doctorSsnEditText;
    private EditText doctorRegistrationNameEditText, doctorRegistrationSpecialtyEditText;
    private EditText doctorRegistrationIdEditText, doctorRegistrationSsnEditText;
    private Button loginButton, registerButton;

    // Room Database Instance
    private AppDatabase db;
    private DoctorDAO doctorDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_dash_board);

        // Initialize views
        initializeViews();


        // Initialize Room Database and DAO
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "my_database").allowMainThreadQueries().build();
        doctorDao = db.doctorDao();

        // Set up the RadioGroup listener to toggle between login and registration
        setupRadioGroupListener();

        // Setup button listeners
        setupButtonListeners();
    }

    private void initializeViews() {
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
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerDoctor();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginDoctor();
            }
        });
    }

    private void loginDoctor() {
        String doctorId = doctorIdEditText.getText().toString();
        String doctorSsn = doctorSsnEditText.getText().toString();

        // Authentication logic
        new Thread(new Runnable() {
            @Override
            public void run() {
                Doctor doctor = doctorDao.findByIdAndSsn(doctorId, doctorSsn);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (doctor != null) {
                            // Login successful
                            Intent intent = new Intent(DoctorDashboardActivity.this, DoctorLandingPageActivity.class);
                            intent.putExtra("DOCTOR_ID", doctorId);
                            startActivity(intent);
                        } else {
                            // Login failed
                            Toast.makeText(DoctorDashboardActivity.this, "Invalid ID or SSN", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }).start();
    }

    private void registerDoctor() {
        // Create a new doctor instance
        final Doctor newDoctor = new Doctor();
        newDoctor.doctorId = doctorRegistrationIdEditText.getText().toString();
        newDoctor.name = doctorRegistrationNameEditText.getText().toString();
        newDoctor.ssn = doctorRegistrationSsnEditText.getText().toString();
        newDoctor.specialty = doctorRegistrationSpecialtyEditText.getText().toString();

        // Insert the doctor in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    doctorDao.insert(newDoctor);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(DoctorDashboardActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(DoctorDashboardActivity.this, "Registration failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }).start();
    }

}
