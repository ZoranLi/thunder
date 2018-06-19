package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.animation.GlideAnimation;

public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i, int i2, int i3, int... iArr) {
        super(i2, i3);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        } else if (iArr == null) {
            throw new NullPointerException("WidgetIds can not be null!");
        } else if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        } else if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        } else {
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = i;
            this.widgetIds = iArr;
            this.componentName = null;
        }
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i, int... iArr) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i, int i2, int i3, ComponentName componentName) {
        super(i2, i3);
        if (context == null) {
            throw new NullPointerException("Context can not be null!");
        } else if (componentName == null) {
            throw new NullPointerException("ComponentName can not be null!");
        } else if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        } else {
            this.context = context;
            this.remoteViews = remoteViews;
            this.viewId = i;
            this.componentName = componentName;
            this.widgetIds = null;
        }
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i, ComponentName componentName) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }

    private void update() {
        AppWidgetManager instance = AppWidgetManager.getInstance(this.context);
        if (this.componentName != null) {
            instance.updateAppWidget(this.componentName, this.remoteViews);
        } else {
            instance.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
