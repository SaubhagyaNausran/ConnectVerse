package com.example.assignment;

import static com.example.assignment.R.id.topAppBarRefine;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class RefineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine);


        Spinner spinner = findViewById(R.id.SpinnerInRefine);
        EditText editText = findViewById(R.id.statusEditTxt);
        SeekBar seekBar = findViewById(R.id.seekBar);
        Toolbar toolbar=findViewById(topAppBarRefine);
        RelativeLayout rlMarker = (RelativeLayout) findViewById(R.id.rlMarker);
        CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });






        String[] availability = {
                "Available | Hey let us connect",
                "Away | Stay Discreet And Watch",
                "Busy | Do Not Disturb",
                "SOS | Emergency! Need Assistance"};


        editText.setPadding(10, 8, 8, 8);


        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        checkbox3 = findViewById(R.id.checkBox3);
        checkbox4 = findViewById(R.id.checkBox4);
        checkbox5 = findViewById(R.id.checkBox5);
        checkbox6 = findViewById(R.id.checkBox6);

        CheckBox[] checkboxes = {checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6};

        for (final CheckBox checkbox : checkboxes) {
            checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Change text color and background color after clicking the checkbox
                    if (checkbox.isChecked()) {
                        checkbox.setTextColor(Color.WHITE);
                        checkbox.setBackgroundColor(Color.parseColor("#233b4d"));
                    } else {
                        checkbox.setTextColor(Color.parseColor("#233b4d"));
                        checkbox.setBackgroundColor(Color.WHITE);
                    }
                }
            });

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(RefineActivity.this, android.R.layout.simple_spinner_dropdown_item, availability);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String value = parent.getItemAtPosition(position).toString();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            final TextView distanceTextView = findViewById(R.id.distanceTxtViewSeek);


            seekBar.setThumb(getResources().getDrawable(R.drawable.custom_thumb));
            seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int distance = progress + 1;
                    distanceTextView.setText(distance + " km");
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


        }
    }


}