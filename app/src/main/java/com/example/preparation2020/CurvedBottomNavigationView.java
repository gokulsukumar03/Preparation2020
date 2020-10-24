package com.example.preparation2020;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CurvedBottomNavigationView extends BottomNavigationView {
    private Path mPath;
    private Paint mPaint;

    /**
     * the CURVE_CIRCLE_RADIUS represent the radius of the fab button
     */
    private final int CURVE_CIRCLE_RADIUS = 256 / 2;
    // the coordinates of the first curve
    private Point mFirstCurveStartPoint = new Point();
    private Point mFirstCurveEndPoint = new Point();
    private Point mFirstCurveControlPoint1 = new Point();
    private Point mFirstCurveControlPoint2 = new Point();

    //the coordinates of the second curve
    @SuppressWarnings("FieldCanBeLocal")
    private Point mSecondCurveStartPoint = new Point();
    private Point mSecondCurveEndPoint = new Point();
    private Point mSecondCurveControlPoint1 = new Point();
    private Point mSecondCurveControlPoint2 = new Point();
    private int mNavigationBarWidth;
    private int mNavigationBarHeight;
    private final int TOP_ADJUSTMENT = 100;
    private final int MIDDLE_ADJUSTMENT = 80;
    private final int BOTTOM_ADJUSTMENT = 20;


    public CurvedBottomNavigationView(Context context) {
        super(context);
        init();
    }

    public CurvedBottomNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CurvedBottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.WHITE);
        setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        // get width and height of navigation bar
        // Navigation bar bounds (width & height)
        mNavigationBarWidth = getWidth();
        mNavigationBarHeight = getHeight();
        // the coordinates (x,y) of the start point before curve
        mFirstCurveStartPoint.set((mNavigationBarWidth / 2) - (CURVE_CIRCLE_RADIUS * 2) - (CURVE_CIRCLE_RADIUS / 3) + TOP_ADJUSTMENT, 0);
        // the coordinates (x,y) of the end point after curve
        mFirstCurveEndPoint.set(mNavigationBarWidth / 2 , CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));
        // same thing for the second curve
        mSecondCurveStartPoint = mFirstCurveEndPoint;
        mSecondCurveStartPoint.set(mNavigationBarWidth / 2, CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4));


        mSecondCurveEndPoint.set((mNavigationBarWidth / 2) + (CURVE_CIRCLE_RADIUS * 2) + (CURVE_CIRCLE_RADIUS / 3) - TOP_ADJUSTMENT, 0);

        // the coordinates (x,y)  of the 1st control point on a cubic curve
        mFirstCurveControlPoint1.set(mFirstCurveStartPoint.x + CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4), mFirstCurveStartPoint.y);
        // the coordinates (x,y)  of the 2nd control point on a cubic curve
        mFirstCurveControlPoint2.set(mFirstCurveEndPoint.x - (CURVE_CIRCLE_RADIUS * 2) + CURVE_CIRCLE_RADIUS - MIDDLE_ADJUSTMENT, mFirstCurveEndPoint.y +BOTTOM_ADJUSTMENT);

        mSecondCurveControlPoint1.set(mSecondCurveStartPoint.x + (CURVE_CIRCLE_RADIUS * 2) - CURVE_CIRCLE_RADIUS + MIDDLE_ADJUSTMENT, mSecondCurveStartPoint.y +BOTTOM_ADJUSTMENT);
        mSecondCurveControlPoint2.set(mSecondCurveEndPoint.x - (CURVE_CIRCLE_RADIUS + (CURVE_CIRCLE_RADIUS / 4)), mSecondCurveEndPoint.y);

        mPath.reset();
        mPath.moveTo(0, 0);
        mPath.lineTo(mFirstCurveStartPoint.x, mFirstCurveStartPoint.y);

/*        mPath.cubicTo(mFirstCurveControlPoint1.x, 0,
                mFirstCurveControlPoint2.x, 260,
                mFirstCurveEndPoint.x, 260);


        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);
                */

        mPath.cubicTo(mFirstCurveControlPoint1.x, mFirstCurveControlPoint1.y,
                mFirstCurveControlPoint2.x, mFirstCurveControlPoint2.y,
                mFirstCurveEndPoint.x, mFirstCurveEndPoint.y);


        /* D/!!!!: 582    1
           D/!!!!: 0      2
           D/!!!!: 592    3
           D/!!!!: 160    4
           D/!!!!: 720    5
           D/!!!!: 160    6*/
/*
        mPath.cubicTo(800, mSecondCurveControlPoint1.y,
                800, mSecondCurveControlPoint2.y,
                800, mSecondCurveEndPoint.y);*/

        mPath.cubicTo(mSecondCurveControlPoint1.x, mSecondCurveControlPoint1.y,
                mSecondCurveControlPoint2.x, mSecondCurveControlPoint2.y,
                mSecondCurveEndPoint.x, mSecondCurveEndPoint.y);

                    /*
         D/!!!!: 848    1
         D/!!!!: 160    2
         D/!!!!: 858    3
         D/!!!!:   0    4
         D/!!!!: 1018   5
         D/!!!!: 0      6*/

        Log.d("!!!!   ", mFirstCurveControlPoint1.x + "    1");
        Log.d("!!!!   ", mFirstCurveControlPoint1.y + "    2");
        Log.d("!!!!   ", mFirstCurveControlPoint2.x + "    3 ");
        Log.d("!!!!   ", mFirstCurveControlPoint2.y + "    4");
        Log.d("!!!!   ", mFirstCurveEndPoint.x + "    5");
        Log.d("!!!!   ", mFirstCurveEndPoint.y + "    6");

        Log.d("!!!!   ", mSecondCurveControlPoint1.x + "    1");
        Log.d("!!!!   ", mSecondCurveControlPoint1.y + "    2");
        Log.d("!!!!   ", mSecondCurveControlPoint2.x + "    3 ");
        Log.d("!!!!   ", mSecondCurveControlPoint2.y + "    4");
        Log.d("!!!!   ", mSecondCurveEndPoint.x + "    5");
        Log.d("!!!!   ", mSecondCurveEndPoint.y + "    6");

        mPath.lineTo(mNavigationBarWidth, 0);
        mPath.lineTo(mNavigationBarWidth, mNavigationBarHeight);
        mPath.lineTo(0, mNavigationBarHeight);
        mPath.close();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath, mPaint);
    }


}