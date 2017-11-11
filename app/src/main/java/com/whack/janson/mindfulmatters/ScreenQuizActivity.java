package com.whack.janson.mindfulmatters;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ScreenQuizActivity extends AppCompatActivity {

    ArrayList<Question> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questions = new ArrayList<>();
        questions.add(new Question("Little interest or pleasure in doing things?"));
        questions.add(new Question("Feeling down, depressed, or hopeless?"));
        questions.add(new Question("Trouble falling or staying asleep, or sleeping too much?"));
        questions.add(new Question("Feeling tired or having little energy?"));
        questions.add(new Question("Poor appetite or overeating?"));
        questions.add(new Question("Feeling bad about yourself - or that you are a failure or have let yourself or your family down?"));
        questions.add(new Question("Trouble concentrating on things, such as reading the newspaper or watching television?"));
        questions.add(new Question("Moving or speaking so slowly that other people could have noticed?\n" +
                "Or the opposite - being so fidgety or restless that you have been moving around a lot more than usual?"));
        questions.add(new Question("Thoughts that you would be better off dead, or of hurting yourself in some way?"));
        QuizAdapter adapter = new QuizAdapter(questions, this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.quiz);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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

    public void handleFromAdapter() {
        SharedPreferences sp = getSharedPreferences("default", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        int score = 0;
        for (Question question : questions) {
            score += question.getScore();
        }
        ed.putInt("basic_score", score);
        ed.apply();
        finish();
    }
}
