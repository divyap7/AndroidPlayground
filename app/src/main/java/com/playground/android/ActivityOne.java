package com.playground.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    String displayCount;
    TextView textViewShowCount;
    View buttonRandom;
    View buttonCount;
    View buttonToast;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one);

        buttonToast = findViewById(R.id.toast);
        buttonCount = findViewById(R.id.count);
        buttonRandom = findViewById(R.id.random);
        textViewShowCount = findViewById(R.id.showcount);

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityOne.this, "Hey dude!", Toast.LENGTH_SHORT).show();
            }
        });
        if (savedInstanceState != null) {
            displayCount = savedInstanceState.getString("savedCount");
            textViewShowCount.setText(displayCount);

        }

        sharedPref = getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        displayCount = sharedPref.getString("countValue", "");
        if (!displayCount.equals("")) {
            textViewShowCount.setText(displayCount);
        }


        buttonCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = textViewShowCount.getText().toString();
                Integer count = Integer.parseInt(number);
                count++;
                displayCount = count.toString();
                textViewShowCount.setText(displayCount);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("countValue", displayCount);
                editor.apply();
            }
        });


        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);
                String strCount = textViewShowCount.getText().toString();
                int saveCount = Integer.parseInt(strCount);
                intent.putExtra("Count", saveCount);
                startActivity(intent);
            }
        });

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedCount", displayCount);

    }

}
