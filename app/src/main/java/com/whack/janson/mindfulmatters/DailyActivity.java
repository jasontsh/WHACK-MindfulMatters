package com.whack.janson.mindfulmatters;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DailyActivity extends AppCompatActivity {

    final Activity activity = this;
    int[] choices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        choices = new int[4];
        ((RadioGroup) findViewById(R.id.quiz_rg1)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rg11:
                        choices[0] = 1; break;
                    case R.id.rg12:
                        choices[0] = 2; break;
                    case R.id.rg13:
                        choices[0] = 3; break;
                    case R.id.rg14:
                        choices[0] = 4; break;
                }
            }
        });
        ((RadioGroup) findViewById(R.id.quiz_rg2)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rg21:
                        choices[1] = 1; break;
                    case R.id.rg22:
                        choices[1] = 2; break;
                    case R.id.rg23:
                        choices[1] = 3; break;
                    case R.id.rg24:
                        choices[1] = 4; break;
                }
            }
        });
        ((RadioGroup) findViewById(R.id.quiz_rg3)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rg31:
                        choices[2] = 1; break;
                    case R.id.rg32:
                        choices[2] = 2; break;
                    case R.id.rg33:
                        choices[2] = 3; break;
                    case R.id.rg34:
                        choices[2] = 4; break;
                }
            }
        });
        ((RadioGroup) findViewById(R.id.quiz_rg4)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.rg41:
                        choices[3] = 1; break;
                    case R.id.rg42:
                        choices[3] = 2; break;
                    case R.id.rg43:
                        choices[3] = 3; break;
                    case R.id.rg44:
                        choices[3] = 4; break;
                }
            }
        });
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int score = 0;
                for (Integer i : choices) {
                    if (i == 0) {
                        Toast.makeText(activity, "You haven't finished the quiz!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    score += i;
                }
                SharedPreferences sp = getSharedPreferences("default", MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                String timeStamp = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
                String prevTime = sp.getString("latest", "");
                int count = sp.getInt("count", -1);
                int indexToChange = count + (prevTime.equals(timeStamp) ? 0 : 1);
                ed.putInt("count", indexToChange);
                ed.putString("latest", timeStamp);
                ed.putInt("Mood_" + indexToChange, choices[0]);
                ed.putInt("Activity_" + indexToChange, choices[1]);
                ed.putInt("Sleep_" + indexToChange, choices[2]);
                ed.putInt("Nutrition_" + indexToChange, choices[3]);
                ed.apply();
                finish();
                if (score <= 4) {
                    startActivity(new Intent(activity, ResourceActivity.class));
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to quit?")
                .setMessage("If yes, no results are going to be saved in this quiz")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("No", null);
        builder.create().show();
    }
}
