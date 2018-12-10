package com.example.navyaasanan.finalprojectairquality;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class InfoResults extends AppCompatActivity {

    private String key = "4483a60facf6499da1b2df96085435a3";
    private String URL = "https://api.breezometer.com/air-quality/v2/current-conditions?lat={latitude}&lon={longitude}&key={Your_API_Key}&features={Features_List}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_results);
        final float lat = 42;
        final float log = -88;


        class RetrieveFeedTask extends AsyncTask<Void, Void, String> {
            protected String doInBackground(Void... urls) {
                try {
                    URL url = new URL("https://api.breezometer.com/air-quality/v2/current-conditions?lat={" + lat + " }&lon={" + log + "}&key={"
                                       + key + "}&features={breezometer_aqi}");
                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            stringBuilder.append(line).append("\n");
                        }
                        bufferedReader.close();
                        return stringBuilder.toString();
                    }
                    finally{
                        urlConnection.disconnect();
                    }
                }
                catch(Exception e) {
                    Log.e("ERROR", e.getMessage(), e);
                    return null;
                }
            }
        }




        final Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(InfoResults.this, HomePage.class));
            }
        });
    }
}