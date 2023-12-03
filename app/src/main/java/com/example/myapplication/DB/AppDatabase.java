package com.example.myapplication.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// Correctly import your entity and DAO classes
@Database(entities = {Doctor.class, Patient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorDAO doctorDao(); // Correct reference to DoctorDao
    public abstract PatientDAO patientDao(); // Correct reference to PatientDao

    // Singleton instance logic goes here if needed
}
