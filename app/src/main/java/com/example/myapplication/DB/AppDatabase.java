package com.example.myapplication.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Doctor.class, Patient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorDAO doctorDao();
    public abstract PatientDAO patientDao();

    // todo Singleton instance logic goes here if needed
}
