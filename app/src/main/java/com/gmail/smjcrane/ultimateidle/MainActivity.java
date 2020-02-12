package com.gmail.smjcrane.ultimateidle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.Preference;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements Runnable{

    public static final String valueKey = "DIGITSTRING";

    private TextView textFact;
    private SharedPreferences preference;
    private int factIndex;
    private Timer timer;
    private Handler handler;
    private Counter counter;
    private GridView digitGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textFact = findViewById(R.id.fact);
        digitGrid = findViewById(R.id.digitGrid);
    }

    private void initialiseFactIndex(){
        factIndex = 0;
        while (factIndex  + 1< Milestones.milestones.length && counter.isGreaterThan(Milestones.milestones[factIndex + 1].digits)){
            factIndex++;
        }
        textFact.setText(getString(R.string.more) + Milestones.milestones[factIndex].description);
    }

    protected void onResume(){
        super.onResume();
        preference = getPreferences(MODE_PRIVATE);
        char[] digitChars = preference.getString(valueKey, "1").toCharArray();
        List<Integer> digits = new ArrayList<>();
        for (char c : digitChars){
            digits.add(Integer.parseInt(Character.toString(c)));
        }
        if (counter == null){
            counter = new Counter(this, digits);
            digitGrid.setAdapter(counter);
        } else {
            counter.setDigits(digits);
        }
        initialiseFactIndex();
        handler = new Handler();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(MainActivity.this);
            }
        }, 0, 150);
    }

    @Override
    protected void onPause(){
        super.onPause();
        preference.edit().putString(valueKey, counter.getDigitString()).apply();
        timer.cancel();
        timer.purge();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);
        preference.edit().putString(valueKey, counter.getDigitString()).apply();
        timer.cancel();
        timer.purge();
    }

    public void run(){
        Log.i("MAIN", "ticking with " + counter.getDigitString());
        counter.increment();
        if (factIndex  + 1< Milestones.milestones.length && counter.isGreaterThan(Milestones.milestones[factIndex + 1].digits)){
            factIndex++;
            textFact.setText(getString(R.string.more) + Milestones.milestones[factIndex].description);
        }
    }
}
