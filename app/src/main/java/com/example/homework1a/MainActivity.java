// @ Quince
package com.example.homework1a;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    //declare appcontrollers and views for appcontroller
    private AppController myAppController = new AppController(this);
    public Face face;
    public RadioButton hairButton;
    public RadioButton eyeButton;
    public RadioButton skinButton;
    public SeekBar redSeekBar;
    public SeekBar greenSeekBar;
    public SeekBar blueSeekBar;
    public Spinner dropdown;
    public Button randomFaceButton;

    //set controller but it doesn't do anything yet
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set and add listeners for a lot of stuff
        randomFaceButton = findViewById(R.id.randomFaceButton);
        randomFaceButton.setOnClickListener(myAppController);
        face = findViewById(R.id.face);
        //set buttons
        hairButton = findViewById(R.id.hairButton);
        hairButton.setOnClickListener(myAppController);
        eyeButton = findViewById(R.id.eyeButton);
        eyeButton.setOnClickListener(myAppController);
        skinButton = findViewById(R.id.skinButton);
        skinButton.setOnClickListener(myAppController);
        //set seekbars and textbars
        redSeekBar = findViewById(R.id.redSeekbar);
        redSeekBar.setOnSeekBarChangeListener(myAppController);
        greenSeekBar = findViewById(R.id.greenSeekbar);
        greenSeekBar.setOnSeekBarChangeListener(myAppController);
        blueSeekBar = findViewById(R.id.blueSeekbar);
        blueSeekBar.setOnSeekBarChangeListener(myAppController);

        TextView redText = findViewById(R.id.redText);
        TextView greenText = findViewById(R.id.greenText);
        TextView blueText = findViewById(R.id.blueText);
        //set spinner
        dropdown = findViewById(R.id.hairStyleSelectors);
        dropdown.setOnItemSelectedListener(myAppController);
        //I took the following from guides.copath.com/Using-an-array-adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myAppController.strings);
        dropdown.setAdapter(arrayAdapter);
        // I have to randomize the dropdown here because it selects once when it's created
        // and face doesn't have access to the spinner
        dropdown.setSelection((int)Math.round(Math.random()*2));
    }}