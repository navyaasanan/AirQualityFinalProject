package com.example.navyaasanan.finalprojectairquality;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class InfoResults extends AppCompatActivity {


    private JSONObject aqi;
    private TextView aqiView = findViewById(R.id.aqiDisplay);
    private String ffs ="";
    private String key = "4483a60facf6499da1b2df96085435a3";
    private String URL = "https://api.breezometer.com/air-quality/v2/current-conditions?lat={latitude}&lon={longitude}&key={Your_API_Key}&features={Features_List}";
    private static RequestQueue requestQueue;
    private final float lat = 42;
    private final float log = -88;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_results);

        final Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(InfoResults.this, HomePage.class));
                //startAPICall();
            }
        });

    }
    /**
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.breezometer.com/air-quality/v2/current-conditions?lat=" + lat + "&lon=" + log + "&key=" + key + "&features=breezometer_aqi",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d("RESPONSE", response.toString());
                            try {
                                JSONObject aqi = response.getJSONObject("aqi_display");
                                ffs = aqi.toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.w("ERROR", error.toString());
                }
            });
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}