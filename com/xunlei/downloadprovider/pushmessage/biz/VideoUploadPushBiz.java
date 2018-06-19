package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.bean.VideoUploadPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.xllib.android.XLIntent;

public class VideoUploadPushBiz extends BasePushBiz<VideoUploadPushMessageInfo> {
    public VideoUploadPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public VideoUploadPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return VideoUploadPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<VideoUploadPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<VideoUploadPushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<VideoUploadPushMessageInfo>() {
            public int getNotificationId(VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
                return 1011;
            }

            public String getNotificationTag(VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
                return null;
            }

            public void onClick(Context context, VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
            }

            public void onDismiss(Context context, VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
            }

            public Notification getNotification(Context context, VideoUploadPushMessageInfo videoUploadPushMessageInfo, int i, Bitmap bitmap) {
                return m.a(context, videoUploadPushMessageInfo.getTitle(), videoUploadPushMessageInfo.getDesc(), i);
            }

            public Intent createClickIntent(Context context, VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
                String videoId = videoUploadPushMessageInfo.getVideoId();
                String gcId = videoUploadPushMessageInfo.getGcId();
                Intent xLIntent = new XLIntent(context, LaunchActivity.class);
                xLIntent.addFlags(268435456);
                xLIntent.putExtra("from", From.PUSH.getText());
                context = new BaseVideoInfo();
                context.setVideoId(videoId);
                context.setPlayUrl(videoUploadPushMessageInfo.getUrl());
                context.setGcid(gcId);
                xLIntent.putExtra(BaseVideoInfo.JSON_KEY, context);
                xLIntent.putExtra("dispatch_from_key", SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION);
                return xLIntent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, VideoUploadPushMessageInfo videoUploadPushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
