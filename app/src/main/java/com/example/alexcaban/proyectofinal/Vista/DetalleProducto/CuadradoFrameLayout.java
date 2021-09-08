package com.example.alexcaban.proyectofinal.Vista.DetalleProducto;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class CuadradoFrameLayout extends FrameLayout {
    public CuadradoFrameLayout( Context context) {
        super(context);
    }

    public CuadradoFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CuadradoFrameLayout( Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CuadradoFrameLayout( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {


        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSize == 0 && heightSize == 0) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

            final int minSize = Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(minSize, minSize);
            return;
        }

        final int size;
        if (widthSize == 0 || heightSize == 0) {
            size = Math.max(widthSize, heightSize);
        } else {
            size = Math.min(widthSize, heightSize);
        }
        final int newMeasureSpec = MeasureSpec.makeMeasureSpec(size, MeasureSpec.EXACTLY);
        super.onMeasure(newMeasureSpec, newMeasureSpec);
    }
}
