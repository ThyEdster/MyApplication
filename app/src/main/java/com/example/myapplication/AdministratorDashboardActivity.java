package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdministratorDashboardActivity extends AppCompatActivity {

    private EditText adminUsernameEditText, adminPasswordEditText;
    private Button adminLoginButton, addAdminButton, deleteUserButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator_dashboard);

        // Initialize UI components
        adminUsernameEditText = findViewById(R.id.adminUsernameEditText);
        adminPasswordEditText = findViewById(R.id.adminPasswordEditText);
        adminLoginButton = findViewById(R.id.adminLoginButton);
        addAdminButton = findViewById(R.id.addAdminButton);
        deleteUserButton = findViewById(R.id.deleteUserButton);
        logoutButton = findViewById(R.id.logoutButton);

        // Set listeners for buttons
        adminLoginButton.setOnClickListener(v -> handleAdminLogin());
        addAdminButton.setOnClickListener(v -> handleAddAdmin());
        deleteUserButton.setOnClickListener(v -> handleDeleteUser());
        logoutButton.setOnClickListener(v -> handleLogout());
    }

    private void handleAdminLogin() {
        // todo  logic to verify admin credentials
        // If successful, show admin options and hide login section
        addAdminButton.setVisibility(View.VISIBLE);
        deleteUserButton.setVisibility(View.VISIBLE);
        logoutButton.setVisibility(View.VISIBLE);

        adminUsernameEditText.setVisibility(View.GONE);
        adminPasswordEditText.setVisibility(View.GONE);
        adminLoginButton.setVisibility(View.GONE);
    }

    private void handleAddAdmin() {
        // todo Implement logic to add a new administrator
    }

    private void handleDeleteUser() {
        // todo Implement logic to delete a user (doctor or patient)
    }

    private void handleLogout() {
        // Return to the MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
