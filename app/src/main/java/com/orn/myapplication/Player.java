package com.orn.myapplication;

import android.graphics.Bitmap;
import android.graphics.Paint;

public class Player {
    private String name;
    private int x, y;
    private Bitmap bitmap;
    private Paint textPaint;

    public Player(String name, int x, int y, Bitmap bitmap) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.bitmap = bitmap;

        // Initialize text paint
        textPaint = new Paint();
        textPaint.setColor(android.graphics.Color.WHITE);
        textPaint.setTextSize(40);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    public boolean isTouched(float touchX, float touchY) {
        return touchX >= x && touchX <= (x + bitmap.getWidth()) &&
                touchY >= y && touchY <= (y + bitmap.getHeight());
    }

    public boolean isNameTouched(float touchX, float touchY) {
        return touchX >= x && touchX <= (x + bitmap.getWidth()) &&
                touchY >= (y + bitmap.getHeight()) && touchY <= (y + bitmap.getHeight() + 40);
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public Paint getTextPaint() {
        return textPaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
