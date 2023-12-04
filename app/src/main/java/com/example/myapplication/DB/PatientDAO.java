package com.example.myapplication.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PatientDAO {
    @Insert
    void insert(Patient patient);

    @Query("SELECT * FROM patients")
    List<Patient> getAllPatients();

    @Query("SELECT * FROM patients WHERE patientId = :id AND ssn = :ssn")
    Patient findByIdAndSsn(String id, String ssn);
}
