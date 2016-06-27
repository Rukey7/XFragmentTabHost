package com.dl7.tabhost.library;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

/**
 * Created by long on 2016/6/27.
 * 波纹Drawable
 */
public class RippleDrawable extends Drawable implements Animatable {

    /**
     * 3种模式：左边、中间和右边波纹
     */
    public static final int MODE_LEFT = 1;
    public static final int MODE_MIDDLE = 2;
    public static final int MODE_RIGHT = 3;

    private int mMode = MODE_MIDDLE;
    // 前景色和后景色画笔
    private Paint mPaintFront;
    private Paint mPaintBehind;
    // 用来绘制扇形的矩形框
    private RectF mRect;
    // 目标View的宽高的一半
    private int mHalfWidth;
    private int mHalfHeight;
    // 扩散半径
    private int mRadius;
    // 前景色和背景色的分割距离
    private int mDivideSpace;
    // 扩散满视图需要的距离，中点到斜角的距离
    private int mFullSpace;
    // 动画控制
    private ValueAnimator mValueAnimator;


    public RippleDrawable(int frontColor, int behindColor, int mode) {
        mPaintFront = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintFront.setColor(frontColor);
        mPaintBehind = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintBehind.setColor(behindColor);
        mRect = new RectF();
        mMode = mode;
    }

    @Override
    public void draw(Canvas canvas) {
        if (mRadius > mHalfWidth) {
            int count = canvas.save();
            canvas.drawCircle(mHalfWidth, mHalfHeight, mHalfWidth, mPaintBehind);
            canvas.restoreToCount(count);
            count = canvas.save();
            canvas.drawCircle(mHalfWidth, mHalfHeight, mDivideSpace, mPaintFront);
            canvas.restoreToCount(count);
        } else if (mRadius > mDivideSpace) {
            int count = canvas.save();
            canvas.drawCircle(mHalfWidth, mHalfHeight, mRadius, mPaintBehind);
            canvas.restoreToCount(count);
            count = canvas.save();
            canvas.drawCircle(mHalfWidth, mHalfHeight, mDivideSpace, mPaintFront);
            canvas.restoreToCount(count);
        } else {
            canvas.drawCircle(mHalfWidth, mHalfHeight, mRadius, mPaintFront);
        }

        // 左右两边才进行扇形绘制
        if (mMode != MODE_MIDDLE) {
            mRect.left = mHalfWidth - mRadius;
            mRect.right = mHalfWidth + mRadius;
            mRect.top = mHalfHeight - mRadius;
            mRect.bottom = mHalfHeight + mRadius;
        }
        if (mMode == MODE_LEFT) {
            canvas.drawArc(mRect, 90, 180, true, mPaintFront);
        } else if (mMode == MODE_RIGHT) {
            canvas.drawArc(mRect, -90, 180, true, mPaintFront);
        }
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.RGBA_8888;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        mHalfHeight = (bounds.bottom - bounds.top) / 2;
        mHalfWidth = (bounds.right - bounds.left) / 2;
        mDivideSpace = Math.max(mHalfHeight, mHalfWidth) * 3 / 4;
        mFullSpace = (int) Math.sqrt(mHalfWidth * mHalfWidth + mHalfHeight * mHalfHeight);
        // 属性动画
        mValueAnimator = ValueAnimator.ofInt(0, mFullSpace);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRadius = (int) animation.getAnimatedValue();
                invalidateSelf();
            }
        });
        mValueAnimator.setDuration(200);
        start();
    }


    @Override
    public void start() {
        mValueAnimator.start();
    }

    @Override
    public void stop() {
        mValueAnimator.end();
    }

    @Override
    public boolean isRunning() {
        return mValueAnimator != null && mValueAnimator.isRunning();
    }
}
