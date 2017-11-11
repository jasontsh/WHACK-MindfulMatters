package com.whack.janson.mindfulmatters;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jason on 11/10/2017.
 */

public class QuizAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Question> questions;
    private ScreenQuizActivity activity;

    public QuizAdapter (ArrayList<Question> questions, ScreenQuizActivity activity) {
        this.questions = questions;
        this.activity = activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.submit_item, parent, false);
            return new SubmitViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == questions.size()) {
            SubmitViewHolder submitViewHolder = (SubmitViewHolder) holder;
            submitViewHolder.submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (Question question : questions) {
                        if (question.getScore() == -1) {
                            Toast.makeText(activity, "You haven't finished the quiz!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    activity.handleFromAdapter();
                }
            });
            return;
        }
        final Question question = questions.get(position);
        QuizViewHolder quizViewHolder = (QuizViewHolder) holder;
        quizViewHolder.question.setText(question.getQuestion());
        quizViewHolder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId) {
                    case R.id.rg2:
                        question.setScore(1); break;
                    case R.id.rg3:
                        question.setScore(2); break;
                    case R.id.rg4:
                        question.setScore(3); break;
                    case R.id.rg1:
                        question.setScore(0); break;
                    default:
                        question.setScore(-1); break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == questions.size()) {
            return 1;
        }
        return 0;
    }

    class QuizViewHolder extends RecyclerView.ViewHolder {
        TextView question;
        RadioGroup rg;
        public QuizViewHolder(View view) {
            super(view);
            question = (TextView) view.findViewById(R.id.question);
            rg = (RadioGroup) view.findViewById(R.id.quiz_rg);
        }
    }

    class SubmitViewHolder extends RecyclerView.ViewHolder {
        TextView submit;
        public SubmitViewHolder(View view) {
            super(view);
            submit = (TextView) view.findViewById(R.id.submit);
        }
    }
}
