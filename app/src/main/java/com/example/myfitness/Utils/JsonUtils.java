package com.example.myfitness.Utils;

import android.content.AsyncTaskLoader;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.myfitness.Data.Timetable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class JsonUtils {
    private static String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";
    private String PARAMS_NAME = "name";
    private String PARAMS_PLACE="place";
    private String PARAMS_DISCRIPTION = "description";
    private String PARAMS_TEACHER = "teacher";
    private String PARAMS_START_TIME = "startTime";
    private String PARAMS_END_TIME = "endTime";
    private  String PARAMS_ID="id";
    private String PARAMS_WEEK_DAY="weekDay";

   ArrayList<Timetable> timetables(JSONArray jsonArray){
      ArrayList<Timetable> result =new ArrayList<>();
      if ( jsonArray == null){
          return result;
      }
       try {
          for (int i=0;i<jsonArray.length();i++) {
              JSONObject main = jsonArray.getJSONObject(i);
              int id = main.getInt(PARAMS_ID);
              int weekDay = main.getInt(PARAMS_WEEK_DAY);
              String name = main.getString(PARAMS_NAME);
              String description = main.getString(PARAMS_DISCRIPTION);
              String teacher = main.getString(PARAMS_TEACHER);
              String startTime = main.getString(PARAMS_START_TIME);
              String endTime = main.getString(PARAMS_END_TIME);
              String place = main.getString(PARAMS_PLACE);
              Timetable timetable = new Timetable(id, name, description, place, teacher, startTime, endTime, weekDay);
              result.add(timetable);
          }
       } catch (JSONException e) {
           e.printStackTrace();
       }
return result;
   }
}
