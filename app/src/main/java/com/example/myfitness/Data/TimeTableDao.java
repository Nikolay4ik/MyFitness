package com.example.myfitness.Data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface TimeTableDao {
    @Query("SELECT * FROM timetables order by weekDay")
    LiveData<List<Timetable>> getAllTimetable();
@Insert
    void insertTimeTable(Timetable timetable);
@Delete
    void deliteTimeTable(Timetable timetable);
}
