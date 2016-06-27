package com.dl7.tabhost.library;

import android.graphics.drawable.Drawable;

/**
 * Created by long on 2016/4/15.
 * Tab项
 */
public class TabItem {

    private String title;
    private Drawable drawable;
    private int imageRes;

    public TabItem(String title, Drawable drawable, int imageRes) {
        this.title = title;
        this.drawable = drawable;
        this.imageRes = imageRes;
    }

    public TabItem(String title, int imageRes) {
        this.title = title;
        this.drawable = null;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
