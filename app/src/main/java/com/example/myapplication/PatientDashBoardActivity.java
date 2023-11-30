package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.view.View;

public class PatientDashBoardActivity extends AppCompatActivity {
    private RadioGroup signInRegisterRadioGroup;
    private LinearLayout loginSection, registrationSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dash_board);

        signInRegisterRadioGroup = findViewById(R.id.signInRegisterRadioGroup);
        loginSection = findViewById(R.id.loginSection);
        registrationSection = findViewById(R.id.registrationSection);

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
