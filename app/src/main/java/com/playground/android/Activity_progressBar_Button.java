package com.playground.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity_progressBar_Button extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar__button);

        View button = findViewById(R.id.calculate);
        View progressBar = findViewById(R.id.progressBar2);

        progressBar.setVisibility(View.VISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long sum = 0;
                for (long i = 1; i <= 999999999; i++) {
                    sum += i;
                }
                Log.d("sum", "sum: " + sum);
            }
        });
    }
}
