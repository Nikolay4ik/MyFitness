package com.example.myfitness;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.example.myfitness.Data.TimeTableDataBase;
import com.example.myfitness.Data.Timetable;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private static TimeTableDataBase dataBase;
    private LiveData<List<Timetable>> timetables;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dataBase = TimeTableDataBase.getInstance(getApplication().getApplicationContext());
       // timetables = dataBase.timeTableDao().getAllTimetable();
    }

    public LiveData<List<Timetable>> getTimetables() {
        return timetables;
    }

    public void setTimetables(LiveData<List<Timetable>> timetables) {
        this.timetables = timetables;
    }

    public static TimeTableDataBase getDataBase() {
        return dataBase;
    }

    public static void setDataBase(TimeTableDataBase dataBase) {
        MainViewModel.dataBase = dataBase;
    }



    public void insertTimeTable(Timetable timetable) {
        new InsertTasc().execute(timetable);

    }

    public void deliteTimeTable(Timetable timetable) {
        new DeliteTasc().execute(timetable);

    }
    public LiveData<List<Timetable>> getAllTimeTable(){
        return dataBase.timeTableDao().getAllTimetable();
    }

    private static class InsertTasc extends AsyncTask<Timetable, Void, Void> {

        @Override
        protected Void doInBackground(Timetable... timetables) {
            if (timetables != null && timetables.length > 0) {
                dataBase.timeTableDao().insertTimeTable(timetables[0]);
            }
            return null;
        }
    }

    private static class DeliteTasc extends AsyncTask<Timetable, Void, Void> {

        @Override
        protected Void doInBackground(Timetable... timetables) {
            if (timetables != null && timetables.length > 0) {
                dataBase.timeTableDao().deliteTimeTable(timetables[0]);
            }
            return null;
        }
    }

}
