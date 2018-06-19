package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.personal.message.d;
import com.xunlei.downloadprovider.pushmessage.bean.WebsiteCollectUpdatePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz$a;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.web.website.g.a;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.xllib.android.XLIntent;

public class WebsiteCollectUpdateNotificationHandler extends NotificationManagerPushNotificationHandler<WebsiteCollectUpdatePushMessageInfo> {
    public int getNotificationId(WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
        return PointerIconCompat.TYPE_GRAB;
    }

    public String getNotificationTag(WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
        return null;
    }

    public void onClick(Context context, WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
    }

    public void onDismiss(Context context, WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
    }

    public BasePushBiz$a shouldInterceptNotification(Context context, WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
        b.a();
        context = websiteCollectUpdatePushMessageInfo.getCustomMsgBody();
        if (!TextUtils.isEmpty(context)) {
            context = b.d(context);
            b.a();
            if (b.a(context) != null) {
                a.a();
            }
        }
        b.a();
        websiteCollectUpdatePushMessageInfo.getCollectUpdateMainPageUrl();
        b.h();
        return BasePushBiz$a.a(true, "don't need show");
    }

    public Notification getNotification(Context context, WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo, int i, Bitmap bitmap) {
        context = m.a(context, websiteCollectUpdatePushMessageInfo.getTitle(), websiteCollectUpdatePushMessageInfo.getDesc(), i);
        d.a().b();
        return context;
    }

    public Intent createClickIntent(Context context, WebsiteCollectUpdatePushMessageInfo websiteCollectUpdatePushMessageInfo) {
        Intent xLIntent = new XLIntent(context, LaunchActivity.class);
        xLIntent.addFlags(335544320);
        xLIntent.putExtra("dispatch_from_key", 1114);
        xLIntent.putExtra("jump_url", websiteCollectUpdatePushMessageInfo.getCollectUpdateMainPageUrl());
        return xLIntent;
    }
}
