package com.example.patri.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by Patri on 19.4.16.
 */
public class MainDrawingView extends View
{
    private Paint paint = new Paint();
    private Path path = new Path();
    private Button save;

    public MainDrawingView(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, paint);
    }

    public boolean onTouchEvent(MotionEvent event)
    {
        float eventX = event.getX();
        float eventY = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public void addListenerOnButton()
    {
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }
        });
    }

    public void clear(Canvas canvas)
    {

    }
}
