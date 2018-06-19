package com.xunlei.tdlive.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.umeng.message.entity.UMessage;
import com.xunlei.tdlive.modal.JsonWrapper;
import com.xunlei.tdlive.modal.c;
import com.xunlei.tdlive.protocol.XLLiveDeletePlayRecordRequest;
import com.xunlei.tdlive.protocol.XLLiveExposureReportedRequest;
import com.xunlei.tdlive.protocol.XLLiveGetPlayRecordRequest;
import com.xunlei.tdlive.protocol.XLLiveGetStoryDataRequest;
import com.xunlei.tdlive.protocol.XLLivePushTagRequest;
import com.xunlei.tdlive.protocol.XLLiveReportPushResultRequest;
import com.xunlei.tdlive.route.XLLiveRouteDispatcher;
import com.xunlei.tdlive.util.XLog;
import com.xunlei.tdlive.util.a;

public abstract class BasePlugin {
    public static int CLIENT_NOFITY_BASE = 2000;
    public static int CLIENT_NOFITY_INIT = 2000;
    public static int CLIENT_NOFITY_NO_NETWORK_ERROR = (CLIENT_NOFITY_BASE + 2);
    public static int CLIENT_NOFITY_REFRESH_LIST_END = (CLIENT_NOFITY_BASE + 1);
    public static int ERROR_VIEW_TYPE_EMPTY = 0;
    public static int ERROR_VIEW_TYPE_GONE = 1;
    public static int ERROR_VIEW_TYPE_INVALID_NETWORK = 2;
    public static int ERROR_VIEW_TYPE_OTHER = -1;
    public static int HOST_NOFITY_BASE = 1000;
    public static int HOST_NOFITY_PAGE_DESELECTED = (HOST_NOFITY_BASE + 2);
    public static int HOST_NOFITY_PAGE_SELECTED = (HOST_NOFITY_BASE + 1);
    public static int HOST_NOFITY_REFRESH_LIST = 1000;
    private static String a = "BasePlugin";
    private static int g;
    private final String b = UMessage.NOTIFICATION_GO_APP;
    private final String c = UMessage.NOTIFICATION_GO_URL;
    private final String d = "go_home";
    private final String e = "go_room";
    private final String f = UMessage.NOTIFICATION_GO_ACTIVITY;
    private boolean h;
    private String i;
    private SharedPreferences j;
    private long k;

    public void enableLivePlaySpk(Context context, FrameLayout frameLayout, boolean z) {
    }

    public abstract View newErrorView(Context context, OnClickListener onClickListener);

    public abstract void setErrorViewType(Context context, View view, int i);

    public void showRoomView(Context context, FrameLayout frameLayout, String str, boolean z, boolean z2) {
    }

    public void startLivePlay(Context context, FrameLayout frameLayout, int i, boolean z, String str) {
    }

    public void stopLivePlay(Context context, FrameLayout frameLayout) {
    }

    public XLLiveRouteDispatcher getRouteDispatcher() {
        return XLLiveRouteDispatcher.getInstance();
    }

    public BasePlugin(Context context, String str, IStator iStator) {
        if (g != 0) {
            throw new RuntimeException("BasePlugin只能有一个实例，请确认");
        }
        g++;
        this.j = context.getApplicationContext().getSharedPreferences("xllive_sdk_pf", 0);
        this.i = str;
        XLog.enableLog(false);
        a.a(context);
        c.a().a(this);
        a.a(context, new IStator[]{iStator});
        b.a().a(this.i);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        g = 0;
    }

    public void setLiveAppPluginVersion(Context context, String str) {
        c.a(context, str, 0);
    }

    public String getVersion(Context context) {
        return c.d(context);
    }

    public SharedPreferences getSharedPreferences() {
        return this.j;
    }

    public Fragment newLiveListFragment(Bundle bundle, Handler handler) {
        if (!this.h) {
            this.h = true;
            a.a("app_on_desk", "normal", null, null);
        }
        Fragment aVar = new com.xunlei.tdlive.b.a();
        aVar.setArguments(bundle);
        if (handler != null) {
            aVar.a(handler);
        }
        return aVar;
    }

