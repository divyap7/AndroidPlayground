package com.playground.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentOne extends Fragment {

    View clickA;
    View clickB;
    View clickC;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View fragmentOne = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        clickA = fragmentOne.findViewById(R.id.button31);
        clickB = fragmentOne.findViewById(R.id.button32);
        clickC = fragmentOne.findViewById(R.id.button33);
        clickA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FragmentTwo fragmentTwo = new FragmentTwo();
                //FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                //fragmentTransaction.replace(R.id.frameLayout,fragmentTwo);
                //fragmentTransaction.commit();
                String buttonName = ((Button) v).getText().toString();
                displayButtonName(buttonName);


            }
        });

        clickB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonName = ((Button) v).getText().toString();
                displayButtonName(buttonName);
            }
        });

        clickC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonName = ((Button) v).getText().toString();
                displayButtonName(buttonName);
            }
        });
        return fragmentOne;
    }

    public void displayButtonName(String buttonName) {
        Intent intent = new Intent(getActivity(), FragmentActivityTwo.class);
        String display = "this is  " + buttonName;
        intent.putExtra("button", display);
        startActivity(intent);

    }


}
