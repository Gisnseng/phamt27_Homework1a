// @ Quince
package com.example.homework1a;
import java.util.Random;

public class Face {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;

    public Face() {
        this.randomize();
    }

    public void randomize() {
        Random random = new Random();
//I think having the colors be ints instead of int[] would be weird considering we're using rgb
        skinColor = random.nextInt(5);
        eyeColor = random.nextInt(5);
        hairColor = random.nextInt(5);
        hairStyle = random.nextInt(5);
    }

public void onDraw() {}
    //helper methods
    public void drawEyes() {}
    public void drawEpidermis() {}
    public void drawHair() {}
}
