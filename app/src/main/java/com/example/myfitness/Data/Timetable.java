package com.example.myfitness.Data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "timetables")
public class Timetable {

@PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private String place;
    private String teacher;
    private String startTime;
    private String endTime;
    private int weekDay;

    public Timetable(int id, String name, String description, String place, String teacher, String startTime, String endTime, int weekDay) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
    }
@Ignore
    public Timetable(String name, String description, String place, String teacher, String startTime, String endTime, int weekDay) {
        this.name = name;
        this.description = description;
        this.place = place;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }
}
