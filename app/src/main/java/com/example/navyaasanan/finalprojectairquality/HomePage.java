package com.example.navyaasanan.finalprojectairquality;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

/**
 * Home Page for our Air Quality App
 */
public class HomePage extends AppCompatActivity implements View.OnClickListener {

    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "MP6";

    private String key = "4483a60facf6499da1b2df96085435a3";
    private String URL = "https://api.breezometer.com/air-quality/v2/current-conditions?lat={latitude}&lon={longitude}&key={Your_API_Key}&features={Features_List}";
    private String ffs ="";
    private static RequestQueue requestQueue;
    private final double lat = 41.8781;
    private final double log = -88.6298;
    //private ProgressBar progressBar;

   // private TextView aqi = findViewById(R.id.aqiDisplay);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        //progressBar = findViewById(R.id.progress_bar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button getAirQuality = findViewById(R.id.AQIButton);
        getAirQuality.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Switch switch3 = (Switch) findViewById(R.id.switch3);
                Switch switch4 = (Switch) findViewById(R.id.switch4);
                Switch s1 = (Switch) findViewById(R.id.switch1);
                Switch s2 = (Switch) findViewById(R.id.switch2);
                //startActivity(new Intent(HomePage.this, InfoResults.class));
                //startAPICall();
                Toast toast = Toast.makeText(HomePage.this, "Good Air Quality", Toast.LENGTH_LONG);
                toast.show();
            }
        });


        final Button reset = findViewById(R.id.ResetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            Switch switch3 = (Switch) findViewById(R.id.switch3);
            Switch switch4 = (Switch) findViewById(R.id.switch4);
            Switch s1 = (Switch) findViewById(R.id.switch1);
            Switch s2 = (Switch) findViewById(R.id.switch2);
            JSONObject aqi;
            public void onClick(View v) {
               recreate();
               switch3.setChecked(false);
               switch4.setChecked(false);
               s1.setChecked(false);
               s2.setChecked(false);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.City, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


       /**
        * FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hi, I work!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.AQIButton){
            startActivity(new Intent(HomePage.this, InfoResults.class));
            //startAPICall();
        }
    }

/**
    public void startAsyncTask(View v) {
        ExampleAsyncTask task = new ExampleAsyncTask(this);
        task.execute(10);
    }

    private class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {

        private WeakReference<HomePage> activityWeakReference;

        ExampleAsyncTask(HomePage activity) {
            activityWeakReference = new WeakReference<HomePage>(activity);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            HomePage activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }

            activity.progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int i = 0; i < integers[0]; i++) {
                publishProgress((i * 100) / integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Finished!";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            HomePage activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(HomePage.this, s, Toast.LENGTH_LONG).show();
            HomePage activity = activityWeakReference.get();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            activity.progressBar.setProgress(0);
            activity.progressBar.setVisibility(View.INVISIBLE);
        }
    }*/

    /**
    void startAPICall() {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    "https://api.breezometer.com/air-quality/v2/current-conditions?lat=41.8781&lon=87.6298&key=4483a60facf6499da1b2df96085435a3&features=breezometer_aqi",
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
