package com.whack.janson.mindfulmatters;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jason on 11/10/2017.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.QuizViewHolder> {

    private ArrayList<Question> questions;

    public QuizAdapter (ArrayList<Question> questions) {
        this.questions = questions;
    }

    @Override
    public QuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_item, parent, false);
        return new QuizViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuizViewHolder holder, int position) {
        final Question question = questions.get(position);
        holder.question.setText(question.getQuestion());
        holder.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch(checkedId) {
                    case R.id.rg2:
                        question.setScore(1);
                    case R.id.rg3:
                        question.setScore(2);
                    case R.id.rg4:
                        question.setScore(3);
                    case R.id.rg1:
                    default:
                        question.setScore(0); break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
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
}
