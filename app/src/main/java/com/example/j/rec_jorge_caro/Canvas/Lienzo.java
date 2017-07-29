package com.example.j.rec_jorge_caro.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by j on 03/05/2017.
 */

public class Lienzo extends View {

    private int id, id_draw;
    private float x, y;
    private Path path;

    public Lienzo(Context context, int id) {
        super(context);
        this.id = id;
        path = new Path();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
            canvas.drawPaint(paint);
        switch (id){
            case 0:
                paint.setColor(Color.MAGENTA);
                path.addCircle(x, y, 50, Path.Direction.CCW);
                
                break;
            case 1:
                paint.setColor(Color.BLUE);
                path.addOval(x, y, x+50, y+75, Path.Direction.CCW);
                break;
            case 2:
                paint.setColor(Color.GREEN);
                path.addRect(x, y, x+50, y+50, Path.Direction.CCW);
                break;
            case 3:
                paint.setColor(Color.YELLOW);
                path.addRect(x, y, x+80, y+110, Path.Direction.CCW);
                break;
            case 4:
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(5);
                paint.setAntiAlias(true);
                paint.setColor(Color.BLACK);
                if(id_draw==1) path.moveTo(x, y);
                if(id_draw==2) path.lineTo(x, y);

        }
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event){
        int e = event.getAction();
        x = event.getX();
        y = event.getY();

        if(e==MotionEvent.ACTION_DOWN) id_draw=1;
        if(e==MotionEvent.ACTION_MOVE) id_draw=2;

        invalidate();
        return true;
    }

}
