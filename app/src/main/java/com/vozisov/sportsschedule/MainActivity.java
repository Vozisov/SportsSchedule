package com.vozisov.sportsschedule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vozisov.sportsschedule.adapter.FitAdapter;
import com.vozisov.sportsschedule.config.Api;
import com.vozisov.sportsschedule.config.Config;
import com.vozisov.sportsschedule.model.EventItem;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    List<EventItem> eventsList;

    ArrayList events0Day = new ArrayList<>();
    ArrayList events1Day = new ArrayList<>();
    ArrayList events2Day = new ArrayList<>();
    ArrayList events3Day = new ArrayList<>();
    ArrayList events4Day = new ArrayList<>();
    ArrayList events5Day = new ArrayList<>();
    ArrayList events6Day = new ArrayList<>();

    Map<Integer, ArrayList> sortedWeek = new HashMap<>();

    ViewPager pager;
    ProgressBar progressBar;

    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPrefs = getPreferences(MODE_PRIVATE);

        pager = findViewById(R.id.pager);
        progressBar = findViewById(R.id.progressBar);

        if (isOnline()) {
            progressBar.setVisibility(View.VISIBLE);
            getPosts();
        } else {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.noinet)
                    .setCancelable(false).setMessage(R.string.noinetmess)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialogInterface, int n) {
                            restoreData();
                        }
                    })
                    .setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int n) {
                            finish();
                        }
                    }).show();
        }
    }

    private void restoreData() {

        String data = mPrefs.getString("eventsList", "");

        if (data != "") {

            Gson gson = new Gson();
            Type type = new TypeToken<List<EventItem>>() {
            }.getType();
            eventsList = gson.fromJson(data, type);

            sortEvents();
            setData();

        } else {

            Toast toast = Toast.makeText(getApplicationContext(), R.string.nodata, Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void backupData(String saveData) {

        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("eventsList", saveData);
        prefsEditor.apply();
    }

    private void getPosts() {

        Call<List<EventItem>> events;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        events = api.getEventList();

        events.enqueue(new Callback<List<EventItem>>() {
            @Override
            public void onResponse(Call<List<EventItem>> call, Response<List<EventItem>> response) {
                if (response.isSuccessful()) {

                    eventsList = response.body();
                    sortEvents();
                    setData();
                    Gson gson = new Gson();
                    String saveData = gson.toJson(response.body());
                    backupData(saveData);
                }
            }

            @Override
            public void onFailure(Call<List<EventItem>> call, Throwable t) {

                Toast toast = Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private void sortEvents() {

        for (int i = 0; i < eventsList.size(); i++) {

            switch (eventsList.get(i).getWeekDay()) {
                case 1:
                    events0Day.add(eventsList.get(i));
                    break;
                case 2:
                    events1Day.add(eventsList.get(i));
                    break;
                case 3:
                    events2Day.add(eventsList.get(i));
                    break;
                case 4:
                    events3Day.add(eventsList.get(i));
                    break;
                case 5:
                    events4Day.add(eventsList.get(i));
                    break;
                case 6:
                    events5Day.add(eventsList.get(i));
                    break;
                case 7:
                    events6Day.add(eventsList.get(i));
                    break;
            }
        }

        sortedWeek.put(0, events0Day);
        sortedWeek.put(1, events1Day);
        sortedWeek.put(2, events2Day);
        sortedWeek.put(3, events3Day);
        sortedWeek.put(4, events4Day);
        sortedWeek.put(5, events5Day);
        sortedWeek.put(6, events6Day);
    }

    private void setData() {
        pager.setAdapter(new FitAdapter(sortedWeek, getApplicationContext()));
        progressBar.setVisibility(View.GONE);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }
}
