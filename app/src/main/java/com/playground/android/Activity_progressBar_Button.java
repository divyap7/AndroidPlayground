package com.playground.android;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Activity_progressBar_Button extends AppCompatActivity {

    View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar__button);

        View button = findViewById(R.id.calculate);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.INVISIBLE);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new LongOperation().execute();


            }
        });
    }

    private class LongOperation extends AsyncTask<Void, Long, Long> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.INVISIBLE);
            Log.d("message", "inside pre execute");
        }

        @Override
        protected Long doInBackground(Void... voids) {
            long sum = 0;

            for (long i = 1; i <= 999999999; i++) {
                Log.d("message", "inside loop");
                sum += i;
                publishProgress(sum);

            }
            Log.d("sum","Sum is "+sum);

            return sum;
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            progressBar.setVisibility(View.INVISIBLE);
            Log.d("message", "inside post execute");

        }



    }
}
