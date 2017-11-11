package com.whack.janson.mindfulmatters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_quiz).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("default", MODE_PRIVATE);
                int score = sp.getInt("basic_score", -1);
                if (score == -1) {
                    startActivity(new Intent(context, ScreenQuizActivity.class));
                } else {
                    startActivity(new Intent(context, DailyActivity.class));
                }
            }
        });
    }
}
