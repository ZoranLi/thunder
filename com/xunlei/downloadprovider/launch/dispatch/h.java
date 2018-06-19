package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.frame.MainTabSpec$Tab;
import com.xunlei.downloadprovider.frame.dispatch.info.MainTabAuctionDispatchInfo;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.ac;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.b.p;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.IChatMessage;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.a.b;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.info.MessageCenterDispatchInfo;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view.MessageCenterActivity;
import com.xunlei.downloadprovider.publiser.campaign.TopicDetailActivity;
import com.xunlei.downloadprovider.pushmessage.bean.AuctionPushMessageInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.base.PushWebViewNormalActivity;
import java.io.Serializable;

/* compiled from: PushDISP */
public final class h extends b {
    public static String a = "live_special_key";
    private Intent b;
    private int c;

    protected final boolean a(Intent intent) {
        this.b = intent;
        if (this.b == null) {
            return false;
        }
        intent = this.b.getIntExtra("dispatch_from_key", -1);
        this.c = intent;
        if (intent == 1103 || intent == 1104 || intent == 1106 || intent == 1105 || intent == 1110 || intent == 1112 || intent == 1111 || intent == 1114 || intent == 1116 || intent == 1115 || intent == 1118) {
            return true;
        }
        return false;
    }

    protected final void a(Context context) {
        new StringBuilder("enterConcreateActivity. from: ").append(this.c);
        LoginHelper.a();
        if (!l.b()) {
            LoginHelper.a().a(false);
        }
        String stringExtra;
        Serializable serializableExtra;
        switch (this.c) {
            case SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH /*1103*/:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                this.b.setClass(context, PushWebViewNormalActivity.class);
                this.b.putExtra("dispatch_from_key", 0);
                context.startActivity(this.b);
                c.a("push_url", true);
                return;
            case SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION /*1104*/:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                this.b.setClass(context, ShortMovieDetailActivity.class);
                this.b.putExtra("dispatch_from_key", 0);
                context.startActivity(this.b);
                c.a("push_video", true);
                return;
            case 1105:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                LoginHelper.a();
                if (l.c()) {
                    this.b.putExtra("dispatch_from_key", 0);
                    MessageCenterActivity.a(context, this.b);
                    c.a("push_community", true);
                    return;
                }
                break;
            case 1106:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                a.a().notifyClickPushNotification(context, this.b.getStringExtra(a));
                c.a("push_zhibo", true);
                return;
            case CONFIGID.HTTP_AHTTP_CACHE_DIR /*1110*/:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                this.b.setClass(context, TopicDetailActivity.class);
                this.b.putExtra("dispatch_from_key", 0);
                context.startActivity(this.b);
                c.a("push_topic", true);
                return;
            case CONFIGID.HTTP_AHTTP_USE_CACHE /*1111*/:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                this.b.putExtra("dispatch_from_key", 0);
                Bundle bundle = new Bundle(2);
                bundle.putString("home_sub_tab_tag", "follow");
                bundle.putString("follow_tab_from", "follow_tab_from_push");
                MainTabActivity.b(context, "thunder", bundle);
                c.a("push_follow_update", true);
                return;
            case 1112:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                long longExtra = this.b.getLongExtra(com.umeng.message.proguard.l.m, -1);
                CharSequence stringExtra2 = this.b.getStringExtra("download_from");
                com.xunlei.downloadprovider.download.a.a(context, longExtra, stringExtra2);
                if (TextUtils.isEmpty(stringExtra2) == null) {
                    c.a("push_local", true);
                }
                return;
            case 1114:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                stringExtra = this.b.getStringExtra("jump_url");
                if (TextUtils.isEmpty(stringExtra)) {
                    com.xunlei.downloadprovider.download.a.a(context);
                    return;
                }
                BrowserFrom browserFrom = BrowserFrom.COLLECT_WEBSITE_UPDATE;
                com.xunlei.downloadprovider.web.a.a();
                com.xunlei.downloadprovider.web.a.a(context, stringExtra, false, browserFrom);
                return;
            case 1115:
                new StringBuilder("enterConcreateActivity ").append(getClass().getSimpleName());
                if (b.c() && com.xunlei.downloadprovider.personal.message.chat.chatengine.b.a.a().b) {
                    this.b.putExtra("dispatch_from_key", 0);
                    serializableExtra = this.b.getSerializableExtra("chat_push_msg_body");
                    MessageCenterDispatchInfo messageCenterDispatchInfo = new MessageCenterDispatchInfo();
                    messageCenterDispatchInfo.setFrom("push_click");
                    messageCenterDispatchInfo.setTo(5);
                    if (serializableExtra instanceof String) {
                        IChatMessage a = ((ac) p.a(ac.class)).a((String) serializableExtra);
                        if (!(a == null || a.chatDialog() == null)) {
                            messageCenterDispatchInfo.setTo(4);
                            messageCenterDispatchInfo.setChatDialogId(a.chatDialog().dialogId());
                        }
                    }
                    MessageCenterActivity.a(context, this.b, messageCenterDispatchInfo);
                    c.a("push_chat", true);
                    return;
                }
            case 1116:
                new StringBuilder("enterConcreateActivity ").append(context);
                stringExtra = this.b.getStringExtra("resType");
                j.a();
                j.a(context, stringExtra);
                c.a(stringExtra, true);
                return;
            case 1118:
                serializableExtra = this.b.getSerializableExtra("push_msg_info");
                if (serializableExtra instanceof AuctionPushMessageInfo) {
                    AuctionPushMessageInfo auctionPushMessageInfo = (AuctionPushMessageInfo) serializableExtra;
                    Bundle bundle2 = new Bundle();
                    Serializable mainTabAuctionDispatchInfo = new MainTabAuctionDispatchInfo();
                    mainTabAuctionDispatchInfo.setFrom("push");
                    mainTabAuctionDispatchInfo.setTo(1);
                    mainTabAuctionDispatchInfo.setAuctionOrderDetailUrl(auctionPushMessageInfo.getLandingUrl());
                    bundle2.putSerializable("dispatch_info", mainTabAuctionDispatchInfo);
                    MainTabActivity.a(context, MainTabSpec$Tab.FIND.getTag(), bundle2, false);
                    return;
                }
                break;
            default:
                break;
        }
        MainTabActivity.a(context, MainTabSpec$Tab.THUNDER.getTag(), null, true);
    }
}
