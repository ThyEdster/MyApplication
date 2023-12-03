package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Button;
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
                // Handle the login logic
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
                patientDao.insert(newPatient);
                // Consider adding some form of confirmation or error handling here
            }
        }).start();
    }



}
