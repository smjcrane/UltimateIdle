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

    private TextView textProgress, textFact;
    private SharedPreferences preference;
    private long value;
    private int factIndex;
    private Timer timer;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textProgress = findViewById(R.id.progress);
        textFact = findViewById(R.id.fact);
    }

    private void initialiseFactIndex(){
        factIndex = 0;
        while (factIndex  + 1< Milestones.numbers.length && Milestones.numbers[factIndex+1] < value){
            factIndex++;
        }
        textFact.setText(getString(R.string.more) + Milestones.strings[factIndex]);
    }

    protected void onResume(){
        super.onResume();
        preference = getPreferences(MODE_PRIVATE);
        value = preference.getLong(valueKey, 10L);
        initialiseFactIndex();
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
        preference.edit().putLong(valueKey, value).apply();
        timer.cancel();
        timer.purge();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        preference.edit().putLong(valueKey, value).apply();
        timer.cancel();
        timer.purge();
    }

        public void run(){
        Log.i("MAIN", "ticking with " + value);
        if (value > Long.MAX_VALUE / 1.1){
            value = Long.MAX_VALUE;
            timer.cancel();
            timer.purge();
        } else {
            value = (long) (value * 1.1);
        }
        textProgress.setText(Long.toString(value));
        if (factIndex  + 1< Milestones.numbers.length && Milestones.numbers[factIndex+1] < value){
            factIndex++;
            textFact.setText(getString(R.string.more) + Milestones.strings[factIndex]);
        }
    }
}
