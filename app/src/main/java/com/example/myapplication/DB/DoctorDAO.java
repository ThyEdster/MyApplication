package com.example.myapplication.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface DoctorDAO {
    @Insert
    void insert(Doctor doctor);

    @Query("SELECT * FROM doctors")
    List<Doctor> getAllDoctors();
}
