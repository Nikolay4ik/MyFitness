package com.example.myfitness.Utils;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
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
import java.util.concurrent.ExecutionException;

public class NetworkUtils {
    private static String BASE_URL = "https://sample.fitnesskit-admin.ru/schedule/get_group_lessons_v2/1/";

    public static JSONArray jsonObjectTask() {
        JSONArray result = null;
        try {
            result = new DowlandTask().execute(BASE_URL).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

public static class JsonLoader extends AsyncTaskLoader<JSONArray>{
    public JsonLoader(@NonNull Context context, Bundle bundle) {
        super(context);
    }

    @Nullable
    @Override
    public JSONArray loadInBackground() {
        return null;
    }
}


    public static class DowlandTask extends AsyncTask<String, Void, JSONArray> {

        @Override
        public JSONArray doInBackground(String... strings) {
            if (strings == null || strings.length == 0) {
                return null;
            }
            StringBuilder builder = new StringBuilder();
            JSONArray result = null;
            HttpURLConnection urlConnection = null;
            URL url = null;
            try {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine().trim();
                while (line != null) {
                    builder.append(line);
                    line = bufferedReader.readLine();
                }
                result = new JSONArray(builder.toString());
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


