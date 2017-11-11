package com.whack.janson.mindfulmatters;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
        ArrayList<Integer> array = new ArrayList<>(7);
        for (int i = count; i > 0 && i > count - 7; i--) {
            array.add(i);
        }
        //literally hard coding XD
        if (array.size() < 3) {
            array.clear();
            array.add(2);
            array.add(1);
            array.add(0);
        }
        Collections.reverse(array);
        final Number[] xlabels = new Number[array.size()];
        for (int i = 0; i < array.size(); i++) {
            xlabels[i] = array.get(i);
        }
        String key = b.getString("title", "");
        Number[] ylabels = new Number[xlabels.length];
        for (int i = 0; i < xlabels.length; i++) {
            //hard coding for demoing
            ylabels[i] = (int) (Math.random() * 4 + 1);
        }
        //make sure the hard coding is not a straight line
        if (ylabels.length == 3 && ylabels[0].equals(ylabels[1]) && ylabels[1].equals(ylabels[2])) {
            ylabels[1] = ylabels[0].intValue() == 2 ? 1 : 2;
        }
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(ylabels), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, key);

        LineAndPointFormatter series1Format =
                new LineAndPointFormatter(getContext(), R.xml.line_point_formatter_with_labels);
        plot.addSeries(series1, series1Format);
        return v;
    }
}
