package com.example.myfitness;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;

import com.dingmouren.layoutmanagergroup.echelon.EchelonLayoutManager;
import com.example.myfitness.Adapters.AdapterTimeTable;
import com.example.myfitness.Data.Timetable;
import com.example.myfitness.Utils.JsonUtils;
import com.example.myfitness.Utils.NetworkUtils;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<JSONArray> {

    private RecyclerView recyclerView;
    private AdapterTimeTable adapterTimeTable;
    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDate();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new EchelonLayoutManager(this));
        adapterTimeTable = new AdapterTimeTable(this);

        // JSONArray jsonObject = NetworkUtils.jsonObjectTask();
        // List<Timetable> timetables = JsonUtils.getTimetables(jsonObject);
        //adapterTimeTable.setTimetables(timetables);
        recyclerView.setAdapter(adapterTimeTable);
        StringBuilder stringBuilder = new StringBuilder();
        //  for (JSONObject arrayList :jsonObject){
        //  stringBuilder.append(arrayList);
        //  }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }


    }

    private void getDate() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getAllTimeTable().observe(this, new Observer<List<Timetable>>() {
            @Override
            public void onChanged(@Nullable List<Timetable> timetables) {
                JSONArray jsonObject = NetworkUtils.jsonObjectTask();
                timetables = JsonUtils.getTimetables(jsonObject);
                adapterTimeTable.setTimetables(timetables);
            }
        });

    }

    @NonNull
    @Override
    public Loader<JSONArray> onCreateLoader(int i, @Nullable Bundle bundle) {

        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<JSONArray> loader, JSONArray jsonArray) {
        List<Timetable> timetables = JsonUtils.getTimetables(jsonArray);
    }


    @Override
    public void onLoaderReset(@NonNull Loader<JSONArray> loader) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
