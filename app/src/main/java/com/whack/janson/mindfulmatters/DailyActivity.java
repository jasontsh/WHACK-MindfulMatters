package com.whack.janson.mindfulmatters;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                for (Integer i : choices) {
                    if (i == 0) {
                        Toast.makeText(activity, "You haven't finished the quiz!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

            }
        });
    }
}
