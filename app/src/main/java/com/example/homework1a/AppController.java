// @Quince
package com.example.homework1a;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemSelectedListener {
    public String[] strings = new String[] {"normal", "bald", "mohawk"};
    MainActivity mainActivity;
    //Give appcontroller main activity
    public AppController (MainActivity mainActivity) {

        this.mainActivity = mainActivity;
    }
    //I kept the strings here
    @Override
    public void onClick(View v) {
        //check which button it is and set relevant stuff
        if (v == mainActivity.hairButton)
        {
            //set which piece we're on and turn the other buttons off. Set progress bars to current progress
            mainActivity.face.currentColoring = "hair";
        mainActivity.eyeButton.setChecked(false);
        mainActivity.skinButton.setChecked(false);
        mainActivity.redSeekBar.setProgress(Color.red(mainActivity.face.hairColor));
        mainActivity.greenSeekBar.setProgress(Color.green(mainActivity.face.hairColor));
        mainActivity.blueSeekBar.setProgress(Color.blue(mainActivity.face.hairColor));
        }
        if (v == mainActivity.skinButton)
        {
            mainActivity.face.currentColoring = "skin";
        mainActivity.eyeButton.setChecked(false);
        mainActivity.hairButton.setChecked(false);
            mainActivity.redSeekBar.setProgress(Color.red(mainActivity.face.skinColor));
            mainActivity.greenSeekBar.setProgress(Color.green(mainActivity.face.skinColor));
            mainActivity.blueSeekBar.setProgress(Color.blue(mainActivity.face.skinColor));


        }
        if (v == mainActivity.eyeButton)
        {
        mainActivity.face.currentColoring = "eye";
        mainActivity.skinButton.setChecked(false);
        mainActivity.hairButton.setChecked(false);
            mainActivity.redSeekBar.setProgress(Color.red(mainActivity.face.eyeColor));
            mainActivity.greenSeekBar.setProgress(Color.green(mainActivity.face.eyeColor));
            mainActivity.blueSeekBar.setProgress(Color.blue(mainActivity.face.eyeColor));
        }
        //randomizes
        if (v == mainActivity.randomFaceButton) {mainActivity.face.randomize(); mainActivity.dropdown.setSelection((int)Math.round(Math.random()*2));}
        mainActivity.face.invalidate();
    }
    @Override
    public void onProgressChanged(SeekBar s, int colorComponent, boolean bool)
    {
    if (mainActivity.face.currentColoring.equals("eye"))
    { //changes color to match progress bars
        mainActivity.face.eyeColor = Color.rgb(mainActivity.redSeekBar.getProgress(), mainActivity.greenSeekBar.getProgress(), mainActivity.blueSeekBar.getProgress());
    }
    if (mainActivity.face.currentColoring.equals("skin"))
    {
        mainActivity.face.skinColor = Color.rgb(mainActivity.redSeekBar.getProgress(), mainActivity.greenSeekBar.getProgress(), mainActivity.blueSeekBar.getProgress());
    }
    if (mainActivity.face.currentColoring.equals("hair"))
    {
        mainActivity.face.hairColor = Color.rgb(mainActivity.redSeekBar.getProgress(), mainActivity.greenSeekBar.getProgress(), mainActivity.blueSeekBar.getProgress());
    }
        mainActivity.face.invalidate();
    }
    public void onStartTrackingTouch(SeekBar s) {}
    public void onStopTrackingTouch(SeekBar s) {}
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View v, int i, long l)
    {
        //change hair when changed
        mainActivity.face.setHair(i);
        mainActivity.face.invalidate();
    };
    public void onNothingSelected(AdapterView<?> adapterView) {}

}
