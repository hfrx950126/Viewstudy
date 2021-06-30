package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyTextView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Layout过程结束之后，实际尺寸改变了，会调用
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        path.reset();
        path.addRect(getWidth() / 2 - 150, getWidth() / 2 - 300, getWidth() / 2 + 150, getHeight() / 2, Path.Direction.CCW);
        path.addCircle(getWidth() / 2, getHeight() / 2, 150, Path.Direction.CCW);
        //CW 顺时针
        //CCW 逆时针
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //WINDING 两个view 合起来的地方算内部 ？？？？  所有内部的都是内部针对同方向
        //EVEN_ODD  合起来的部分不算内部
        //INVERSE_EVEN_ODD  // 合起来的地方和 不合起来的地方
        path.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(path, paint);
//        canvas.drawLine(100, 100, 200, 200, paint);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, Utils.dp2px(150), paint);
    }
}
