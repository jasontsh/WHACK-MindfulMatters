package com.whack.janson.mindfulmatters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by MLH-Admin on 11/11/2017.
 */

public class ResourceFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_resources, container, false);
        TextView tv = (TextView) v.findViewById(R.id.resource_text);
        Bundle bundle = getArguments();
        int n = bundle.getInt("number", 0);
        if (n != 0) {
            tv.setText(R.string.lifestyle);
        } else {
            tv.setText(R.string.online);
        }
        return v;
    }
}