    public void openUserLiveReplayRoom(Context context, String str, String str2) {
        context = new JsonWrapper(str);
        if (context.isValid() != null && context.getInt("status", 0) == 2) {
            str = context.getObject("userinfo", "{}");
            getRouteDispatcher().replay(context.getString("roomid", ""), str.getString("userid", context.getString("userid", "")), context.getString("play_hls_url", ""), str.getString("avatar", ""), context.getString("image", ""), str2);
        }
    }

    public void openUserLivePlayRoom(Context context, String str, String str2) {
        context = new JsonWrapper(str);
        if (context.isValid()) {
            getRouteDispatcher().room(context.getString("roomid", ""), context.getString("userid", ""), context.getString("stream_pull", ""), context.getString("avatar", ""), context.getString("image", ""), str2);
            return;
        }
        if (!(str == null || TextUtils.isDigitsOnly(str) == null)) {
            getRouteDispatcher().room(null, str, null, null, null, str2);
        }
    }

    public void openLiveWelfare(Context context, String str) {
        getRouteDispatcher().webview("http://h5.live.xunlei.com/active/2017/active/welfare.html", "直播福利", false);
    }

    public void openUserLivePlayRecord(Context context, String str, String str2, String str3) {
        getRouteDispatcher().replaylist(str, str2, str3);
    }

    public final void notifyUserLoginFinished() {
        b.a().c();
    }

    public final void notifyUserLogout() {
        b.a().a(false, "", 0, "", "");
    }

    public final void notifyUserLogin(String str, int i, String str2, String str3) {
        b.a().a(true, str, i, str2, str3);
        if (b.a().b() != null) {
            new XLLivePushTagRequest(XLLivePushTagRequest.T_ADD, this.i).send(null);
        } else {
            new XLLivePushTagRequest(XLLivePushTagRequest.T_REMOVE, this.i).send(null);
        }
    }

    public final void notifyUserInfoGot(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        b.a().a(false, str, str2, str3, str4, str5, str6, str7);
    }

    public final void notifyCanceledPushNotification(Context context, String str) {
        context = a;
        StringBuilder stringBuilder = new StringBuilder("notifyCanceledPushNotification(): ");
        stringBuilder.append(str);
        XLog.d(context, stringBuilder.toString());
        context = new JsonWrapper(str);
        if (UMessage.NOTIFICATION_GO_APP.equals(context.getString("after_open", "")) != null) {
            if ("go_room".equals(context.getString("business", "")) != null) {
                new XLLiveReportPushResultRequest(context.getObject("extra", "{}").getString("userid", ""), false).send(null);
            }
        }
    }

    public final void notifyClickPushNotification(Context context, String str) {
        context = new JsonWrapper(str);
        str = context.getString("after_open", "");
        if (UMessage.NOTIFICATION_GO_URL.equals(str)) {
            getRouteDispatcher().webview(context.getString("url", ""), context.getString("title", ""), false);
            return;
        }
        if (UMessage.NOTIFICATION_GO_APP.equals(str) != null) {
            str = context.getString("business", "");
            if ("go_room".equals(str)) {
                context = context.getObject("extra", "{}");
                String string = context.getString("roomid", "");
                str = context.getString("userid", "");
                String string2 = context.getString("stream_pull", "");
                String string3 = context.getString("image", "");
                String str2 = str;
                getRouteDispatcher().room(string, str2, string2, context.getString("avatar", ""), string3, "sl_push_main_item");
                new XLLiveReportPushResultRequest(str, true).send(null);
            } else if ("go_home".equals(str) != null) {
                getRouteDispatcher().home();
            }
        }
    }

    public void getPlayRecord(Callback callback) {
        if (callback != null) {
            new XLLiveGetPlayRecordRequest().send(new 1(this, callback));
        }
    }

    public void deletePlayRecord(Callback callback, String... strArr) {
        new XLLiveDeletePlayRecordRequest(strArr).send(new 2(this, callback));
    }

    public void getStoryData(Callback callback) {
        if (callback != null) {
            long j = this.k + 1;
            this.k = j;
            new XLLiveGetStoryDataRequest(j).send(new 3(this, callback));
        }
    }

    public void reportedExposureCards(Callback callback, String str) {
        new XLLiveExposureReportedRequest(str).send(new 4(this, callback));
    }
}
