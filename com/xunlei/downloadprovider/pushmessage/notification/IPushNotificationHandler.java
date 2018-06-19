package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz$a;
import java.io.Serializable;

public interface IPushNotificationHandler<INFO extends BasePushMessageInfo> extends Serializable {
    public static final String TAG = "push.IPushNotificationHandler";

    Intent createClickIntent(Context context, INFO info);

    Notification getNotification(Context context, INFO info, int i, Bitmap bitmap);

    int getNotificationId(INFO info);

    String getNotificationTag(INFO info);

    void onClick(Context context, INFO info);

    void onDismiss(Context context, INFO info);

    BasePushBiz$a shouldInterceptNotification(Context context, INFO info);

    void showNotification(Context context, String str, int i, Notification notification, BasePushBiz basePushBiz);
}
