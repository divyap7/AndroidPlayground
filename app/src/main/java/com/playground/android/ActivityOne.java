package com.playground.android;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityOne extends AppCompatActivity {

    String displayCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_one);

        View toast = findViewById(R.id.toast);
        View count = findViewById(R.id.count);
        final TextView showCount = findViewById(R.id.showcount);

        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityOne.this, "Hey dude!", Toast.LENGTH_SHORT).show();
            }
        });
        if (savedInstanceState != null) {
            displayCount = savedInstanceState.getString("savedCount");
            showCount.setText(displayCount);
            count.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String number = showCount.getText().toString();
                    Integer count = Integer.parseInt(number);
                    count++;
                    displayCount = count.toString();
                    showCount.setText(displayCount);
                }
            });
        }

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = showCount.getText().toString();
                Integer count = Integer.parseInt(number);
                count++;
                displayCount = count.toString();
                showCount.setText(displayCount);
            }
        });


    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedCount", displayCount);
    }


}
