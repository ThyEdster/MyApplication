package com.example.myapplication.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")
public class Patient {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String patientId;
    public String name;
    public String ssn;

    // Add getters and setters or use public fields
}
