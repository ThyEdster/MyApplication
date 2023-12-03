package com.example.myapplication.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.Room;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executors;

@Database(entities = {Doctor.class, Patient.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DoctorDAO doctorDao();
    public abstract PatientDAO patientDao();

    // Singleton instance of the database
    private static volatile AppDatabase INSTANCE;

    // Callback to pre-populate the database
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Executors.newSingleThreadExecutor().execute(() -> {
                // Pre-populate database with a test doctor
                DoctorDAO doctorDao = INSTANCE.doctorDao();
                Doctor testDoctor = new Doctor();
                testDoctor.doctorId = "doctor1";
                testDoctor.name = "Test Doctor";
                testDoctor.specialty = "General"; // Example specialty
                testDoctor.ssn = "987-65-4321"; // Example SSN

                doctorDao.insert(testDoctor);

                // Pre-populate database with a test patient
                PatientDAO patientDao = INSTANCE.patientDao();
                Patient testPatient = new Patient();
                testPatient.patientId = "patient1";
                testPatient.name = "Test Patient";
                testPatient.ssn = "123-45-6789"; // Example SSN

                patientDao.insert(testPatient);
            });
        }
    };

    // Method to get the singleton instance of the database
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
