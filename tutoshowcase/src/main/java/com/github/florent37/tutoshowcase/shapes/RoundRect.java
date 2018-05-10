package com.github.florent37.tutoshowcase.shapes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class RoundRect extends Shape {

    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isRounded;
    public static final int BORDER_PADDING = 30;

    public RoundRect(int x, int y, int width, int height, boolean isRounded) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isRounded = isRounded;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void drawOn(Canvas canvas) {
        if (isDisplayBorder()) {
            drawRoundedRect(canvas, getX() - BORDER_PADDING, getY() - BORDER_PADDING, getX() + getWidth() + BORDER_PADDING, getY() + getHeight() + BORDER_PADDING, getBorderPaint(), isRounded);
        }
        drawRoundedRect(canvas, getX(), getY(), getX() + getWidth(), getY() + getHeight(), paint, isRounded);
    }

    private static void drawRoundedRect(Canvas canvas, float left, float top, float right, float bottom, Paint paint, boolean isRounded) {
        float radius = 0;

        if (isRounded) {
            radius = (bottom - top) / 2;
        }

        RectF rectF = new RectF(left, top, right, bottom);
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }
}
