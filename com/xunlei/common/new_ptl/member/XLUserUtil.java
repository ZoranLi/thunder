package com.xunlei.common.new_ptl.member;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.xunlei.common.httpclient.BaseHttpClient;
import com.xunlei.common.new_ptl.member.a.d;
import com.xunlei.common.new_ptl.member.a.d.a;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.c.b;
import com.xunlei.xluagc.XLMessageInterface;
import org.json.JSONObject;

public class XLUserUtil {
    private static final XLUserUtil mInstance = new XLUserUtil();

    private XLUserUtil() {
    }

    private p getProxy() {
        return p.a();
    }

    public static XLUserUtil getInstance() {
        return mInstance;
    }

    public Context getContext() {
        return getProxy().h();
    }

    public String getDeviceID() {
        getProxy();
        return p.t();
    }

    public String getAppPackageName() {
        return getProxy().m();
    }

    public int getBusinessType() {
        return getProxy().d();
    }

    public String getVersion() {
        return getProxy().c();
    }

    public int getVersionCode() {
        return getProxy().f();
    }

    public void setHttpClient(BaseHttpClient baseHttpClient) {
        getProxy().a(baseHttpClient);
    }

    public BaseHttpClient getHttpClient() {
        return getProxy().l();
    }

    public XLUserInfo getCurrentUser() {
        return getProxy().i();
    }

    public synchronized void attachListener(XLOnUserListener xLOnUserListener) {
        getProxy().a(xLOnUserListener);
    }

    public synchronized void detachListener(XLOnUserListener xLOnUserListener) {
        getProxy().b(xLOnUserListener);
    }

    public boolean Init(Context context, int i, String str, String str2, String str3, boolean z) {
        return getProxy().a(context, i, str, str2, str3, z);
    }

    public boolean Uninit() {
        return getProxy().b();
    }

    public void setKeepAlive(boolean z, int i) {
        getProxy().a(z, i);
    }

    public void setKeepAliveListener(XLOnUserListener xLOnUserListener) {
        getProxy().c(xLOnUserListener);
    }

    public void clearAutoLoginPassword(boolean z) {
        d.a(getProxy().h(), a.b);
        if (z) {
            p.a().i().clearUserData();
        }
    }

    public void clearStatItems() {
        getProxy().j();
    }

    public void acceptWxCode(int i, String str, int i2) {
        getProxy();
        p.a(i, str, i2);
    }

    public int userAccountLogin(String str, String str2, String str3, String str4, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, str2, str3, str4, xLOnUserListener, obj);
    }

    public int userAutoLogin(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(false, xLOnUserListener, obj);
    }

    public int userLoginWithSessionid(long j, String str, int i, int i2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(j, str, i, i2, xLOnUserListener, obj, false);
    }

    public int userThirdLogin(int i, Object obj, XLOnUserListener xLOnUserListener, Object obj2) {
        return getProxy().a(i, obj, xLOnUserListener, obj2);
    }

    public int userMobileLogin(@NonNull String str, @NonNull String str2, @NonNull String str3, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, str2, str3, xLOnUserListener, obj);
    }

    public int userMobileRegister(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, boolean z, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, str2, str3, str4, z, xLOnUserListener, obj);
    }

    public int userMobileSendMessage(String str, int i, String str2, String str3, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, i, str2, str3, xLOnUserListener, obj);
    }

    public boolean userCancelLogin(int i) {
        getProxy();
        return p.p();
    }

    public int userLogout(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().f(xLOnUserListener, obj);
    }

    public int userGetInfo(XLOnUserListener xLOnUserListener, Object obj) {
        return userGetInfo(xLOnUserListener, 2, obj);
    }

    public int userGetInfo(XLOnUserListener xLOnUserListener, int i, Object obj) {
        return userGetInfo(xLOnUserListener, obj, i);
    }

    public int userSetInfo(JSONObject jSONObject, String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(jSONObject, str, str2, xLOnUserListener, obj);
    }

    public int userGetCityInfo(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().b(xLOnUserListener, obj);
    }

    public int userGetCityCodeByIp(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().c(xLOnUserListener, obj);
    }

    public int userGetHighSpeedCapacity(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().d(xLOnUserListener, obj);
    }

    public int userGetLixianCapacity(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().e(xLOnUserListener, obj);
    }

    public int userGetVerifyCode(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().g(xLOnUserListener, obj);
    }

    public int userPreVerifyCode(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, str2, xLOnUserListener, obj);
    }

    public int userVerifyCode(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().b(str, str2, xLOnUserListener, obj);
    }

    public int userGetRecommendAvatars(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().h(xLOnUserListener, obj);
    }

    public int userSelectRecommendAvatar(int i, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(i, xLOnUserListener, obj);
    }

    public int userSetAvatar(Bitmap bitmap, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(bitmap, xLOnUserListener, obj);
    }

    public boolean userIsLogined() {
        return getProxy().q();
    }

    public boolean userIsOnline() {
        return getProxy().r();
    }

    public boolean userIsQRCodeLoginAuthReq(String str) {
        getProxy();
        return p.a(str);
    }

    public int userQRCodeLoginAuth(String str, XLQRCodeAuthHandler xLQRCodeAuthHandler, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, xLQRCodeAuthHandler, xLOnUserListener, obj);
    }

    public int userGetQRCode(int i, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().b(i, xLOnUserListener, obj);
    }

    public int userQRCodeLogin(String str, int i, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, i, xLOnUserListener, obj);
    }

    public int userGetBindedOtherAccount(XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().i(xLOnUserListener, obj);
    }

    public int userBindOtherAccount(int i, String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(i, str, str2, xLOnUserListener, obj);
    }

    public int userGetOtherAccountInfo(int i, String str, Object obj, XLOnUserListener xLOnUserListener, Object obj2) {
        return getProxy().a(i, str, obj, xLOnUserListener, obj2);
    }

    public int userUnBindOtherAccount(int i, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().c(i, xLOnUserListener, obj);
    }

    public int userAqSendMessage(String str, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(str, xLOnUserListener, obj);
    }

    public int userAqBindMobile(String str, String str2, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().c(str, str2, xLOnUserListener, obj);
    }

    public int userRegAqModifyPassWordJSInterface(WebView webView, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().a(webView, xLOnUserListener, obj);
    }

    public int userRegAqBindMobileJSInterface(WebView webView, XLOnUserListener xLOnUserListener, Object obj) {
        return getProxy().b(webView, xLOnUserListener, obj);
    }

    public void userUnRegisterAqJSInterface(WebView webView) {
        getProxy().a(webView);
    }

    public int userGetInfo(XLOnUserListener xLOnUserListener, Object obj, int... iArr) {
        return getProxy().a(xLOnUserListener, false, obj, iArr);
    }

    public int userOpenMsgChannel(XLMessageInterface xLMessageInterface) {
        b.a(xLMessageInterface, getProxy());
        return null;
    }

    public int userCloseMsgChannel() {
        getProxy();
        return p.s();
    }
}
