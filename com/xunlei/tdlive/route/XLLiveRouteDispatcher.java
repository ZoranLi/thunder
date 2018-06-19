package com.xunlei.tdlive.route;

import com.alipay.sdk.cons.c;
import com.xunlei.tdlive.route.util.UriBuilder;
import org.android.agoo.common.AgooConstants;

public class XLLiveRouteDispatcher {
    private static XLLiveRouteDispatcher a;

    public static XLLiveRouteDispatcher getInstance() {
        if (a == null) {
            synchronized (XLLiveRouteDispatcher.class) {
                if (a == null) {
                    a = new XLLiveRouteDispatcher();
                }
            }
        }
        return a;
    }

    public void login(boolean z) {
        a(b("login").addParam("silent", z).toString());
    }

    public void authPhone(String str) {
        a(b("authPhone").addParam("from", str).toString());
    }

    public void pay(int i, int i2, String str, int i3, String str2) {
        a(b("pay").addParam("payType", i).addParam("vasType", i2).addParam("payNum", i3).addParam("paySource", str).addParam("obj", str2).toString());
    }

    public void openVip() {
        a(b("openVip").toString());
    }

    public void share(int i, String str, String str2, String str3, String str4) {
        a(b("share").addParam("type", i).addParam("imageUrl", str).addParam("shareUrl", str2).addParam("title", str3).addParam("content", str4).toString());
    }

    public void home() {
        a(b("home").toString());
    }

    public void livePage() {
        a(b("livePage").toString());
    }

    public void userCenter(String str, String str2, String str3, String str4) {
        a(b("userCenter").addParam("userid", str).addParam("nickname", str2).addParam("avatar", str3).addParam("from", str4).toString());
    }

    public void webview(String str, String str2, boolean z) {
        a(b("webview").addParam("url", str).addParam("title", str2).addParam("showBtn", z).toString());
    }

    public void room(String str, String str2, String str3, String str4, String str5, String str6) {
        a(b("room").addParam("roomid", str).addParam("userid", str2).addParam("avatar", str4).addParam("image", str5).addParam("stream", str3).addParam("from", str6).toString());
    }

    public void replay(String str, String str2, String str3, String str4, String str5, String str6) {
        a(b("replay").addParam("roomid", str).addParam("userid", str2).addParam("avatar", str4).addParam("image", str5).addParam("stream", str3).addParam("from", str6).toString());
    }

    public void replaylist(String str, String str2, String str3) {
        a(b("replaylist").addParam("userid", str).addParam("avatar", str3).addParam("nickname", str2).toString());
    }

    public void followlist(String str, String str2, String str3, String str4) {
        a(b("followlist").addParam("userid", str).addParam("nickname", str2).addParam("avatar", str3).addParam("view", str4).toString());
    }

    public void rank(int i) {
        a(b("rank").addParam("type", i).toString());
    }

    public void pklist() {
        a(b("pklist").toString());
    }

    public void channel(int i) {
        a(b("channel").addParam(AgooConstants.MESSAGE_ID, i).toString());
    }

    public void categorylist(String str, String str2) {
        a(b("categorylist").addParam(AgooConstants.MESSAGE_ID, str).addParam(c.e, str2).toString());
    }

    public void compatDispatch(int i, String str, String str2) {
        a(b("compatDispatch").addParam("type", i).addParam("title", str).addParam("url", str2).toString());
    }

    public void compatDispatch(String str) {
        a(b("compatDispatch").addParam("url", str).toString());
    }

    public void userLevelUp(int i, String str) {
        a(b("userLevelUp").addParam("newLevel", i).addParam("levelIcon", str).toString());
    }

    public void dailyCheckIn(boolean z, String str) {
        a(b("dailyCheckIn").addParam("autoCheckIn", z).addParam("from", str).toString());
    }

    public void uploadShortVideo() {
        a(c("upload").toString());
    }

    public void draftShortVideo() {
        a(c("draft").toString());
    }

    public void masterApprentice() {
        a(c("masterApprentice").toString());
    }

    public void clearVideoCache() {
        a(c("clearVideoCache").toString());
    }

    public void myShortVideo() {
        a(c("myShortVideo").toString());
    }

    public void search() {
        a(c("search").toString());
    }

    public void debug() {
        a(c("debug").toString());
    }

    public void playShortVideo(long j, String str) {
        a(c("playShortVideo").addParam("videoId", j).addParam("pageName", str).toString());
    }

    public void enableNotification(String str, String str2) {
        a(c("enableNotification").addParam("userid", str).addParam("area", str2).toString());
    }

    public void messageSetting() {
        a(d("messageSetting").toString());
    }

    public void startCheckUnreadMsg() {
        a(d("startCheck").toString());
    }

    public void stopCheckUnreadMsg() {
        a(d("stopCheck").toString());
    }

    public void addXLLiveRoute(IXLLiveRoute iXLLiveRoute) {
        RouteDispatcher.getInstance().addXLLiveRoute(iXLLiveRoute);
    }

    public boolean dispatch(String str, String str2) {
        return RouteDispatcher.getInstance().dispatch(str, str2);
    }

    private boolean a(String str) {
        return dispatch("tdlive", str);
    }

    private UriBuilder b(String str) {
        return new UriBuilder("tdlive", str);
    }

    private UriBuilder c(String str) {
        return new UriBuilder("shortvideo", str);
    }

    private UriBuilder d(String str) {
        return new UriBuilder("msgcenter", str);
    }
}
