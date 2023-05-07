package com.example.bt4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class GraphicView extends View {
    Bitmap[] frames = new Bitmap[16]; // 16 frames
    int i = 0;
    MediaPlayer mediaPlayer;

    public GraphicView(Context context) {
        super(context);

        frames[0] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_1);
        frames[1] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_2);
        frames[2] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_3);
        frames[3] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_lookism);
        frames[4] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_5);
        frames[5] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_1);
        frames[6] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_2);
        frames[7] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_3);
        frames[8] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_lookism);
        frames[9] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_5);
        frames[10] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_1);
        frames[11] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_2);
        frames[12] = BitmapFactory.decodeResource(getResources(), R.drawable.daniel_5);
        frames[13] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_1);
        frames[14] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_2);
        frames[15] = BitmapFactory.decodeResource(getResources(), R.drawable.eli_5);

        mediaPlayer = MediaPlayer.create(context, R.raw.music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (i < 16) {
            canvas.drawBitmap(frames[i], 40, 40, new Paint());
        } else {
            i = 0;
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        i++;
        return true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}