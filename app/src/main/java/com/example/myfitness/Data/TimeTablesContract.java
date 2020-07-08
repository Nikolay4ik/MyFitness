package com.example.myfitness.Data;

import android.provider.BaseColumns;

public class TimeTablesContract {
    public static final class TimeTablesEntry implements BaseColumns{
        public static final String TABLE_NAME="timetables";
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_DESCRIPTION="description";
        public static final String COLUMN_PLACE="place";
        public static final String COLUMN_TEACHER="teacher";
        public static final String COLUMN_START_TIME="startTime";
        public static final String COLUMN_END_TIME="endTime";
        public static final String COLUMN_WEEK_DAY="weekDay";

        public static final String TYPE_TEXT="TEXT";
        public static final String TYPE_INTEGER="INTEGER";

        public static final String CREATE_TABLE="CREATE TABLE IF NOT EXISTS"+TABLE_NAME+"("+_ID+" "+TYPE_INTEGER+" PRIMARY KEY AUTOINCREMENT,"+COLUMN_NAME+" "+TYPE_TEXT+", "+COLUMN_DESCRIPTION+" "+TYPE_TEXT+", "+
                COLUMN_PLACE+" "+ TYPE_TEXT+", "+COLUMN_TEACHER+" "+TYPE_TEXT+", "+COLUMN_START_TIME+" "+TYPE_TEXT+", "+COLUMN_END_TIME+" "+TYPE_TEXT+", "+COLUMN_WEEK_DAY+" "+TYPE_INTEGER+")";

    }
}
