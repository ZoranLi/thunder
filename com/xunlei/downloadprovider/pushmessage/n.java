package com.xunlei.downloadprovider.pushmessage;

import com.xunlei.downloadprovider.pushmessage.bean.PushOriginalInfo;
import com.xunlei.downloadprovider.pushmessage.biz.AuctionPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.ChatPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.FollowUpdatePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.LivePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.MessageCenterPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.SilenceStartupPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.TopicPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.UrlPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.VideoPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.VideoSharePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.VideoUploadPushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.WebsiteCollectUpdatePushBiz;
import com.xunlei.downloadprovider.pushmessage.biz.a;
import com.xunlei.downloadprovider.pushmessage.exception.PushParseException;

/* compiled from: PushResultParser */
public final class n {
    public static BasePushBiz a(PushOriginalInfo pushOriginalInfo) throws PushParseException {
        a aVar = new a();
        int displayType = pushOriginalInfo.getDisplayType();
        if (MessageCenterPushBiz.isMessageCenterDisplayType(displayType)) {
            return new MessageCenterPushBiz(pushOriginalInfo);
        }
        switch (displayType) {
            case 1:
                return new VideoPushBiz(pushOriginalInfo);
            case 4:
                return new UrlPushBiz(pushOriginalInfo);
            case 5:
                return new LivePushBiz(pushOriginalInfo);
            case 7:
                return new TopicPushBiz(pushOriginalInfo);
            case 8:
                return new FollowUpdatePushBiz(pushOriginalInfo);
            case 9:
                return new VideoUploadPushBiz(pushOriginalInfo);
            case 13:
                return new ChatPushBiz(pushOriginalInfo);
            case 14:
                return new SilenceStartupPushBiz(pushOriginalInfo);
            case 20:
                return new WebsiteCollectUpdatePushBiz(pushOriginalInfo);
            case 21:
                return new VideoSharePushBiz(pushOriginalInfo);
            case 22:
                return new AuctionPushBiz(pushOriginalInfo);
            default:
                throw new PushParseException("invalid display Type");
        }
    }
}
