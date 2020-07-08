package com.example.myfitness.Data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Timetable.class},version = 1,exportSchema = false)
public abstract class TimeTableDataBase extends RoomDatabase {
    private static TimeTableDataBase dataBase;
    private static final String DB_NAME="timeTables.db";
    private static final Object LOCK=new Object();

    public static TimeTableDataBase getInstance(Context context){
        synchronized (LOCK){
            if (dataBase==null){
                dataBase= Room.databaseBuilder(context,TimeTableDataBase.class,DB_NAME).build();
            }
            return dataBase;
        }
    }
    public abstract TimeTableDao timeTableDao();
}
