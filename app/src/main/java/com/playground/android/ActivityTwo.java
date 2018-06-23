package com.playground.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class ActivityTwo extends AppCompatActivity {
    private TextView textViewRandomNumber;
    String randomCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);


        if (savedInstanceState != null) {
            randomCount = savedInstanceState.getString("randomCount");
            textViewRandomNumber.setText(randomCount);
        }

        displayRandomNumber();
    }


    public void displayRandomNumber() {
        textViewRandomNumber = findViewById(R.id.randomview);
        int count = getIntent().getIntExtra("Count", 0);
        Random random = new Random();
        int randomValue = 0;
        if (count > 0) {
            randomValue = random.nextInt(count);
        }
        randomCount = Integer.toString(randomValue);
        textViewRandomNumber.setText(randomCount);


    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("randomCount", randomCount);

    }
}
