package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.publiser.campaign.TopicDetailActivity.From;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;
import com.xunlei.xllib.android.XLIntent;

public class TopicPushBiz extends BasePushBiz<BasePushMessageInfo> {
    public TopicPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public BasePushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return BasePushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<BasePushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<BasePushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<BasePushMessageInfo>() {
            public int getNotificationId(BasePushMessageInfo basePushMessageInfo) {
                return 1006;
            }

            public String getNotificationTag(BasePushMessageInfo basePushMessageInfo) {
                return null;
            }

            public void onClick(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public void onDismiss(Context context, BasePushMessageInfo basePushMessageInfo) {
            }

            public Notification getNotification(Context context, BasePushMessageInfo basePushMessageInfo, int i, Bitmap bitmap) {
                i = m.a(context, basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), i);
                if (AndroidConfig.getAndroidVersion() >= 16 && bitmap != null) {
                    context = m.a(basePushMessageInfo.getTitle(), basePushMessageInfo.getDesc(), bitmap, context);
                    if (VERSION.SDK_INT >= 16) {
                        i.bigContentView = context;
                    }
                }
                return i;
            }

            public Intent createClickIntent(Context context, BasePushMessageInfo basePushMessageInfo) {
                Intent xLIntent = new XLIntent(context, LaunchActivity.class);
                xLIntent.addFlags(268435456);
                xLIntent.putExtra("dispatch_from_key", CONFIGID.HTTP_AHTTP_CACHE_DIR);
                xLIntent.putExtra("topic_tag", basePushMessageInfo.getTarget());
                xLIntent.putExtra("topic_from", From.PUSH);
                return xLIntent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, BasePushMessageInfo basePushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
