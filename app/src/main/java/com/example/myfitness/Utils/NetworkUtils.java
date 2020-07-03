package com.example.myfitness.Utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    private static String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";
    private  static String PARAMS_NAME = "name";
    private static String PARAMS_PLACE="place";
    private static String PARAMS_DISCRIPTION = "description";
    private static String PARAMS_TEACHER = "teacher";
    private static String PARAMS_START_TIME = "startTime";
    private  static String PARAMS_END_TIME = "endTime";
    private  static String PARAMS_ID="id";
    private  static String PARAMS_WEEK_DAY="weekDay";

    



    public static class DowlandTask extends AsyncTask<URL, Void,JSONArray> {

        @Override
        public JSONArray doInBackground(URL... urls) {
            if (urls==null|| urls.length==0){
                return  null;
            }
            StringBuilder builder = new StringBuilder();
            JSONArray result = null;
            HttpURLConnection urlConnection = null;

            try {
                urlConnection = (HttpURLConnection) urls[0].openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine().trim();
                while (line != null) {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                result=new JSONArray(builder.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }


    }

}
