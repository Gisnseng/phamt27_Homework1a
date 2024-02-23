// @ Quince
package com.example.homework1a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

public class Face extends SurfaceView {
    public Face (Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setWillNotDraw(false);
        setBackgroundColor(Color.WHITE);
        this.randomize();
    }
    String currentColoring = "";
    Paint eyePaint = new Paint();
    Paint epidermisPaint = new Paint();
    Paint hairPaint = new Paint();
    Paint scleraPaint = new Paint();
    @Override
    protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    hairPaint.setColor(hairColor);
    epidermisPaint.setColor(skinColor);
    eyePaint.setColor(eyeColor);
    scleraPaint.setColor(Color.WHITE);
    drawEpidermis(canvas);
    drawEyes(canvas);
    drawHair(canvas);
    }
    public void drawEyes(Canvas canvas)
    {// the draw methods should be self-explanatory
    canvas.drawOval((float) (this.getLeft() + this.getWidth()*(2.0/3))-75, (float) (this.getTop()-this.getHeight()*(2.0/3))-75, (float) (this.getLeft() + this.getWidth()*(2.0/3) +150), (float) (this.getTop()-this.getHeight()*(2.0/3) + 150), scleraPaint);
    canvas.drawOval((float) (this.getLeft() + this.getWidth()*(1.0/3))-75, (float) (this.getTop()-this.getHeight()*(2.0/3))-75, (float) (this.getLeft() + this.getWidth()*(1.0/3) +150), (float) (this.getTop()-this.getHeight()*(2.0/3) + 150), scleraPaint);
    canvas.drawOval((float) (this.getLeft() + this.getWidth()*(2.0/3)), (float) (this.getTop()-this.getHeight()*(2.0/3)), (float) (this.getLeft() + this.getWidth()*(2.0/3) +50), (float) (this.getTop()-this.getHeight()*(2.0/3) + 50), eyePaint);
    canvas.drawOval((float) (this.getLeft() + this.getWidth()*(1.0/3)), (float) (this.getTop()-this.getHeight()*(2.0/3)), (float) (this.getLeft() + this.getWidth()*(1.0/3) +50), (float) (this.getTop()-this.getHeight()*(2.0/3) + 50), eyePaint);
    }
    public void drawEpidermis(Canvas canvas)
    {
    canvas.drawOval(this.getLeft()+50, this.getTop()-this.getHeight()+50, this.getRight()-50, this.getTop()-50, epidermisPaint);
    }
    public void drawHair(Canvas canvas)
    {
    if (hairStyle == 1) {return;}
    if (hairStyle == 0)
    {
        canvas.drawOval(this.getLeft() + this.getWidth()/5, this.getTop()-this.getHeight(), this.getRight() - this.getWidth()/5, this.getTop()-(this.getHeight()*3)/4, hairPaint);
    }
    if (hairStyle == 2)
    {
        canvas.drawOval(this.getLeft() + this.getWidth()/3, this.getTop()-this.getHeight()-200, this.getRight() - this.getWidth()/3, this.getTop()-(this.getHeight()*3)/4, hairPaint);
    }

    }
    //the color
    int skinColor = 0;
    int eyeColor = 0;
    int hairColor = 0;
    int hairStyle = 0;


    public void randomize() {
        Random random = new Random();
        for (int i = 0; i < 3; i++)
        {
            int r = random.nextInt(255);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            if (i == 0) {hairColor = Color.rgb(r, g, b);}
            if (i == 1) {eyeColor = Color.rgb(r, g,b);}
            if (i == 2) {skinColor = Color.rgb(r, b, b);}
            //spinner sets the hairstyle to default
            //at start and I can't access controller or main from here
            //so part of this code is in the controller class
        }
    }
    public void setHair(int i)
    {
        hairStyle = i;
    }

}
