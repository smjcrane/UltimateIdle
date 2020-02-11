package com.gmail.smjcrane.ultimateidle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.util.Log;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements Runnable{

    public static final String prefs = "ULTIMATEIDLEPREFS";
    public static final String valueKey = "VALUEKEY";

    private TextView textProgress;
    private SharedPreferences preference;
    private int value;
    private Timer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textProgress = findViewById(R.id.progress);
    }

    protected void onResume(){
        super.onResume();
        preference = getPreferences(MODE_PRIVATE);
        value = preference.getInt(valueKey, 10);

        handler = new Handler();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(MainActivity.this);
            }
        }, 0, 1000);
    }

    @Override
    protected void onPause(){
        super.onPause();
        preference.edit().putInt(valueKey, value).apply();
        timer.cancel();
        timer.purge();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        preference.edit().putInt(valueKey, value).apply();
        timer.cancel();
        timer.purge();
    }

        public void run(){
        Log.i("MAIN", "ticking with " + value);
        value = (int) (value * 1.1);
        textProgress.setText(Integer.toString(value));
    }
}
