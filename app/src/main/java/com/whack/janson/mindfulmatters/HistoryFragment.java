package com.whack.janson.mindfulmatters;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidplot.xy.XYPlot;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jason on 11/10/2017.
 */

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        Bundle b = getArguments();
        XYPlot plot = (XYPlot) v.findViewById(R.id.plot);
        SharedPreferences sp = getActivity().getSharedPreferences("default", MODE_PRIVATE);
        int count = sp.getInt("count", -1);
        

        return v;
    }
}
