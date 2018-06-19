package com.xunlei.downloadprovider.pushmessage.biz;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.pushmessage.bean.AuctionPushMessageInfo;
import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.m;
import com.xunlei.downloadprovider.pushmessage.notification.IPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.notification.NotificationManagerPushNotificationHandler;
import com.xunlei.downloadprovider.pushmessage.report.BasePushReporter;
import com.xunlei.downloadprovider.pushmessage.report.GeneralPushReporter;

public class AuctionPushBiz extends BasePushBiz<AuctionPushMessageInfo> {
    public AuctionPushBiz(PushOriginalInfo pushOriginalInfo) {
        super(pushOriginalInfo);
    }

    @NonNull
    public AuctionPushMessageInfo parsePushMessageInfo(PushOriginalInfo pushOriginalInfo) {
        return AuctionPushMessageInfo.parse(pushOriginalInfo);
    }

    public BasePushReporter<AuctionPushMessageInfo> createReporter() {
        return new GeneralPushReporter();
    }

    public IPushNotificationHandler<AuctionPushMessageInfo> createPushNotificationHandler() {
        return new NotificationManagerPushNotificationHandler<AuctionPushMessageInfo>() {
            public String getNotificationTag(AuctionPushMessageInfo auctionPushMessageInfo) {
                return "auction_transaction_state";
            }

            public void onClick(Context context, AuctionPushMessageInfo auctionPushMessageInfo) {
            }

            public void onDismiss(Context context, AuctionPushMessageInfo auctionPushMessageInfo) {
            }

            public Notification getNotification(Context context, AuctionPushMessageInfo auctionPushMessageInfo, int i, Bitmap bitmap) {
                return m.a(context, auctionPushMessageInfo.getTitle(), auctionPushMessageInfo.getDesc(), i);
            }

            public int getNotificationId(AuctionPushMessageInfo auctionPushMessageInfo) {
                return auctionPushMessageInfo.getNotificationId();
            }

            public Intent createClickIntent(Context context, AuctionPushMessageInfo auctionPushMessageInfo) {
                Intent intent = new Intent(context, LaunchActivity.class);
                intent.addFlags(268435456);
                intent.putExtra("push_msg_info", auctionPushMessageInfo);
                intent.putExtra("dispatch_from_key", 1118);
                return intent;
            }

            public BasePushBiz$a shouldInterceptNotification(Context context, AuctionPushMessageInfo auctionPushMessageInfo) {
                return BasePushBiz$a.a(null, "");
            }
        };
    }
}
