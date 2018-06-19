package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.umeng.message.entity.UMessage;

public class NotificationTarget extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context, RemoteViews remoteViews, int i, Notification notification, int i2) {
        this(context, remoteViews, i, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i2);
    }

    public NotificationTarget(Context context, RemoteViews remoteViews, int i, int i2, int i3, Notification notification, int i4) {
        super(i2, i3);
        if (context == null) {
            throw new NullPointerException("Context must not be null!");
        } else if (notification == null) {
            throw new NullPointerException("Notification object can not be null!");
        } else if (remoteViews == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        } else {
            this.context = context;
            this.viewId = i;
            this.notification = notification;
            this.notificationId = i4;
            this.remoteViews = remoteViews;
        }
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).notify(this.notificationId, this.notification);
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
