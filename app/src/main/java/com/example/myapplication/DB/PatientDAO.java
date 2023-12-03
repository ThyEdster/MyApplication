package com.example.myapplication.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patient")
public class PatientDAO {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String patientId;
    public String name;
    public String ssn;

    // Add getters and setters or use public fields
}
