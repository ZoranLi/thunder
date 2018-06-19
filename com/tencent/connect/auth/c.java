package com.tencent.connect.auth;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.connect.a.a;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import com.tencent.tauth.IUiListener;
import com.xiaomi.push.service.av;
import java.io.File;

/* compiled from: ProGuard */
public class c {
    private AuthAgent a = new AuthAgent(this.b);
    private QQToken b;

    private c(String str, Context context) {
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --start");
        this.b = new QQToken(str);
        a.c(context, this.b);
        f.c("openSDK_LOG.QQAuth", "new QQAuth() --end");
    }

    public static c a(String str, Context context) {
        d.a(context.getApplicationContext());
        f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance() --start");
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 0);
            packageManager.getActivityInfo(new ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 0);
            c cVar = new c(str, context);
            f.c("openSDK_LOG.QQAuth", "QQAuth -- createInstance()  --end");
            return cVar;
        } catch (String str2) {
            f.b("openSDK_LOG.QQAuth", "createInstance() error --end", str2);
            Toast.makeText(context.getApplicationContext(), "请参照文档在Androidmanifest.xml加上AuthActivity和AssitActivity的定义 ", 1).show();
            return null;
        }
    }

    public int a(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQAuth", "login()");
        return a(activity, str, iUiListener, "");
    }

    public int a(Activity activity, String str, IUiListener iUiListener, String str2) {
        StringBuilder stringBuilder = new StringBuilder("-->login activity: ");
        stringBuilder.append(activity);
        f.c("openSDK_LOG.QQAuth", stringBuilder.toString());
        return a(activity, null, str, iUiListener, str2);
    }

    public int a(Fragment fragment, String str, IUiListener iUiListener, String str2) {
        Activity activity = fragment.getActivity();
        StringBuilder stringBuilder = new StringBuilder("-->login activity: ");
        stringBuilder.append(activity);
        f.c("openSDK_LOG.QQAuth", stringBuilder.toString());
        return a(activity, fragment, str, iUiListener, str2);
    }

    private int a(Activity activity, Fragment fragment, String str, IUiListener iUiListener, String str2) {
        str2 = activity.getApplicationContext().getPackageName();
        for (ApplicationInfo applicationInfo : activity.getPackageManager().getInstalledApplications(128)) {
            if (str2.equals(applicationInfo.packageName)) {
                str2 = applicationInfo.sourceDir;
                break;
            }
        }
        str2 = null;
        if (str2 != null) {
            try {
                String a = com.tencent.open.utils.a.a(new File(str2));
                if (TextUtils.isEmpty(a) == null) {
                    StringBuilder stringBuilder = new StringBuilder("-->login channelId: ");
                    stringBuilder.append(a);
                    f.a("openSDK_LOG.QQAuth", stringBuilder.toString());
                    return a(activity, str, iUiListener, a, a, "");
                }
            } catch (String str22) {
                f.b("openSDK_LOG.QQAuth", "-->login get channel id exception.", str22);
                str22.printStackTrace();
            }
        }
        f.b("openSDK_LOG.QQAuth", "-->login channelId is null ");
        BaseApi.isOEM = null;
        return this.a.doLogin(activity, str, iUiListener, false, fragment);
    }

    @Deprecated
    public int a(Activity activity, String str, IUiListener iUiListener, String str2, String str3, String str4) {
        f.c("openSDK_LOG.QQAuth", "loginWithOEM");
        BaseApi.isOEM = true;
        if (str2.equals("")) {
            str2 = "null";
        }
        if (str3.equals("")) {
            str3 = "null";
        }
        if (str4.equals("")) {
            str4 = "null";
        }
        BaseApi.installChannel = str3;
        BaseApi.registerChannel = str2;
        BaseApi.businessId = str4;
        return this.a.doLogin(activity, str, iUiListener);
    }

    public int b(Activity activity, String str, IUiListener iUiListener) {
        f.c("openSDK_LOG.QQAuth", "reAuth()");
        return this.a.doLogin(activity, str, iUiListener, true, null);
    }

    public void a() {
        this.a.a(null);
    }

    public void a(IUiListener iUiListener) {
        this.a.b(iUiListener);
    }

    public QQToken b() {
        return this.b;
    }

    public void a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("setAccessToken(), validTimeInSecond = ");
        stringBuilder.append(str2);
        f.a("openSDK_LOG.QQAuth", stringBuilder.toString());
        this.b.setAccessToken(str, str2);
    }

    public boolean c() {
        String str = "openSDK_LOG.QQAuth";
        StringBuilder stringBuilder = new StringBuilder("isSessionValid(), result = ");
        stringBuilder.append(this.b.isSessionValid() ? "true" : av.b);
        f.a(str, stringBuilder.toString());
        return this.b.isSessionValid();
    }

    public void a(Context context, String str) {
        f.a("openSDK_LOG.QQAuth", "setOpenId() --start");
        this.b.setOpenId(str);
        a.d(context, this.b);
        f.a("openSDK_LOG.QQAuth", "setOpenId() --end");
    }
}
