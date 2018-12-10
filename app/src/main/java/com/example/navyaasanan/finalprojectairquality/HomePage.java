package com.example.navyaasanan.finalprojectairquality;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

/**
 * Home Page for our Air Quality App
 */
public class HomePage extends AppCompatActivity implements View.OnClickListener {

    /** Default logging tag for messages from the main activity. */
    private static final String TAG = "MP6";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button getAirQuality = findViewById(R.id.AQIButton);
        getAirQuality.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, InfoResults.class));
            }

        });


        final Button reset = findViewById(R.id.ResetButton);
        reset.setOnClickListener(new View.OnClickListener() {
            CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
            CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
            Switch s1 = (Switch) findViewById(R.id.switch1);
            Switch s2 = (Switch) findViewById(R.id.switch2);
            public void onClick(View v) {
               recreate();
               cb1.setChecked(false);
               cb2.setChecked(false);
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
            Intent intent = new Intent(this, InfoResults.class);
            startActivity(intent);
        }
    }
}
