package com.ut.mini;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.e.c;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.base.UTMIVariables;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import com.ut.mini.internal.UTTeamWork;
import com.ut.mini.plugin.UTPlugin;
import com.ut.mini.plugin.UTPluginMgr;
import com.ut.mini.sdkevents.UTMI1010_2001Event;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class UTAnalytics {
    private static UTAnalytics a;
    private UTTracker f8a;
    private Map<String, UTTracker> u = new HashMap();

    private UTAnalytics() {
        if (VERSION.SDK_INT < 14) {
            UTPlugin uTMI1010_2001Event = new UTMI1010_2001Event();
            UTPluginMgr.getInstance().registerPlugin(uTMI1010_2001Event, false);
            UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event);
            return;
        }
        Object uTMI1010_2001Event2 = new UTMI1010_2001Event();
        UTMCAppStatusRegHelper.registerAppStatusCallbacks(uTMI1010_2001Event2);
        UTMIVariables.getInstance().setUTMI1010_2001EventInstance(uTMI1010_2001Event2);
    }

    public void setContext(Context context) {
        b a = b.a();
        if (context != null) {
            a.a = context;
            SharedPreferences sharedPreferences = a.a.getSharedPreferences("UTCommon", 0);
            Object string = sharedPreferences.getString("_lun", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    a.c = new String(c.a(string.getBytes()), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            Object string2 = sharedPreferences.getString("_luid", "");
            if (!TextUtils.isEmpty(string2)) {
                try {
                    a.e = new String(c.a(string2.getBytes()), "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }
        a.c();
        if (context != null) {
            UTTeamWork.getInstance().initialized();
        }
    }

    public void setAppApplicationInstance(Application application) {
        b a = b.a();
        a.f = application;
        a.c();
        AppMonitor.a(application);
        if (application != null) {
            try {
                application = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128);
                if (!(application == null || application.metaData == null)) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(application.metaData.get("com.alibaba.apmplus.app_key"));
                    Object stringBuilder2 = stringBuilder.toString();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(application.metaData.get("com.alibaba.apmplus.app_secret"));
                    String stringBuilder4 = stringBuilder3.toString();
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(application.metaData.get("com.alibaba.apmplus.authcode"));
                    String stringBuilder6 = stringBuilder5.toString();
                    StringBuilder stringBuilder7 = new StringBuilder();
                    stringBuilder7.append(application.metaData.get("com.alibaba.apmplus.channel"));
                    application = stringBuilder7.toString();
                    if (!TextUtils.isEmpty(stringBuilder2)) {
                        AppMonitor.a(o(), stringBuilder2, stringBuilder4, stringBuilder6);
                    }
                    if (!TextUtils.isEmpty(application)) {
                        AppMonitor.a(application);
                    }
                }
            } catch (Application application2) {
                application2.printStackTrace();
            }
        }
    }

    private boolean o() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = "com.alibaba.wireless.security.open.SecurityGuardManager";	 Catch:{ Exception -> 0x0007 }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0007 }
        r0 = 1;
        goto L_0x0008;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ut.mini.UTAnalytics.o():boolean");
    }

    public static synchronized UTAnalytics getInstance() {
        UTAnalytics uTAnalytics;
        synchronized (UTAnalytics.class) {
            if (a == null) {
                a = new UTAnalytics();
            }
            uTAnalytics = a;
        }
        return uTAnalytics;
    }

    public synchronized UTTracker getDefaultTracker() {
        if (this.f8a == null) {
            this.f8a = new UTTracker();
        }
        if (this.f8a == null) {
            i.b("getDefaultTracker error", "Fatal Error,must call setRequestAuthentication method first.");
        }
        return this.f8a;
    }

    public void setRequestAuthentication(IUTRequestAuthentication iUTRequestAuthentication) {
        if (iUTRequestAuthentication == null) {
            i.b("setRequestAuthentication", "Fatal Error,pRequestAuth must not be null.");
        }
        if (iUTRequestAuthentication instanceof UTBaseRequestAuthentication) {
            AppMonitor.a(false, iUTRequestAuthentication.getAppkey(), ((UTBaseRequestAuthentication) iUTRequestAuthentication).getAppSecret(), null);
        } else {
            AppMonitor.a(true, iUTRequestAuthentication.getAppkey(), null, ((UTSecuritySDKRequestAuthentication) iUTRequestAuthentication).getAuthCode());
        }
    }

    public void setAppVersion(String str) {
        b.a().g = str;
    }

    public synchronized UTTracker getTracker(String str) {
        if (TextUtils.isEmpty(str)) {
            i.b("getTracker", "TrackId is null.");
            return null;
        } else if (this.u.containsKey(str)) {
            return (UTTracker) this.u.get(str);
        } else {
            UTTracker uTTracker = new UTTracker();
            uTTracker.p(str);
            this.u.put(str, uTTracker);
            return uTTracker;
        }
    }

    public void setChannel(String str) {
        AppMonitor.a(str);
    }

    public void turnOnDebug() {
        b.a();
        b.b();
    }

    public void updateUserAccount(String str, String str2) {
        b a = b.a();
        a.b = str;
        if (!TextUtils.isEmpty(str)) {
            a.c = str;
        }
        if (!(TextUtils.isEmpty(str) || a.a == null)) {
            try {
                Editor edit = a.a.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_lun", new String(c.c(str.getBytes("UTF-8"))));
                edit.commit();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        a.d = str2;
        if (!TextUtils.isEmpty(str2)) {
            a.e = str2;
        }
        if (!(TextUtils.isEmpty(str2) || a.a == null)) {
            try {
                Editor edit2 = a.a.getSharedPreferences("UTCommon", 0).edit();
                edit2.putString("_luid", new String(c.c(str2.getBytes("UTF-8"))));
                edit2.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            getInstance().getDefaultTracker().send(new UTOriginalCustomHitBuilder("UT", 1007, str, str2, null, null).build());
        }
    }

    public void userRegister(String str) {
        if (TextUtils.isEmpty(str)) {
            i.b("userRegister", "Fatal Error,usernick can not be null or empty!");
            return;
        }
        UTTracker defaultTracker = getDefaultTracker();
        if (defaultTracker != null) {
            defaultTracker.send(new UTOriginalCustomHitBuilder("UT", 1006, str, null, null, null).build());
        } else {
            i.b("Record userRegister event error", "Fatal Error,must call setRequestAuthentication method first.");
        }
    }

    public void updateSessionProperties(Map<String, String> map) {
        Map d = com.alibaba.mtl.log.c.a().d();
        Map hashMap = new HashMap();
        if (d != null) {
            hashMap.putAll(d);
        }
        hashMap.putAll(map);
        com.alibaba.mtl.log.c.a().a(hashMap);
    }

    public void turnOffAutoPageTrack() {
        UTPageHitHelper.getInstance().turnOffAutoPageTrack();
    }
}
