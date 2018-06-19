package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.IPushReporter;
import java.io.Serializable;

public abstract class BasePushBiz<INFO extends BasePushMessageInfo> implements Serializable {
    protected static final String TAG = "push.BasePushBiz";
    protected INFO mInfo = null;
    private IPushNotificationHandler<INFO> mPushNotificationHandler = null;
    protected IPushReporter<INFO> mPushReporter = null;

    public abstract IPushNotificationHandler<INFO> createPushNotificationHandler();

    public abstract BasePushReporter<INFO> createReporter();

    @NonNull
    public abstract INFO parsePushMessageInfo(PushOriginalInfo pushOriginalInfo);

    public BasePushBiz(PushOriginalInfo pushOriginalInfo) {
        this.mInfo = parsePushMessageInfo(pushOriginalInfo);
        this.mPushNotificationHandler = createPushNotificationHandler();
        this.mPushReporter = createReporter();
    }

    public a shouldInterceptNotification(Context context) {
        if (!this.mInfo.isRelatedToLogin() || this.mInfo.isCorrectReceiver()) {
            return this.mPushNotificationHandler.shouldInterceptNotification(context, this.mInfo);
        }
        new StringBuilder("intercept notification, is not correct receiver. receiver: ").append(this.mInfo.getReceiverUserId());
        return a.a(true, "invalid receiver");
    }

    public void onReceive(Context context) {
        this.mPushReporter.reportReceive(context, this.mInfo);
    }

    public void onShow(Context context) {
        this.mPushReporter.reportShow(context, this.mInfo);
    }

    public void onClick(Context context) {
        this.mPushReporter.reportClick(context, this.mInfo);
        this.mPushNotificationHandler.onClick(context, this.mInfo);
    }

    public void onDismiss(Context context) {
        this.mPushNotificationHandler.onDismiss(context, this.mInfo);
    }

    public void onError(Context context, String str) {
        this.mPushReporter.reportError(context, this.mInfo, str);
    }

    public void showNotification(Context context, String str, int i, Notification notification) {
        this.mPushNotificationHandler.showNotification(context, str, i, notification, this);
    }

    public Intent createClickIntent(Context context) {
        return this.mPushNotificationHandler.createClickIntent(context, this.mInfo);
    }

    public Notification getNotification(Context context, int i, Bitmap bitmap) {
        return this.mPushNotificationHandler.getNotification(context, this.mInfo, i, bitmap);
    }

    public String getNotificationTag() {
        return this.mPushNotificationHandler.getNotificationTag(this.mInfo);
    }

    public int getNotificationId() {
        return this.mPushNotificationHandler.getNotificationId(this.mInfo);
    }

    public INFO getInfo() {
        return this.mInfo;
    }
}
