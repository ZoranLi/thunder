package com.xunlei.downloadprovider.pushmessage.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.VideoPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz$a;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.p;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

public class VideoPushNotificationHandler extends NotificationManagerPushNotificationHandler<VideoPushMessageInfo> {
    public String getNotificationTag(VideoPushMessageInfo videoPushMessageInfo) {
        return null;
    }

    public void onClick(Context context, VideoPushMessageInfo videoPushMessageInfo) {
    }

    public Notification getNotification(Context context, VideoPushMessageInfo videoPushMessageInfo, int i, Bitmap bitmap) {
        if (p.a) {
            i = 0;
        }
        return m.a(context, (BasePushMessageInfo) videoPushMessageInfo, i, bitmap);
    }

    public int getNotificationId(VideoPushMessageInfo videoPushMessageInfo) {
        p.a = true;
        return 1001;
    }

    public void onDismiss(Context context, VideoPushMessageInfo videoPushMessageInfo) {
        p.a = null;
    }

    public Intent createClickIntent(Context context, VideoPushMessageInfo videoPushMessageInfo) {
        String videoId = videoPushMessageInfo.getVideoId();
        videoPushMessageInfo = videoPushMessageInfo.getGcId();
        Intent intent = new Intent(context, LaunchActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("from", From.PUSH.getText());
        context = new BaseVideoInfo();
        context.setVideoId(videoId);
        context.setGcid(videoPushMessageInfo);
        intent.putExtra(BaseVideoInfo.JSON_KEY, context);
        intent.putExtra("dispatch_from_key", SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION);
        context = new StringBuilder("createNewIntent movieId=");
        context.append(videoId);
        context.append(",gcId=");
        context.append(videoPushMessageInfo);
        p.a = null;
        return intent;
    }

    public BasePushBiz$a shouldInterceptNotification(Context context, VideoPushMessageInfo videoPushMessageInfo) {
        return BasePushBiz$a.a(null, "");
    }
}
