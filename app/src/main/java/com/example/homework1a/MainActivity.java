// @ Quince
package com.example.homework1a;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.homework1a.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private AppController myAppController = new AppController();
    //set controller but it doesn't do anything yet
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set buttons
        RadioButton hairButton = findViewById(R.id.hairButton);
        RadioButton eyeButton = findViewById(R.id.eyeButton);
        RadioButton skinButton = findViewById(R.id.skinButton);
        //set seekbars and textbars
        SeekBar redSeekBar = findViewById(R.id.redSeekbar);
        SeekBar greenSeekBar = findViewById(R.id.greenSeekbar);
        SeekBar blueSeekBar = findViewById(R.id.blueSeekbar);
        TextView redText = findViewById(R.id.redText);
        TextView greenText = findViewById(R.id.greenText);
        TextView blueText = findViewById(R.id.blueText);
        //set spinner
        Spinner dropdown = findViewById(R.id.hairStyleSelectors);
        //I took the following from guides.copath.com/Using-an-array-adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myAppController.strings);
        dropdown.setAdapter(arrayAdapter);
    }}