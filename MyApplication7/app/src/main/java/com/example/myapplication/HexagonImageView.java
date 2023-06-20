package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class HexagonImageView extends AppCompatImageView {
    private Path hexagonPath;

    public HexagonImageView(Context context) {
        super(context);
        init();
    }

    public HexagonImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HexagonImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        hexagonPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(hexagonPath);
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        updateHexagonPath(width, height);
    }

    private void updateHexagonPath(int width, int height) {
        hexagonPath.reset();
        hexagonPath.moveTo(width / 2, 0);
        hexagonPath.lineTo(width, height / 4);
        hexagonPath.lineTo(width, height * 3 / 4);
        hexagonPath.lineTo(width / 2, height);
        hexagonPath.lineTo(0, height * 3 / 4);
        hexagonPath.lineTo(0, height / 4);
        hexagonPath.close();
    }
}
