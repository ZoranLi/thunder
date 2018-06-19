package com.alibaba.sdk.android.feedback.xblink.f;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.f.a.a;
import com.alibaba.sdk.android.feedback.xblink.f.a.b;
import com.alibaba.sdk.android.feedback.xblink.f.a.e;
import com.alibaba.sdk.android.feedback.xblink.f.a.f;
import com.alibaba.sdk.android.feedback.xblink.f.a.h;
import com.alibaba.sdk.android.feedback.xblink.f.a.i;
import com.alibaba.sdk.android.feedback.xblink.f.a.j;
import com.alibaba.sdk.android.feedback.xblink.f.a.p;
import com.alibaba.sdk.android.feedback.xblink.f.a.t;
import com.alibaba.sdk.android.feedback.xblink.f.a.u;
import com.alibaba.sdk.android.feedback.xblink.f.a.y;
import com.alibaba.sdk.android.feedback.xblink.f.b.d;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;
import com.alipay.sdk.cons.c;
import java.util.HashMap;
import java.util.Map;

public class k {
    private static final Map a = new HashMap();
    private static final Map b = new HashMap();

    public static a a(String str, Context context, XBHybridWebView xBHybridWebView) {
        l lVar = (l) a.get(str);
        if (lVar != null) {
            String a = lVar.a();
            if (!TextUtils.isEmpty(a)) {
                try {
                    ClassLoader b = lVar.b();
                    Class cls = b == null ? Class.forName(a) : b.loadClass(a);
                    if (cls != null && a.class.isAssignableFrom(cls)) {
                        a aVar = (a) cls.newInstance();
                        aVar.a(context, xBHybridWebView);
                        return aVar;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    StringBuilder stringBuilder = new StringBuilder("create plugin error: ");
                    stringBuilder.append(str);
                    stringBuilder.append(". ");
                    stringBuilder.append(e.getMessage());
                    g.b("WVPluginManager", stringBuilder.toString());
                }
                if (g.a()) {
                    StringBuilder stringBuilder2 = new StringBuilder("create plugin failed: ");
                    stringBuilder2.append(str);
                    g.e("WVPluginManager", stringBuilder2.toString());
                }
                return null;
            }
        }
        if (g.a()) {
            stringBuilder2 = new StringBuilder("create plugin failed, plugin not register or empty, ");
            stringBuilder2.append(str);
            g.e("WVPluginManager", stringBuilder2.toString());
        }
        return null;
    }

    public static Map a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                Map map = b;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("::");
                stringBuilder.append(str2);
                str = (String) map.get(stringBuilder.toString());
                if (!TextUtils.isEmpty(str)) {
                    int indexOf = str.indexOf("::");
                    if (indexOf > 0) {
                        String substring = str.substring(0, indexOf);
                        str = str.substring(indexOf + 2);
                        Map hashMap = new HashMap();
                        hashMap.put(c.e, substring);
                        hashMap.put("method", str);
                        return hashMap;
                    }
                }
                return null;
            }
        }
        g.e("WVPluginManager", "getOriginalPlugin failed, alias is empty.");
        return null;
    }

    public static void a() {
        a("Base", a.class);
        a("WXBase", com.alibaba.sdk.android.feedback.xblink.f.b.c.class);
        a("WXApp", com.alibaba.sdk.android.feedback.xblink.f.b.a.class);
        a("WXCommunication", d.class);
        a("WXPageAction", "createNewPage", "WXApp", "createNewPage");
        a("WXCamera", "takePhoto", "WVCamera", "takePhoto");
        a("WXCamera", "photoReduce", "WVCamera", "photoReduce");
        a("WXCamera", "confirmUploadPhoto", "WVCamera", "confirmUploadPhoto");
        a("WXPhoto", u.class);
        a("WXMediaRecorder", p.class);
        a("WXMediaPlayer", com.alibaba.sdk.android.feedback.xblink.f.a.k.class);
        a("WXDevice", com.alibaba.sdk.android.feedback.xblink.f.a.d.class);
        a("WXFeedBack", com.alibaba.sdk.android.feedback.xblink.f.a.g.class);
        a("WXLogin", j.class);
        a("WXMsg", t.class);
        a("WXLog", i.class);
        a("WXTrack", y.class);
        a("WVToolBarManager", b.class);
        a("WXErrorPage", f.class);
        a("WXEncriptionTool", e.class);
        a("WXKeyboard", h.class);
    }

    public static void a(String str, Class cls) {
        a(str, cls, false);
    }

    public static void a(String str, Class cls, boolean z) {
        if (!TextUtils.isEmpty(str) && cls != null) {
            ClassLoader classLoader = null;
            if (z) {
                classLoader = cls.getClassLoader();
            }
            a.put(str, new l(cls.getName(), classLoader));
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        if (a.containsKey(str3) && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                if (!(TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4))) {
                    Map map = b;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("::");
                    stringBuilder.append(str2);
                    str = stringBuilder.toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str3);
                    stringBuilder2.append("::");
                    stringBuilder2.append(str4);
                    map.put(str, stringBuilder2.toString());
                }
                return;
            }
        }
        g.e("WVPluginManager", "registerAlias quit, this is no original plugin or alias is invalid.");
    }
}
