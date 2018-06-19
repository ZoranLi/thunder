package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzonePublish;
import com.tencent.connect.share.QzoneShare;
import com.tencent.open.SocialApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.HttpUtils.HttpStatusException;
import com.tencent.open.utils.HttpUtils.NetworkUnavailableException;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static Tencent b;
    private final c a;

    public void releaseResource() {
    }

    private Tencent(String str, Context context) {
        this.a = c.a(str, context);
    }

    public static synchronized Tencent createInstance(String str, Context context) {
        synchronized (Tencent.class) {
            d.a(context.getApplicationContext());
            StringBuilder stringBuilder = new StringBuilder("createInstance()  -- start, appId = ");
            stringBuilder.append(str);
            f.c("openSDK_LOG.Tencent", stringBuilder.toString());
            if (b == null) {
                b = new Tencent(str, context);
            } else if (!str.equals(b.getAppId())) {
                b.logout(context);
                b = new Tencent(str, context);
            }
            if (a(context, str)) {
                e.a(context, str);
                f.c("openSDK_LOG.Tencent", "createInstance()  -- end");
                str = b;
                return str;
            }
            return null;
        }
    }

    private static boolean a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x004e }
        r2 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x004e }
        r3 = "com.tencent.tauth.AuthActivity";	 Catch:{ NameNotFoundException -> 0x004e }
        r1.<init>(r2, r3);	 Catch:{ NameNotFoundException -> 0x004e }
        r2 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x004e }
        r2.getActivityInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x004e }
        r5 = new android.content.ComponentName;	 Catch:{ NameNotFoundException -> 0x0027 }
        r1 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x0027 }
        r2 = "com.tencent.connect.common.AssistActivity";	 Catch:{ NameNotFoundException -> 0x0027 }
        r5.<init>(r1, r2);	 Catch:{ NameNotFoundException -> 0x0027 }
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0027 }
        r4.getActivityInfo(r5, r0);	 Catch:{ NameNotFoundException -> 0x0027 }
        r4 = 1;
        return r4;
    L_0x0027:
        r4 = "没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r4);
        r4 = "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>";
        r5.append(r4);
        r4 = r5.toString();
        r5 = "openSDK_LOG.Tencent";
        r1 = new java.lang.StringBuilder;
        r2 = "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        com.tencent.open.a.f.e(r5, r4);
        return r0;
    L_0x004e:
        r4 = new java.lang.StringBuilder;
        r1 = "没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent";
        r4.<init>(r1);
        r4.append(r5);
        r1 = "\" />,详细信息请查看官网文档.";
        r4.append(r1);
        r4 = r4.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r4);
        r4 = "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent";
        r1.append(r4);
        r1.append(r5);
        r4 = "\" />\n</intent-filter>\n</activity>";
        r1.append(r4);
        r4 = r1.toString();
        r5 = "openSDK_LOG.Tencent";
        r1 = new java.lang.StringBuilder;
        r2 = "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity";
        r1.<init>(r2);
        r1.append(r4);
        r4 = r1.toString();
        com.tencent.open.a.f.e(r5, r4);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tauth.Tencent.a(android.content.Context, java.lang.String):boolean");
    }

    public int login(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("login() with activity, scope is ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(activity, str, iUiListener);
    }

    public int login(Fragment fragment, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("login() with fragment, scope is ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(fragment, str, iUiListener, "");
    }

    public int loginServerSide(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("loginServerSide() with activity, scope = ");
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        c cVar = this.a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        return cVar.a(activity, stringBuilder.toString(), iUiListener);
    }

    public int loginServerSide(Fragment fragment, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("loginServerSide() with fragment, scope = ");
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        c cVar = this.a;
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(",server_side");
        return cVar.a(fragment, stringBuilder.toString(), iUiListener, "");
    }

    public int loginWithOEM(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("loginWithOEM() with activity, scope = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.a(activity, str, iUiListener, str2, str3, str4);
    }

    public void logout(Context context) {
        f.c("openSDK_LOG.Tencent", "logout()");
        this.a.b().setAccessToken(null, "0");
        this.a.b().setOpenId(null);
    }

    public int reAuth(Activity activity, String str, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("reAuth() with activity, scope = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.Tencent", stringBuilder.toString());
        return this.a.b(activity, str, iUiListener);
    }

    public void reportDAU() {
        this.a.a();
    }

    public void checkLogin(IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "checkLogin()");
        this.a.a(iUiListener);
    }

    public int invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "invite()");
        new SocialApi(this.a.b()).invite(activity, bundle, iUiListener);
        return null;
    }

    public int story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "story()");
        new SocialApi(this.a.b()).story(activity, bundle, iUiListener);
        return null;
    }

    public int gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "gift()");
        new SocialApi(this.a.b()).gift(activity, bundle, iUiListener);
        return null;
    }

    public int ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "ask()");
        new SocialApi(this.a.b()).ask(activity, bundle, iUiListener);
        return null;
    }

    public void requestAsync(String str, Bundle bundle, String str2, IRequestListener iRequestListener, Object obj) {
        f.c("openSDK_LOG.Tencent", "requestAsync()");
        HttpUtils.requestAsync(this.a.b(), d.a(), str, bundle, str2, iRequestListener);
    }

    public JSONObject request(String str, Bundle bundle, String str2) throws IOException, JSONException, NetworkUnavailableException, HttpStatusException {
        f.c("openSDK_LOG.Tencent", "request()");
        return HttpUtils.request(this.a.b(), d.a(), str, bundle, str2);
    }

    public void shareToQQ(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQQ()");
        new QQShare(activity, this.a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "shareToQzone()");
        new QzoneShare(activity, this.a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public void publishToQzone(Activity activity, Bundle bundle, IUiListener iUiListener) {
        f.c("openSDK_LOG.Tencent", "publishToQzone()");
        new QzonePublish(activity, this.a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        f.c("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public static boolean onActivityResultData(int i, int i2, Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder("onActivityResultData() reqcode = ");
        stringBuilder.append(i);
        stringBuilder.append(", resultcode = ");
        stringBuilder.append(i2);
        stringBuilder.append(", data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        return UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public boolean isSessionValid() {
        return this.a.c();
    }

    public String getAppId() {
        return this.a.b().getAppId();
    }

    public String getAccessToken() {
        return this.a.b().getAccessToken();
    }

    public long getExpiresIn() {
        return this.a.b().getExpireTimeInSecond();
    }

    public String getOpenId() {
        return this.a.b().getOpenId();
    }

    @Deprecated
    public void handleLoginData(Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder("handleLoginData() data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static void handleResultData(Intent intent, IUiListener iUiListener) {
        String str = "openSDK_LOG.Tencent";
        StringBuilder stringBuilder = new StringBuilder("handleResultData() data = null ? ");
        boolean z = false;
        stringBuilder.append(intent == null);
        stringBuilder.append(", listener = null ? ");
        if (iUiListener == null) {
            z = true;
        }
        stringBuilder.append(z);
        f.c(str, stringBuilder.toString());
        UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void setAccessToken(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("setAccessToken(), expiresIn = ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.Tencent", stringBuilder.toString());
        this.a.a(str, str2);
    }

    public void setOpenId(String str) {
        f.a("openSDK_LOG.Tencent", "setOpenId() --start");
        this.a.a(d.a(), str);
        f.a("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public boolean isReady() {
        return isSessionValid() && getOpenId() != null;
    }

    public QQToken getQQToken() {
        return this.a.b();
    }

    public boolean isSupportSSOLogin(Activity activity) {
        if ((!i.d((Context) activity) || g.a((Context) activity, Constants.PACKAGE_QQ_PAD) == null) && g.c(activity, "4.1") < 0) {
            if (g.d(activity, "1.1") < null) {
                return null;
            }
        }
        return true;
    }
}
