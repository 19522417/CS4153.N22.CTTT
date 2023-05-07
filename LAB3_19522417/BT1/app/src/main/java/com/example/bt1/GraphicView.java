package com.example.bt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GraphicView extends View {
    public GraphicView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Rect r = new Rect(40, 40, 400, 200);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        canvas.drawRect(r, paint);
        invalidate();
    }
}