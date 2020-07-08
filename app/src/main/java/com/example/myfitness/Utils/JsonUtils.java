package com.example.myfitness.Utils;

import android.content.AsyncTaskLoader;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.myfitness.Data.Timetable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";
    private  static final String PARAMS_NAME = "name";
    private static final String PARAMS_PLACE="place";
    private static final String PARAMS_DISCRIPTION = "description";
    private static final String PARAMS_TEACHER = "teacher";
    private static final String PARAMS_START_TIME = "startTime";
    private  static final String PARAMS_END_TIME = "endTime";
    private static final String PARAMS_WEEK_DAY="weekDay";

  public static   List<Timetable> getTimetables(JSONArray jsonArray){
      List<Timetable> result =new ArrayList<>();
      if ( jsonArray == null){
          return result;
      }
       try {
          for (int i=0;i<jsonArray.length();i++) {
              JSONObject main = jsonArray.getJSONObject(i);
              int weekDay = main.getInt(PARAMS_WEEK_DAY);
              String name = main.getString(PARAMS_NAME);
              String description = main.getString(PARAMS_DISCRIPTION);
              String teacher = main.getString(PARAMS_TEACHER);
              String startTime = main.getString(PARAMS_START_TIME);
              String endTime = main.getString(PARAMS_END_TIME);
              String place = main.getString(PARAMS_PLACE);
              Timetable timetable = new Timetable( name, description, teacher, place,  startTime, endTime, weekDay);
              result.add(timetable);
          }
       } catch (JSONException e) {
           Log.i("JsonUtils","Exc");
           e.printStackTrace();
       }
return result;
   }
}
