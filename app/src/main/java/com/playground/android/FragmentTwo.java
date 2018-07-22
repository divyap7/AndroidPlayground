package com.playground.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentTwo extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentTwo =  inflater.inflate(R.layout.fragment_fragment_two, container, false);
        TextView displayText = fragmentTwo.findViewById(R.id.text);
        Intent intent = getActivity().getIntent();
        String textIs = intent.getStringExtra("button");
        displayText.setText(textIs);
        return fragmentTwo;
    }
}
