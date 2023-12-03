package com.example.myapplication.DB;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "doctors")
public class DoctorDAO {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String doctorId;
    public String name;
    public String specialty;

    // Add getters and setters or use public fields
}
